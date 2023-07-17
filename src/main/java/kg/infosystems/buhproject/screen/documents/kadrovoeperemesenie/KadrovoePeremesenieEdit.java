package kg.infosystems.buhproject.screen.documents.kadrovoeperemesenie;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.UiComponents;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.DoljnostnieOklady;
import kg.infosystems.buhproject.entity.catalogs.DoljnostnieOkladyDetail1;
import kg.infosystems.buhproject.entity.catalogs.Dolznosti;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.documents.KadrovoePeremesenie;
import kg.infosystems.buhproject.entity.documents.PriemNaRabotu;
import kg.infosystems.buhproject.entity.enumerations.VidyDejstviaNacislenijUderzanij;
import kg.infosystems.buhproject.entity.enumerations.VidyKadrovyhSobytij;
import kg.infosystems.buhproject.entity.parts.documents.KadrovoePeremesenieNacislenia;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaNacalo;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaOkoncanie;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.SECONDS;

@UiController("KadrovoePeremesenie.edit")
@UiDescriptor("kadrovoe-peremesenie-edit.xml")
@EditedEntityContainer("kadrovoePeremesenieDc")
public class KadrovoePeremesenieEdit extends StandardEditor<KadrovoePeremesenie> {
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionPropertyContainer<KadrovoePeremesenieNacislenia> nacisleniaDc;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;
    @Inject
    private VBoxLayout lastValue;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private EntityPicker<Dolznosti> dolznost1Field;
    @Inject
    private DateField<LocalDateTime> periodField;
    @Inject
    private EntityPicker<Organizacii> organizaciaField;
    @Inject
    private TextField<BigDecimal> razmerField;

    private Sotrudniki setValuesToRegister(Sotrudniki register, KadrovoePeremesenie kp) {
        register.setPeriod(kp.getPeriod());
        BigDecimal nomerStroki = kp.getNomer() == null ? null : new BigDecimal(kp.getNomer());
        register.setNomerStroki(nomerStroki);
        register.setOrganizacia(kp.getOrganizacia());
        register.setSotrudnik(kp.getSotrudnik());
        register.setPodrazdelenie(kp.getPodrazdelenie());
        register.setDolznost1(kp.getDolznost1());
        register.setZanimaemyhStavok(kp.getZanimaemyhStavok());
        register.setGrafikRaboty(kp.getGrafikRaboty());
        register.setKategoriaRabotnikov(kp.getKategoriaRabotnikov());
        register.setKolvoIjdivencev(kp.getKolvoIjdivencev());
        register.setVidSobytia(dataManager.loadValue("select v from VidyKadrovyhSobytij v where v.order = 2", VidyKadrovyhSobytij.class).one());
        return register;
    }

    private void showNotification(String caption, String description, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(description)
            .withType(type)
            .show();
    }

    private Boolean periodDifference(LocalDateTime a, LocalDateTime b) {
        return SECONDS.between(b, a) < 86400;
    }


    @Subscribe("nacisleniaTable.create")
    public void onNacisleniaTableCreate(Action.ActionPerformedEvent event) {
        KadrovoePeremesenieNacislenia item = dataContext.create(KadrovoePeremesenieNacislenia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nacisleniaDc.getDisconnectedItems().size()));
        item.setDobavlenoAvtomaticeski(false);
        nacisleniaDc.getMutableItems().add(item);
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        List<KadrovoePeremesenieNacislenia> naRabotuNacislenias1 = nacisleniaDc.getItems();
        List<KadrovoePeremesenieNacislenia> naRabotuNacislenias = new ArrayList<>(naRabotuNacislenias1);


        for (KadrovoePeremesenieNacislenia nacislenia : naRabotuNacislenias) {
            if (nacislenia.getVidRasceta() == null || nacislenia.getRazmer() == null) {
                showNotification("Заполните пустые поля!", "Окно 'Прочие начисления'", Notifications.NotificationType.ERROR);
                event.preventCommit();
                return;
            }
        }


