package kg.infosystems.buhproject.screen.documents.uvol1nenie;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Profsoyuz;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.documents.KadrovoePeremesenie;
import kg.infosystems.buhproject.entity.documents.PriemNaRabotu;
import kg.infosystems.buhproject.entity.documents.Uvol1nenie;
import kg.infosystems.buhproject.entity.enumerations.VidyDvizenijPoProfsouzam;
import kg.infosystems.buhproject.entity.enumerations.VidyKadrovyhSobytij;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaNacalo;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaOkoncanie;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.SECONDS;

@UiController("Uvol1nenie.edit")
@UiDescriptor("uvol1nenie-edit.xml")
@EditedEntityContainer("uvol1nenieDc")
public class Uvol1nenieEdit extends StandardEditor<Uvol1nenie> {
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private DataContext dataContext;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Uvol1nenie uv = getEditedEntity();
        List<Sotrudniki> sotrudnikiList = dataManager.load(Sotrudniki.class)
            .query("select e from informations_Sotrudniki e " +
                "where e.sotrudnik = :sotrudnik and e.organizacia = :organizacia order by e.period desc")
            .parameter("organizacia", uv.getOrganizacia())
            .parameter("sotrudnik", uv.getSotrudnik())
            .fetchPlan("sotrudniki-fetch-plan").list();
        Sotrudniki lastEventSotrudnik = dataManager.create(Sotrudniki.class);
        if (!sotrudnikiList.isEmpty()) lastEventSotrudnik = sotrudnikiList.get(0);
        if (uv.getNomer() == null && (sotrudnikiList.isEmpty() || Objects.equals(lastEventSotrudnik.getVidSobytia().getName(), "Увольнение"))) {
            showNotification("Вы не можете удалить!", "Сотрудник не зарегистрирован или уже удален из регистра", Notifications.NotificationType.ERROR);
            event.preventCommit();
        } else if (!Objects.equals(lastEventSotrudnik.getVidSobytia().getName(), "Увольнение") && periodDifferent(uv.getData(), sotrudnikiList.get(0).getPeriod())) {
            showNotification("Операция не удалась", "Можно провести через сутки", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else if (uv.getRegisterSotrudnika() == null) {
            long size = dataManager.loadValue("select e from Uvol1nenie e", Uvol1nenie.class).list().size();
            getEditedEntity().setNomer(String.valueOf(size));
            lastEventSotrudnik.setDataOkoncanie(uv.getData());
            dataManager.save(lastEventSotrudnik);
            Sotrudniki sotrudnik = setValuesToRegister(dataManager.create(Sotrudniki.class), uv);
            uv.setRegisterSotrudnika(sotrudnik);

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
                planovyeNacisleniaOkoncanies.add(setRegistrNacisleniyaOkoncanie(planovyeNacisleniaOkoncanie, registerSotrudnika, planovyeNacisleniaNacalo1.getVidRasceta(), planovyeNacisleniaNacalo1.getRazmer()));
                dataManager.remove(planovyeNacisleniaNacalo1);
            }
            getEditedEntity().setPlanovyeNacisleniaOkoncanie(planovyeNacisleniaOkoncanies);
        } else {
            lastEventSotrudnik.setDataOkoncanie(uv.getData());
            dataManager.save(lastEventSotrudnik);
            Sotrudniki sotrudnik = setValuesToRegister(uv.getRegisterSotrudnika(), uv);
            uv.setRegisterSotrudnika(sotrudnik);

            /*Меняет дату регистра окончания при изменении документа*/
            List<PlanovyeNacisleniaOkoncanie> planovyeNacisleniaOkoncanies = dataManager.load(PlanovyeNacisleniaOkoncanie.class)
                .query("select e from informations_PlanovyeNacisleniaOkoncanie e where e.uvol1nenie.id = :uvol1nenie ")
                .parameter("uvol1nenie", getEditedEntity().getId()).list();

            for (PlanovyeNacisleniaOkoncanie planovyeNacisleniaOkoncanie : planovyeNacisleniaOkoncanies) {
                planovyeNacisleniaOkoncanie.setPeriod(getEditedEntity().getDataUvol1nenia().minusDays(1));
                dataManager.save(planovyeNacisleniaOkoncanie);
            }
        }

        kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudniki = getEditedEntity().getSotrudnik();
        List<Profsoyuz> listProfsoyuz = sotrudniki.getProfsoyuz();
        if (!listProfsoyuz.isEmpty()) {
            int size = listProfsoyuz.size();
            if (size % 2 != 0) {
                Profsoyuz profsoyuz = dataManager.create(Profsoyuz.class);
                profsoyuz.setDataDvizenia(getEditedEntity().getDataUvol1nenia());
                profsoyuz.setVidDvizenia(dataManager.load(VidyDvizenijPoProfsouzam.class).id(2).one());
                profsoyuz.setSotrudniki(sotrudniki);
                dataManager.save(profsoyuz);
            }
        }
    }

    private Boolean periodDifferent(LocalDateTime a, LocalDateTime b) {
        return SECONDS.between(b, a) < 86400;
    }

    private Sotrudniki setValuesToRegister(Sotrudniki register, Uvol1nenie uv) {
        register.setPeriod(uv.getData());
        register.setNomerStroki(new BigDecimal(uv.getNomer()));
        register.setOrganizacia(uv.getOrganizacia());
        register.setSotrudnik(uv.getSotrudnik());
        register.setVidSobytia(dataManager.loadValue("select v from VidyKadrovyhSobytij v where v.order = 3", VidyKadrovyhSobytij.class).one());
        return register;
    }

    private void showNotification(String caption, String description, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withType(type)
            .withDescription(description)
            .show();
    }

    private PlanovyeNacisleniaOkoncanie setRegistrNacisleniyaOkoncanie(PlanovyeNacisleniaOkoncanie planovyeNacisleniaOkoncanie, Sotrudniki sotrudnik, VidyNacislenij vidyNacislenij, BigDecimal razmer) {
        planovyeNacisleniaOkoncanie.setUvol1nenie(getEditedEntity());
        planovyeNacisleniaOkoncanie.setPeriod(getEditedEntity().getDataUvol1nenia().minusDays(1));
        planovyeNacisleniaOkoncanie.setOrganizacia(sotrudnik.getOrganizacia());
        planovyeNacisleniaOkoncanie.setSotrudnik(sotrudnik.getSotrudnik());
        planovyeNacisleniaOkoncanie.setDolznost1(sotrudnik.getDolznost1());
        planovyeNacisleniaOkoncanie.setPodrazdelenie(sotrudnik.getPodrazdelenie());
        planovyeNacisleniaOkoncanie.setGrafikRaboty(sotrudnik.getGrafikRaboty());
        planovyeNacisleniaOkoncanie.setDataNacalo(sotrudnik.getPeriod());
        planovyeNacisleniaOkoncanie.setVidRasceta(vidyNacislenij);
        planovyeNacisleniaOkoncanie.setRazmer(razmer);
        return planovyeNacisleniaOkoncanie;

    }
}
