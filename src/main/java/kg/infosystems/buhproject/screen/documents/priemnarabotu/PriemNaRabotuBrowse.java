package kg.infosystems.buhproject.screen.documents.priemnarabotu;

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
import kg.infosystems.buhproject.entity.documents.PriemNaRabotu;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaNacalo;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;
import kg.infosystems.buhproject.screen.base.BaseReportScreen;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

@UiController("PriemNaRabotu.browse")
@UiDescriptor("priem-na-rabotu-browse.xml")
@LookupComponent("priemNaRabotusTable")
public class PriemNaRabotuBrowse extends BaseReportScreen<PriemNaRabotu> {
    @Inject
    private GroupTable<PriemNaRabotu> priemNaRabotusTable;

    @Named("priemNaRabotusTable.refresh")
    private RefreshAction priemNaRabotusTableRefresh;

    private Boolean checkLastEvent() {
        PriemNaRabotu pnr = priemNaRabotusTable.getSingleSelected();
        List<Sotrudniki> sotrudnikiList = dataManager.loadValue("select e from informations_Sotrudniki e " +
                "where e.sotrudnik = :sotrudnik and e.organizacia = :organizacia order by e.period desc", Sotrudniki.class)
            .parameter("sotrudnik", pnr.getSotrudnik())
            .parameter("organizacia", pnr.getOrganizacia())
            .list();
        if (sotrudnikiList.isEmpty() || pnr.getRegisterSotrudnika() == null) {
            showNotification("Сотрудник не записан в регистр",
                "", Notifications.NotificationType.ERROR);
            return false;
        } else if (Objects.equals(sotrudnikiList.get(0).getId(), pnr.getRegisterSotrudnika().getId())) return true;
        else {
            showNotification("Вы не можете изменить",
                "Этот документ нельзя изменить",
                Notifications.NotificationType.WARNING);
            return false;
        }
    }

    @Subscribe("priemNaRabotusTable.remove")
    public void onPriemNaRabotusTableRemove(Action.ActionPerformedEvent event) {
        PriemNaRabotu priemNaRabotu = priemNaRabotusTable.getSingleSelected();
        List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacalos = dataManager.load(PlanovyeNacisleniaNacalo.class)
            .query("select e from informations_PlanovyeNacisleniaNacalo e where e.priemNaRabotu = :priemNaRabotu")
            .parameter("priemNaRabotu", priemNaRabotu).list();
        Sotrudniki sotrudnik = dataManager.load(Sotrudniki.class)
            .query("select e from informations_Sotrudniki e " +
                "where e.sotrudnik = :sotrudnik and e.organizacia = :organizacia order by e.period desc")
            .parameter("sotrudnik", priemNaRabotu.getSotrudnik())
            .parameter("organizacia", priemNaRabotu.getOrganizacia())
            .one();
        if (sotrudnik == null || sotrudnik.getVidSobytia().getOrder() == 1) {
            dialogs.createInputDialog(this)
                .withCaption("Удалить?")
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        sotrudnik.setAktivnost1(false);
                        dataManager.remove(priemNaRabotu);
                        dataManager.save(sotrudnik);
                        for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo : planovyeNacisleniaNacalos) {
                            planovyeNacisleniaNacalo.setAktivnost1(false);
                            dataManager.save(planovyeNacisleniaNacalo);
                        }

                        refreshPriemTable();
                    }
                }).show();
        } else
            showNotification("Невозможно удалить!", "После этой записи был проведен другой документ", Notifications.NotificationType.WARNING);
    }


    @Subscribe("editBtn")
    public void onEditBtnClick(Button.ClickEvent event) {
        if (checkLastEvent()) screenBuilders.editor(priemNaRabotusTable)
            .withOpenMode(OpenMode.NEW_TAB).build().show();
    }


    @Subscribe("reportBtn")
    public void onReportBtnClick(Button.ClickEvent event) {
        ReportTemplate template = reportTemplates.getValue();
        if (template == null) {
            showNotification("Выберите нужный шаблон!", "", Notifications.NotificationType.WARNING);
            return;
        }
        Report report = getReport();
        ReportOutputDocument context = reportRunner.byReportEntity(report)
            .withOutputType(ReportOutputType.PDF)
            .withTemplate(template)
            .addParam("pnr3", priemNaRabotusTable.getSingleSelected())
            .withOutputNamePattern(report.getName()).run();
        downloader.download(context.getContent(), context.getDocumentName(), DownloadFormat.PDF);
    }


    @Install(to = "priemNaRabotusTable", subject = "iconProvider")
    private String priemNaRabotusTableIconProvider(PriemNaRabotu pnr) {
        if (pnr.getRegisterSotrudnika().getAktivnost1() != null && pnr.getRegisterSotrudnika().getAktivnost1())
            return JmixIcon.OK.source();
        return JmixIcon.BOOK.source();
    }


    @Subscribe("priemNaRabotusTable.provesti")
    public void onPriemNaRabotusTableProvesti(Action.ActionPerformedEvent event) {
        showConfirmDialog("Провести документ?", true);
    }

    @Subscribe("priemNaRabotusTable.otmenit1Provedenie")
    public void onPriemNaRabotusTableOtmenit1Provedenie(Action.ActionPerformedEvent event) {
        showConfirmDialog("Отменить проведение?", false);
    }


    private void showConfirmDialog(String caption, Boolean active) {
        PriemNaRabotu pnr = priemNaRabotusTable.getSingleSelected();
        Sotrudniki sotrudnik = pnr.getRegisterSotrudnika();
        List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacalos = dataManager.load(PlanovyeNacisleniaNacalo.class)
            .query("select e from informations_PlanovyeNacisleniaNacalo e where e.priemNaRabotu = :priemNaRabotu")
            .parameter("priemNaRabotu", pnr).list();
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
                        refreshPriemTable();
                    }
                }).show();
        }
    }

    private void refreshPriemTable() {
        priemNaRabotusTableRefresh.execute();
    }

}
