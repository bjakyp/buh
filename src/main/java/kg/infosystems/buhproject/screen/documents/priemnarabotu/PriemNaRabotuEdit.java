package kg.infosystems.buhproject.screen.documents.priemnarabotu;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.*;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.documents.PriemNaRabotu;
import kg.infosystems.buhproject.entity.enumerations.VidyDvizenijPoProfsouzam;
import kg.infosystems.buhproject.entity.enumerations.VidyKadrovyhSobytij;
import kg.infosystems.buhproject.entity.parts.documents.PriemNaRabotuNacislenia;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaNacalo;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.SECONDS;

@UiController("PriemNaRabotu.edit")
@UiDescriptor("priem-na-rabotu-edit.xml")
@EditedEntityContainer("priemNaRabotuDc")
public class PriemNaRabotuEdit extends StandardEditor<PriemNaRabotu> {
    @Inject
    private CollectionPropertyContainer<PriemNaRabotuNacislenia> nacisleniaDc;
    @Inject
    private DataContext dataContext;
    @Inject
    private DataManager dataManager;
    @Inject
    private EntityPicker<Dolznosti> dolznost1Field;
    @Inject
    private TextField<BigDecimal> razmerField;
    @Inject
    private DateField<LocalDateTime> periodField;
    @Inject
    private Notifications notifications;

    @Inject
    private EntityPicker<Organizacii> organizaciaField;
    @Inject
    private CheckBox isProfsoyuz;
    private PriemNaRabotu pnr;


    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        List<PriemNaRabotuNacislenia> naRabotuNacislenias1 = nacisleniaDc.getItems();
        List<PriemNaRabotuNacislenia> naRabotuNacislenias = new ArrayList<>(naRabotuNacislenias1);
        if (Boolean.TRUE.equals(isProfsoyuz.getValue()) && getEditedEntity().getSotrudnik() != null && getEditedEntity().getData() != null) {
            kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudniki = getEditedEntity().getSotrudnik();
            List<Profsoyuz> listProfsoyuz = sotrudniki.getProfsoyuz();
            if (!listProfsoyuz.isEmpty()) {
                int size = listProfsoyuz.size();
                if (size % 2 == 0) {
                    Profsoyuz profsoyuz = dataManager.create(Profsoyuz.class);
                    profsoyuz.setDataDvizenia(getEditedEntity().getData());
                    profsoyuz.setVidDvizenia(dataManager.load(VidyDvizenijPoProfsouzam.class).id(1).one());
                    profsoyuz.setSotrudniki(sotrudniki);
                    dataManager.save(profsoyuz);
                }
            }
        }
        for (PriemNaRabotuNacislenia nacislenia : naRabotuNacislenias) {

            if (nacislenia.getVidRasceta() == null || nacislenia.getRazmer() == null) {
                showNotification("Заполните пустые поля!", "Окно 'Прочие начисления'", Notifications.NotificationType.ERROR);
                event.preventCommit();
                return;
            }
        }
        pnr = getEditedEntity();
        List<Sotrudniki> sotrudnikiList = dataManager.load(Sotrudniki.class)
            .query("select e from informations_Sotrudniki e " +
                "where e.sotrudnik = :sotrudnik and e.organizacia = :organizacia order by e.period desc")
            .parameter("organizacia", pnr.getOrganizacia())
            .parameter("sotrudnik", pnr.getSotrudnik())
            .fetchPlan("sotrudniki-fetch-plan").list();
        Sotrudniki lastEventSotrudnik = dataManager.create(Sotrudniki.class);
        if (!sotrudnikiList.isEmpty()) lastEventSotrudnik = sotrudnikiList.get(0);
        if (!sotrudnikiList.isEmpty() && pnr.getNomer() == null && !Objects.equals(lastEventSotrudnik.getVidSobytia().getName(), "Увольнение")) {
            showNotification("Работник уже принят на работу!", "", Notifications.NotificationType.ERROR);
            event.preventCommit();
        } else if (pnr.getRegisterSotrudnika() == null || sotrudnikiList.isEmpty()) {
            long size = dataManager.loadValue("select e from PriemNaRabotu e", PriemNaRabotu.class).list().size();
            getEditedEntity().setNomer(String.valueOf(size));
            Sotrudniki sotrudnik = setValuesToRegister(dataManager.create(Sotrudniki.class), pnr);
            pnr.setRegisterSotrudnika(sotrudnik);

            PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo = dataContext.create(PlanovyeNacisleniaNacalo.class);
            List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacaloList = new ArrayList<>();
            planovyeNacisleniaNacaloList.add(setRegistrNacisleniyaNacalo(planovyeNacisleniaNacalo,
                getEditedEntity().getVidRasceta(), getEditedEntity().getRazmer(), Boolean.TRUE));

            for (PriemNaRabotuNacislenia nacislenia : naRabotuNacislenias) {
                PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo1 = dataContext.create(PlanovyeNacisleniaNacalo.class);
                planovyeNacisleniaNacaloList.add(setRegistrNacisleniyaNacalo(planovyeNacisleniaNacalo1,
                    nacislenia.getVidRasceta(), nacislenia.getRazmer(), Boolean.FALSE));
            }
            getEditedEntity().setPlanovyeNacisleniaNacalo(planovyeNacisleniaNacaloList);
        } else if (Objects.equals(lastEventSotrudnik.getVidSobytia().getName(), "Увольнение") && periodDifferent(pnr.getPeriod(), lastEventSotrudnik.getPeriod())) {
            showNotification("Операция не удалась", "Можно провести через сутки", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else {
            lastEventSotrudnik.setDataOkoncanie(pnr.getPeriod());
            dataManager.save(lastEventSotrudnik);
            Sotrudniki sotrudniki = setValuesToRegister(pnr.getRegisterSotrudnika(), pnr);
            pnr.setRegisterSotrudnika(sotrudniki);

            PriemNaRabotu priemNaRabotu = dataManager.load(PriemNaRabotu.class)
                .query("select e from PriemNaRabotu e where e.id = :id")
                .parameter("id", pnr.getId()).one();

            List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacaloList = new ArrayList<>();
            for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo : priemNaRabotu.getPlanovyeNacisleniaNacalo()) {
                if (planovyeNacisleniaNacalo.getOsnovnoj()) {
                    planovyeNacisleniaNacaloList.add(setRegistrNacisleniyaNacalo(planovyeNacisleniaNacalo, getEditedEntity().getVidRasceta(), getEditedEntity().getRazmer(), Boolean.TRUE));
                    dataManager.save(planovyeNacisleniaNacalo);
                    continue;
                }
                if (naRabotuNacislenias.size() != 0) {
                    planovyeNacisleniaNacaloList.add(setRegistrNacisleniyaNacalo(planovyeNacisleniaNacalo, naRabotuNacislenias.get(0).getVidRasceta(), naRabotuNacislenias.get(0).getRazmer(), Boolean.FALSE));
                    dataManager.save(planovyeNacisleniaNacalo);
                    naRabotuNacislenias.remove(0);
                } else {
                    dataManager.remove(planovyeNacisleniaNacalo);
                }
            }
            if (!naRabotuNacislenias.isEmpty()) {
                for (PriemNaRabotuNacislenia nacislenia : naRabotuNacislenias) {
                    PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo = dataContext.create(PlanovyeNacisleniaNacalo.class);
                    planovyeNacisleniaNacaloList.add(setRegistrNacisleniyaNacalo(planovyeNacisleniaNacalo, nacislenia.getVidRasceta(), nacislenia.getRazmer(), Boolean.FALSE));
                }
            }
            getEditedEntity().setPlanovyeNacisleniaNacalo(planovyeNacisleniaNacaloList);

        }
    }

