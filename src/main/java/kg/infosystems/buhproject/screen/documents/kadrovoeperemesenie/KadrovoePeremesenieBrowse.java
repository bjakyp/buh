package kg.infosystems.buhproject.screen.documents.kadrovoeperemesenie;

import com.haulmont.yarg.reporting.ReportOutputDocument;
import io.jmix.reports.entity.Report;
import io.jmix.reports.entity.ReportOutputType;
import io.jmix.reports.entity.ReportTemplate;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.action.list.RefreshAction;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.DialogOutcome;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.download.DownloadFormat;
import io.jmix.ui.icon.JmixIcon;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.KadrovoePeremesenie;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaNacalo;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;
import kg.infosystems.buhproject.screen.base.BaseReportScreen;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

@UiController("KadrovoePeremesenie.browse")
@UiDescriptor("kadrovoe-peremesenie-browse.xml")
@LookupComponent("kadrovoePeremeseniesTable")
public class KadrovoePeremesenieBrowse extends BaseReportScreen<KadrovoePeremesenie> {
    @Inject
    private GroupTable<KadrovoePeremesenie> kadrovoePeremeseniesTable;

    @Named("kadrovoePeremeseniesTable.refresh")
    private RefreshAction kadrovoePeremeseniesTableRefresh;

    private KadrovoePeremesenie kadrovoePeremesenie;


    private Boolean checkLastEvent() {
        kadrovoePeremesenie = kadrovoePeremeseniesTable.getSingleSelected();
        List<Sotrudniki> sotrudnikiList = dataManager.loadValue("select e from informations_Sotrudniki e " +
                "where e.sotrudnik = :sotrudnik and e.organizacia = :organizacia order by e.period desc", Sotrudniki.class)
            .parameter("sotrudnik", kadrovoePeremesenie.getSotrudnik())
            .parameter("organizacia", kadrovoePeremesenie.getOrganizacia())
            .list();
        if (sotrudnikiList.isEmpty() || kadrovoePeremesenie.getRegisterSotrudnika() == null) {
            showNotification("Работник не записан в регистр",
                "", Notifications.NotificationType.ERROR);
            return false;
        } else if (Objects.equals(sotrudnikiList.get(0).getId(), kadrovoePeremesenie.getRegisterSotrudnika().getId())) return true;
        else {
            showNotification("Вы не можете изменить",
                "Этот документ нельзя изменить",
                Notifications.NotificationType.WARNING);
            return false;
        }
    }


    @Subscribe("editBtn")
    public void onEditBtnClick(Button.ClickEvent event) {
        if (checkLastEvent()) screenBuilders.editor(kadrovoePeremeseniesTable)
            .withOpenMode(OpenMode.NEW_TAB)
            .build().show();
    }

    @Subscribe("kadrovoePeremeseniesTable.remove")
    public void onKadrovoePeremeseniesTableRemove(Action.ActionPerformedEvent event) {
        KadrovoePeremesenie kadPeremesenie = kadrovoePeremeseniesTable.getSingleSelected();
        List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacalos = dataManager.load(PlanovyeNacisleniaNacalo.class)
            .query("select e from informations_PlanovyeNacisleniaNacalo e where e.kadrovoePeremesenie = :kadrovoePeremesenie")
            .parameter("kadrovoePeremesenie", kadPeremesenie).list();
        Sotrudniki sotrudnik = dataManager.load(Sotrudniki.class)
            .query("select e from informations_Sotrudniki e " +
                "where e.sotrudnik = :sotrudnik and e.organizacia = :organizacia order by e.period desc")
            .parameter("sotrudnik", kadPeremesenie.getSotrudnik())
            .parameter("organizacia", kadPeremesenie.getOrganizacia())
            .one();
        if (sotrudnik == null || sotrudnik.getVidSobytia().getOrder() == 1) {
            dialogs.createInputDialog(this)
                .withCaption("Удалить?")
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        sotrudnik.setAktivnost1(false);
                        dataManager.remove(kadPeremesenie);
                        dataManager.save(sotrudnik);
                        for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo : planovyeNacisleniaNacalos) {
                            planovyeNacisleniaNacalo.setAktivnost1(false);
                            dataManager.save(planovyeNacisleniaNacalo);
                        }
                        for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo : planovyeNacisleniaNacalos) {
                            planovyeNacisleniaNacalo.setAktivnost1(false);
                            dataManager.save(planovyeNacisleniaNacalo);
                        }
                        kadrovoePeremeseniesTableRefresh.execute();
                    }
                }).show();
        } else
            showNotification("Невозможно удалить!", "После этой записи был проведен другой документ", Notifications.NotificationType.WARNING);
    }


    @Subscribe("reportBtn")
    public void onReportBtnClick(Button.ClickEvent event) {
        ReportTemplate template = reportTemplates.getValue();
        if (template == null) {
            showNotification("Выберите нужный шаблон!", "", Notifications.NotificationType.WARNING);
            return;
        }
        Report report = getReport();
        ReportOutputDocument document = reportRunner.byReportEntity(report)
            .withOutputType(ReportOutputType.PDF)
            .withTemplate(template)
            .addParam("pnr3", kadrovoePeremeseniesTable.getSingleSelected())
            .withOutputNamePattern("Перемещение работника").run();
        downloader.download(document.getContent(), document.getDocumentName(), DownloadFormat.PDF);
    }

    @Install(to = "kadrovoePeremeseniesTable", subject = "iconProvider")
    private String kadrovoePeremeseniesTableIconProvider(KadrovoePeremesenie kp) {
        if (kp.getRegisterSotrudnika().getAktivnost1() != null && kp.getRegisterSotrudnika().getAktivnost1())
            return JmixIcon.OK.source();
        return JmixIcon.BOOK.source();
    }


    @Subscribe("kadrovoePeremeseniesTable.provesti")
    public void onKadrovoePeremeseniesTableProvesti(Action.ActionPerformedEvent event) {
        showConfirmDialog("Провести документ?", true);
    }

    @Subscribe("kadrovoePeremeseniesTable.otmenit1Provedenie")
    public void onKadrovoePeremeseniesTableOtmenit1Provedenie(Action.ActionPerformedEvent event) {
        showConfirmDialog("Отменить проведение?", false);
    }

    private void showConfirmDialog(String caption, Boolean active) {
        kadrovoePeremesenie = kadrovoePeremeseniesTable.getSingleSelected();
        Sotrudniki sotrudnik = kadrovoePeremesenie.getRegisterSotrudnika();
        List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacalos = dataManager.load(PlanovyeNacisleniaNacalo.class)
            .query("select e from informations_PlanovyeNacisleniaNacalo e where e.kadrovoePeremesenie = :kadrovoePeremesenie")
            .parameter("kadrovoePeremesenie", kadrovoePeremesenie).list();
        if (sotrudnik != null && sotrudnik.getAktivnost1() != active) {
            dialogs.createInputDialog(this)
                .withCaption(caption)
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        sotrudnik.setAktivnost1(active);
                        dataManager.save(sotrudnik);
                        for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo : planovyeNacisleniaNacalos) {
                            planovyeNacisleniaNacalo.setAktivnost1(active);
                            dataManager.save(planovyeNacisleniaNacalo);
                        }
                        showNotification("Успешно изменен!", "", Notifications.NotificationType.TRAY);
                        kadrovoePeremeseniesTableRefresh.execute();
                    }
                }).show();
        }
    }
}