        KadrovoePeremesenie kp = getEditedEntity();
        List<Sotrudniki> sotrudnikiList = dataManager.load(Sotrudniki.class)
            .query("select e from informations_Sotrudniki e " +
                "where e.sotrudnik = :sotrudnik and e.organizacia = :organizacia order by e.period desc")
            .parameter("organizacia", kp.getOrganizacia())
            .parameter("sotrudnik", kp.getSotrudnik())
            .fetchPlan("sotrudniki-fetch-plan").list();
        Sotrudniki lastEventSotrudnik = dataManager.create(Sotrudniki.class);
        if (!sotrudnikiList.isEmpty()) lastEventSotrudnik = sotrudnikiList.get(0);
        if (kp.getNomer() == null && (sotrudnikiList.isEmpty() || Objects.equals(sotrudnikiList.get(0).getVidSobytia().getName(), "Увольнение"))) {
            showNotification("Работник не зарегистрирован!", "", Notifications.NotificationType.ERROR);
            event.preventCommit();

        } else if (periodDifference(kp.getPeriod(), lastEventSotrudnik.getPeriod()) && !Objects.equals(lastEventSotrudnik.getVidSobytia().getName(), "Увольнение")) {
            showNotification("Операция не удалась", "Можно провести через сутки", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else if (kp.getRegisterSotrudnika() == null) {
            long size = dataManager.loadValue("select e from KadrovoePeremesenie e", KadrovoePeremesenie.class).list().size();
            getEditedEntity().setNomer(String.valueOf(size));
            lastEventSotrudnik.setDataOkoncanie(kp.getData());
            dataManager.save(lastEventSotrudnik);
            Sotrudniki sotrudnik1 = setValuesToRegister(dataManager.create(Sotrudniki.class), kp);
            kp.setRegisterSotrudnika(sotrudnik1);

            /* Берем последнее действие этого сотрудника */
            Sotrudniki registerSotrudnika = dataManager.load(Sotrudniki.class)
                .query("select c from informations_Sotrudniki c where c.sotrudnik = :sotrudnik order by c.period desc")
                .parameter("sotrudnik", getEditedEntity().getSotrudnik()).one();
            List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacaloDelete = new ArrayList<>();
            List<PlanovyeNacisleniaOkoncanie> planovyeNacisleniaOkoncanies = new ArrayList<>();

            if (registerSotrudnika.getVidSobytia().getId() == 1) {
                PriemNaRabotu priemNaRabotu = dataManager.load(PriemNaRabotu.class)
                    .query("select e from PriemNaRabotu e where e.registerSotrudnika = :registerSotrudnika order by e.period desc")
                    .parameter("registerSotrudnika", registerSotrudnika).one();
                planovyeNacisleniaNacaloDelete.addAll(priemNaRabotu.getPlanovyeNacisleniaNacalo());
            } else if (registerSotrudnika.getVidSobytia().getId() == 2) {
                KadrovoePeremesenie kadrovoePeremesenie = dataManager.load(KadrovoePeremesenie.class)
                    .query("select e from KadrovoePeremesenie e where e.registerSotrudnika = :registerSotrudnika order by e.period desc")
                    .parameter("registerSotrudnika", registerSotrudnika).one();
                planovyeNacisleniaNacaloDelete.addAll(kadrovoePeremesenie.getPlanovyeNacisleniaNacalo());
            }

            for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo1 : planovyeNacisleniaNacaloDelete) {
                PlanovyeNacisleniaOkoncanie planovyeNacisleniaOkoncanie = dataContext.create(PlanovyeNacisleniaOkoncanie.class);
                planovyeNacisleniaOkoncanie.setAktivnost1(planovyeNacisleniaNacalo1.getAktivnost1());
                planovyeNacisleniaOkoncanies.add(setRegistrNacisleniaOkoncanie(planovyeNacisleniaOkoncanie, registerSotrudnika, planovyeNacisleniaNacalo1.getVidRasceta(), planovyeNacisleniaNacalo1.getRazmer()));
                dataManager.remove(planovyeNacisleniaNacalo1);
            }
            getEditedEntity().setPlanovyeNacisleniaOkoncanie(planovyeNacisleniaOkoncanies);

            /*Сохраняем данные документа в регистр Начало*/
            PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo = dataContext.create(PlanovyeNacisleniaNacalo.class);
            List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacaloList = new ArrayList<>();
            planovyeNacisleniaNacaloList.add(setRegistrNacisleniaNacalo(planovyeNacisleniaNacalo,
                getEditedEntity().getVidRasceta(), getEditedEntity().getRazmer(), Boolean.TRUE));
            for (KadrovoePeremesenieNacislenia nacislenia : naRabotuNacislenias) {
                PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo1 = dataContext.create(PlanovyeNacisleniaNacalo.class);
                planovyeNacisleniaNacaloList.add(setRegistrNacisleniaNacalo(planovyeNacisleniaNacalo1,
                    nacislenia.getVidRasceta(), nacislenia.getRazmer(), Boolean.FALSE));
            }
            getEditedEntity().setPlanovyeNacisleniaNacalo(planovyeNacisleniaNacaloList);

        } else {
            lastEventSotrudnik.setDataOkoncanie(kp.getData());
            dataManager.save(lastEventSotrudnik);
            Sotrudniki sotrudniki1 = setValuesToRegister(kp.getRegisterSotrudnika(), kp);
            kp.setRegisterSotrudnika(sotrudniki1);

            /*Изменяем данные в регистре начислений Начало*/
            KadrovoePeremesenie kadrovoePeremesenie = dataManager.load(KadrovoePeremesenie.class)
                .query("select e from KadrovoePeremesenie e where e.id = :id")
                .parameter("id", kp.getId()).one();

            List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacaloList = new ArrayList<>();
            for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo : kadrovoePeremesenie.getPlanovyeNacisleniaNacalo()) {
                if (planovyeNacisleniaNacalo.getOsnovnoj()) {
                    planovyeNacisleniaNacaloList.add(setRegistrNacisleniaNacalo(planovyeNacisleniaNacalo, getEditedEntity().getVidRasceta(), getEditedEntity().getRazmer(), Boolean.TRUE));
                    dataManager.save(planovyeNacisleniaNacalo);
                    continue;
                }
                if (naRabotuNacislenias.size() != 0) {
                    planovyeNacisleniaNacaloList.add(setRegistrNacisleniaNacalo(planovyeNacisleniaNacalo, naRabotuNacislenias.get(0).getVidRasceta(), naRabotuNacislenias.get(0).getRazmer(), Boolean.FALSE));
                    dataManager.save(planovyeNacisleniaNacalo);
                    naRabotuNacislenias.remove(0);
                } else {
                    dataManager.remove(planovyeNacisleniaNacalo);
                }
            }
            if (!naRabotuNacislenias.isEmpty()) {
                for (KadrovoePeremesenieNacislenia nacislenia : naRabotuNacislenias) {
                    PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo = dataContext.create(PlanovyeNacisleniaNacalo.class);
                    planovyeNacisleniaNacaloList.add(setRegistrNacisleniaNacalo(planovyeNacisleniaNacalo, nacislenia.getVidRasceta(), nacislenia.getRazmer(), Boolean.FALSE));
                }
            }
            getEditedEntity().setPlanovyeNacisleniaNacalo(planovyeNacisleniaNacaloList);
        }
    }

    @Subscribe
    public void onAfterCommitChanges(AfterCommitChangesEvent event) {
        /*Меняет дату регистра окончания при изменении документа*/
        List<PlanovyeNacisleniaOkoncanie> planovyeNacisleniaOkoncanies = dataManager.load(PlanovyeNacisleniaOkoncanie.class)
            .query("select e from informations_PlanovyeNacisleniaOkoncanie e where e.kadrovoePeremesenie.id = :kadrovoePeremesenie ")
            .parameter("kadrovoePeremesenie", getEditedEntity().getId()).list();

        for (PlanovyeNacisleniaOkoncanie planovyeNacisleniaOkoncanie : planovyeNacisleniaOkoncanies) {
            planovyeNacisleniaOkoncanie.setPeriod(getEditedEntity().getPeriod().minusDays(1));
            dataManager.save(planovyeNacisleniaOkoncanie);
        }

    }

    @Subscribe("sotrudnikField")
    public void onSotrudnikFieldValueChange(HasValue.ValueChangeEvent<kg.infosystems.buhproject.entity.catalogs.Sotrudniki> event) {
        if (getEditedEntity().getOrganizacia() != null) {
            predydusieZnacenia();
        }
    }

    @Subscribe("organizaciaField")
    public void onOrganizaciaFieldValueChange(HasValue.ValueChangeEvent<Organizacii> event) {
        if (getEditedEntity().getSotrudnik() != null) {
            predydusieZnacenia();
        }
    }

    private void predydusieZnacenia() {
        try {
            Sotrudniki sotrudnik = dataManager.load(Sotrudniki.class)
                .query("select c from informations_Sotrudniki c where c.sotrudnik = :sotrudnik and " +
                    "c.organizacia = :organizacia order by c.period desc")
                .parameter("sotrudnik", getEditedEntity().getSotrudnik())
                .parameter("organizacia", getEditedEntity().getOrganizacia()).one();

            HBoxLayout vBoxLayout = uiComponents.create(HBoxLayout.NAME);

            Label<String> podrazdelenie = uiComponents.create(Label.NAME);
            podrazdelenie.setValue("Подразделение");
            podrazdelenie.setWidthAuto();
            podrazdelenie.setAlignment(Component.Alignment.MIDDLE_LEFT);

            TextField podrazdelenie1 = uiComponents.create(TextField.NAME);
            podrazdelenie1.setValue(sotrudnik.getPodrazdelenie().getNaimenovanie());
            podrazdelenie1.setWidthAuto();
            podrazdelenie1.setAlignment(Component.Alignment.MIDDLE_LEFT);
            podrazdelenie1.setEditable(false);

            vBoxLayout.addStyleName("peremesenie");
            vBoxLayout.add(podrazdelenie);
            vBoxLayout.add(podrazdelenie1);


            HBoxLayout vBoxLayout2 = uiComponents.create(HBoxLayout.NAME);

            Label<String> dolznost = uiComponents.create(Label.NAME);
            dolznost.setValue("Должность");
            podrazdelenie.setWidthAuto();
            dolznost.setAlignment(Component.Alignment.MIDDLE_LEFT);

            TextField dolznost1 = uiComponents.create(TextField.NAME);
            dolznost1.setValue(sotrudnik.getDolznost1().getNaimenovanie());
            dolznost1.setWidthAuto();
            dolznost1.setAlignment(Component.Alignment.MIDDLE_LEFT);
            dolznost1.setEditable(false);

            vBoxLayout2.addStyleName("peremesenie");
            vBoxLayout2.add(dolznost);
            vBoxLayout2.add(dolznost1);


            HBoxLayout vBoxLayout3 = uiComponents.create(HBoxLayout.NAME);

            Label<String> grafik = uiComponents.create(Label.NAME);
            grafik.setValue("График работы");
            grafik.setWidthAuto();
            grafik.setAlignment(Component.Alignment.MIDDLE_LEFT);

            TextField grafik1 = uiComponents.create(TextField.NAME);
            grafik1.setValue(sotrudnik.getGrafikRaboty().getNaimenovanie());
            grafik1.setWidthAuto();
            grafik1.setAlignment(Component.Alignment.MIDDLE_LEFT);
            grafik1.setEditable(false);

            vBoxLayout3.addStyleName("peremesenie");
            vBoxLayout3.add(grafik);
            vBoxLayout3.add(grafik1);


            HBoxLayout vBoxLayout4 = uiComponents.create(HBoxLayout.NAME);
            HBoxLayout vBoxLayout5 = uiComponents.create(HBoxLayout.NAME);

            Label<String> vidRasceta = uiComponents.create(Label.NAME);
            vidRasceta.setValue("Вид начисления");
            vidRasceta.setWidthAuto();
            vidRasceta.setAlignment(Component.Alignment.MIDDLE_LEFT);


            TextField vidRasceta1 = uiComponents.create(TextField.NAME);
            vidRasceta1.setWidthAuto();
            vidRasceta1.setAlignment(Component.Alignment.MIDDLE_LEFT);
            vidRasceta1.setEditable(false);

            Label<String> razmer = uiComponents.create(Label.NAME);
            razmer.setValue("Размер должностного оклада");
            razmer.setWidthAuto();
            razmer.setAlignment(Component.Alignment.MIDDLE_LEFT);

            TextField razmer1 = uiComponents.create(TextField.NAME);
            razmer1.setWidthAuto();
            razmer1.setAlignment(Component.Alignment.MIDDLE_LEFT);
            razmer1.setEditable(false);

            /*Если предыдущий документ был "Прием на работу"*/
            if (sotrudnik.getVidSobytia().getOrder() == 1) {
                PriemNaRabotu priemNaRabotu = dataManager.load(PriemNaRabotu.class)
                    .query("select c from PriemNaRabotu c where c.organizacia = :organizacia and c.sotrudnik = :sotrudnik and c.period = :period and c.dolznost1 = :dolznost1 and c.podrazdelenie = :podrazdelenie")
                    .parameter("organizacia", sotrudnik.getOrganizacia())
                    .parameter("sotrudnik", sotrudnik.getSotrudnik())
                    .parameter("period", sotrudnik.getPeriod())
                    .parameter("dolznost1", sotrudnik.getDolznost1())
                    .parameter("podrazdelenie", sotrudnik.getPodrazdelenie()).one();
                vidRasceta1.setValue(priemNaRabotu.getVidRasceta().getDescription());
                razmer1.setValue(priemNaRabotu.getRazmer().toString());
            }

            if (sotrudnik.getVidSobytia().getOrder() == 2) {

                KadrovoePeremesenie kadrovoePeremesenie = dataManager.load(KadrovoePeremesenie.class)
                    .query("select c from KadrovoePeremesenie c where c.organizacia = :organizacia and c.sotrudnik = :sotrudnik and c.period = :period and c.dolznost1 = :dolznost1 and c.podrazdelenie = :podrazdelenie")
                    .parameter("organizacia", sotrudnik.getOrganizacia())
                    .parameter("sotrudnik", sotrudnik.getSotrudnik())
                    .parameter("period", sotrudnik.getPeriod())
                    .parameter("dolznost1", sotrudnik.getDolznost1())
                    .parameter("podrazdelenie", sotrudnik.getPodrazdelenie()).one();

                vidRasceta1.setValue(kadrovoePeremesenie.getVidRasceta().getDescription());
                razmer1.setValue(kadrovoePeremesenie.getRazmer().toString());

            }
            vBoxLayout4.addStyleName("peremesenie");
            vBoxLayout4.add(vidRasceta);
            vBoxLayout4.add(vidRasceta1);

            vBoxLayout5.addStyleName("peremesenie");
            vBoxLayout5.add(razmer);
            vBoxLayout5.add(razmer1);


            HBoxLayout vBoxLayout6 = uiComponents.create(HBoxLayout.NAME);
            Label<String> zanimaemyhStavok = uiComponents.create(Label.NAME);
            zanimaemyhStavok.setValue("Занимаемых ставок");
            zanimaemyhStavok.setWidthAuto();
            zanimaemyhStavok.setAlignment(Component.Alignment.MIDDLE_LEFT);

            TextField zanimaemyhStavok1 = uiComponents.create(TextField.NAME);
            zanimaemyhStavok1.setValue(sotrudnik.getZanimaemyhStavok().toString());
            zanimaemyhStavok1.setWidthAuto();
            zanimaemyhStavok1.setAlignment(Component.Alignment.MIDDLE_LEFT);
            zanimaemyhStavok1.setEditable(false);

            vBoxLayout6.addStyleName("peremesenie");
            vBoxLayout6.add(zanimaemyhStavok);
            vBoxLayout6.add(zanimaemyhStavok1);

            HBoxLayout vBoxLayout7 = uiComponents.create(HBoxLayout.NAME);
            Label<String> kategoriaRabotnikov = uiComponents.create(Label.NAME);
            kategoriaRabotnikov.setValue("Категория работника");
            kategoriaRabotnikov.setWidthAuto();
            kategoriaRabotnikov.setAlignment(Component.Alignment.MIDDLE_LEFT);

            TextField kategoriaRabotnikov1 = uiComponents.create(TextField.NAME);
            kategoriaRabotnikov1.setValue(sotrudnik.getKategoriaRabotnikov().toString());
            kategoriaRabotnikov1.setWidthAuto();
            kategoriaRabotnikov1.setAlignment(Component.Alignment.MIDDLE_LEFT);
            kategoriaRabotnikov1.setEditable(false);

            vBoxLayout7.addStyleName("peremesenie");
            vBoxLayout7.add(kategoriaRabotnikov);
            vBoxLayout7.add(kategoriaRabotnikov1);

            HBoxLayout vBoxLayout8 = uiComponents.create(HBoxLayout.NAME);
            Label<String> kolvoIjdivencev = uiComponents.create(Label.NAME);
            kolvoIjdivencev.setValue("Кол-во иждивенцев");
            kolvoIjdivencev.setWidthAuto();
            kolvoIjdivencev.setAlignment(Component.Alignment.MIDDLE_LEFT);

            TextField kolvoIjdivencev1 = uiComponents.create(TextField.NAME);
            kolvoIjdivencev1.setValue(sotrudnik.getKolvoIjdivencev().toString());
            kolvoIjdivencev1.setWidthAuto();
            kolvoIjdivencev1.setAlignment(Component.Alignment.MIDDLE_LEFT);
            kolvoIjdivencev1.setEditable(false);

            vBoxLayout8.addStyleName("peremesenie");
            vBoxLayout8.add(kolvoIjdivencev);
            vBoxLayout8.add(kolvoIjdivencev1);

            Label<String> value1 = uiComponents.create(Label.NAME);
            value1.setValue("Предыдущие значения");
            value1.setStyleName("lastValue1");

            lastValue.removeAll();
            lastValue.add(value1);
            lastValue.add(vBoxLayout);
            lastValue.add(vBoxLayout2);
            lastValue.add(vBoxLayout3);
            lastValue.add(vBoxLayout4);
            lastValue.add(vBoxLayout5);
            lastValue.add(vBoxLayout6);
            lastValue.add(vBoxLayout7);
            lastValue.add(vBoxLayout8);

//                      Выводит зависимые начисления в редактировании кадрового перемещения
            List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacaloList = dataManager.load(PlanovyeNacisleniaNacalo.class)
                .query("select c from informations_PlanovyeNacisleniaNacalo c where c.period = :period and c.organizacia = :organizacia and c.sotrudnik = :sotrudnik")
                .parameter("period", sotrudnik.getPeriod())
                .parameter("organizacia", sotrudnik.getOrganizacia())
                .parameter("sotrudnik", sotrudnik.getSotrudnik()).list();

            if (nacisleniaDc.getItems().isEmpty())
                for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo : planovyeNacisleniaNacaloList) {
                    if (!planovyeNacisleniaNacalo.getOsnovnoj()) {
                        KadrovoePeremesenieNacislenia kadrovoePeremesenieNacislenia = dataContext.create(KadrovoePeremesenieNacislenia.class);
                        kadrovoePeremesenieNacislenia.setPart(getEditedEntity());
                        VidyDejstviaNacislenijUderzanij v = dataManager.load(VidyDejstviaNacislenijUderzanij.class).id(3).one();
                        kadrovoePeremesenieNacislenia.setVidDejstvia(v);
                        kadrovoePeremesenieNacislenia.setVidRasceta(planovyeNacisleniaNacalo.getVidRasceta());
                        kadrovoePeremesenieNacislenia.setRazmer(planovyeNacisleniaNacalo.getRazmer());
                        nacisleniaDc.getMutableItems().add(kadrovoePeremesenieNacislenia);
                    }
                }


        } catch (Exception e) {
            notifications.create()
                .withCaption("У этого работника нет предыдущих значений")
                .withDescription("Предупреждение")
                .withType(Notifications.NotificationType.ERROR)
                .show();
        }
    }

    /*Функция сохранения регистра начислений Начало*/
    private PlanovyeNacisleniaNacalo setRegistrNacisleniaNacalo(PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo, VidyNacislenij vidRasceta, BigDecimal razmer, Boolean aTrue) {
//        SaveContext saveContext = new SaveContext();
        planovyeNacisleniaNacalo.setKadrovoePeremesenie(getEditedEntity());
        planovyeNacisleniaNacalo.setPeriod(getEditedEntity().getPeriod());
        planovyeNacisleniaNacalo.setOrganizacia(getEditedEntity().getOrganizacia());
        planovyeNacisleniaNacalo.setSotrudnik(getEditedEntity().getSotrudnik());
        planovyeNacisleniaNacalo.setVidRasceta(vidRasceta);
        planovyeNacisleniaNacalo.setRazmer(razmer);
        planovyeNacisleniaNacalo.setOsnovnoj(aTrue);
        planovyeNacisleniaNacalo.setPodrazdelenie(getEditedEntity().getPodrazdelenie());
        planovyeNacisleniaNacalo.setDolznost1(getEditedEntity().getDolznost1());
        planovyeNacisleniaNacalo.setGrafikRaboty(getEditedEntity().getGrafikRaboty());
        planovyeNacisleniaNacalo.setKolvoIjdivencev(getEditedEntity().getKolvoIjdivencev());
        planovyeNacisleniaNacalo.setKategoriaRabotnikov(getEditedEntity().getKategoriaRabotnikov());
//        saveContext.saving(planovyeNacisleniaNacalo);
//        dataManager.save(saveContext);

        return planovyeNacisleniaNacalo;
    }

    /*Функция сохранения регистра начислений Окончание*/
    private PlanovyeNacisleniaOkoncanie setRegistrNacisleniaOkoncanie(PlanovyeNacisleniaOkoncanie planovyeNacisleniaOkoncanie, Sotrudniki sotrudnik, VidyNacislenij vidyNacislenij, BigDecimal razmer) {
        planovyeNacisleniaOkoncanie.setKadrovoePeremesenie(getEditedEntity());
        planovyeNacisleniaOkoncanie.setPeriod(getEditedEntity().getPeriod().minusDays(1));
        planovyeNacisleniaOkoncanie.setOrganizacia(sotrudnik.getOrganizacia());
        planovyeNacisleniaOkoncanie.setDolznost1(sotrudnik.getDolznost1());
        planovyeNacisleniaOkoncanie.setPodrazdelenie(sotrudnik.getPodrazdelenie());
        planovyeNacisleniaOkoncanie.setGrafikRaboty(sotrudnik.getGrafikRaboty());
        planovyeNacisleniaOkoncanie.setDataNacalo(sotrudnik.getPeriod());
        planovyeNacisleniaOkoncanie.setSotrudnik(sotrudnik.getSotrudnik());
        planovyeNacisleniaOkoncanie.setVidRasceta(vidyNacislenij);
        planovyeNacisleniaOkoncanie.setRazmer(razmer);
        planovyeNacisleniaOkoncanie.setKolvoIjdivencev(sotrudnik.getKolvoIjdivencev());
        planovyeNacisleniaOkoncanie.setKategoriaRabotnikov(sotrudnik.getKategoriaRabotnikov());
        return planovyeNacisleniaOkoncanie;

    }


    @Subscribe("dolznost1Field")
    public void onDolznost1FieldValueChange(HasValue.ValueChangeEvent<Dolznosti> event) {
        checkFields();
    }

    @Subscribe("periodField")
    public void onPeriodFieldValueChange(HasValue.ValueChangeEvent<LocalDateTime> event) {
        checkFields();
    }

    @Subscribe("organizaciaField")
    public void onOrganizaciaFieldFieldValueChange(ValuePicker.FieldValueChangeEvent<Organizacii> event) {
        checkFields();
    }

    private void checkFields() {
        Dolznosti dolznosti = dolznost1Field.getValue();
        LocalDateTime period = periodField.getValue();
        Organizacii organizacii = organizaciaField.getValue();
        if (dolznosti == null || period == null || organizacii == null) return;
        BigDecimal summa = summaOfDolznosti(dolznosti, period, organizacii);
        razmerField.setValue(summa);
    }


    private BigDecimal summaOfDolznosti(Dolznosti dolznosti, LocalDateTime period, Organizacii organizacii) {

        List<DoljnostnieOklady> doljnostnieOkladyList = dataManager.load(DoljnostnieOklady.class)
            .query("select e from DoljnostnieOklady e " +
                "where e.organizasia = :organizacia order by e.date asc")
            .parameter("organizacia", organizacii).list();
        if (doljnostnieOkladyList.size() == 0) {
            showNotification("Должностные оклады для этой организации не созданы!", "", Notifications.NotificationType.ERROR);
            return new BigDecimal(0);
        }
        int year = period.getYear();
        int month = period.getMonthValue();
        int dayOfMonth = period.getDayOfMonth();
        String stringDate = dayOfMonth + "/" + month + "/" + year;
        Date date = new Date();
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        } catch (ParseException e) {
            System.out.println(e);
        }
        Set<DoljnostnieOkladyDetail1> detail1List1 = new HashSet<>();
        if (date.before(doljnostnieOkladyList.get(0).getDate())) {
            showNotification("Должностные оклады для этой даты не назначены", "", Notifications.NotificationType.ERROR);
            return new BigDecimal(0);
        }
        if (doljnostnieOkladyList.size() > 1) {
            for (int i = 0; i < doljnostnieOkladyList.size() - 1; i++) {
                if ((date.after(doljnostnieOkladyList.get(i).getDate()) || doljnostnieOkladyList.get(i).getDate().equals(date))
                    && date.before(doljnostnieOkladyList.get(i + 1).getDate())) {
                    detail1List1 = new HashSet<>(doljnostnieOkladyList.get(i).getDetail1());
                } else if (date.after(doljnostnieOkladyList.get(i + 1).getDate()) || date.equals(doljnostnieOkladyList.get(i + 1).getDate())) {
                    detail1List1 = new HashSet<>(doljnostnieOkladyList.get(i + 1).getDetail1());
                }
            }
        } else {
            if (date.after(doljnostnieOkladyList.get(0).getDate()) || doljnostnieOkladyList.get(0).getDate().equals(date)) {
                detail1List1 = new HashSet<>(doljnostnieOkladyList.get(0).getDetail1());
            }
        }
        for (DoljnostnieOkladyDetail1 detail1 : detail1List1) {
            if (detail1.getDoljnost().equals(dolznosti)) {
                return detail1.getSumma();
            }
        }
        showNotification("Должностные оклады для данной должности не назначены", "", Notifications.NotificationType.ERROR);
        return new BigDecimal(0);
    }

}