    private Boolean periodDifferent(LocalDateTime a, LocalDateTime b) {
        return SECONDS.between(b, a) < 86400;
    }

    private Sotrudniki setValuesToRegister(Sotrudniki register, PriemNaRabotu pnr) {
        register.setPeriod(pnr.getPeriod());
        register.setNomerStroki(new BigDecimal(pnr.getNomer()));
        register.setOrganizacia(pnr.getOrganizacia());
        register.setSotrudnik(pnr.getSotrudnik());
        register.setPodrazdelenie(pnr.getPodrazdelenie());
        register.setDolznost1(pnr.getDolznost1());
        register.setZanimaemyhStavok(pnr.getZanimaemyhStavok());
        register.setGrafikRaboty(pnr.getGrafikRaboty());
        register.setIspytatel1nyjSrok(pnr.getIspytatel1nyjSrok());
        register.setKategoriaRabotnikov(pnr.getKategoriaRabotnikov());
        register.setKolvoIjdivencev(pnr.getKolvoIjdivencev());
        register.setVidSobytia(dataManager.load(VidyKadrovyhSobytij.class).id(1).one());
        return register;
    }

    private void showNotification(String caption, String description, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(description)
            .withType(type)
            .show();
    }


    @Subscribe("nacisleniaTable.create")
    public void onNacisleniaTableCreate(Action.ActionPerformedEvent event) {
        PriemNaRabotuNacislenia item = dataContext.create(PriemNaRabotuNacislenia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nacisleniaDc.getDisconnectedItems().size()));
        nacisleniaDc.getMutableItems().add(item);
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

    /*Сохраняем начисления в Плановые Начисления Начало*/
    private PlanovyeNacisleniaNacalo setRegistrNacisleniyaNacalo(PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo, VidyNacislenij vidRasceta, BigDecimal razmer, Boolean aTrue) {
        planovyeNacisleniaNacalo.setPriemNaRabotu(getEditedEntity());
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
        return planovyeNacisleniaNacalo;
    }
}
