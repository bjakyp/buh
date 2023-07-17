package kg.infosystems.buhproject.screen.documents.rabotasverhurocno;

import com.haulmont.yarg.reporting.ReportOutputDocument;
import io.jmix.reports.entity.Report;
import io.jmix.reports.entity.ReportOutputType;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.list.RefreshAction;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.DialogOutcome;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.download.DownloadFormat;
import io.jmix.ui.icon.JmixIcon;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RabotaSverhurocno;
import kg.infosystems.buhproject.entity.parts.documents.RabotaSverhurocnoSotrudniki;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;
import kg.infosystems.buhproject.screen.base.BaseReportScreen;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@UiController("RabotaSverhurocno.browse")
@UiDescriptor("rabota-sverhurocno-browse.xml")
@LookupComponent("rabotaSverhurocnoesTable")
public class RabotaSverhurocnoBrowse extends BaseReportScreen<RabotaSverhurocno> {
    @Inject
    private GroupTable<RabotaSverhurocno> rabotaSverhurocnoesTable;
    @Named("rabotaSverhurocnoesTable.refresh")
    private RefreshAction rabotaSverhurocnoesTableRefresh;

    @Subscribe("reportRunBtn")
    public void onReportRunBtnClick(Button.ClickEvent event) {
        if (checkTemplate()) {
            Report report = getReport();
            ReportOutputDocument context = reportRunner.byReportEntity(report)
                .withOutputType(ReportOutputType.PDF)
                .withTemplate(getCurrentTemplate())
                .withOutputNamePattern(report.getName())
                .addParam("pnr3", rabotaSverhurocnoesTable.getSingleSelected()).run();
            downloader.download(context.getContent(), context.getDocumentName(), DownloadFormat.PDF);
        }
    }

    @Install(to = "rabotaSverhurocnoesTable", subject = "iconProvider")
    private String rabotaSverhurocnoesTableIconProvider(RabotaSverhurocno rs) {
        if (rs.getProveden()) return JmixIcon.OK.source();
        return JmixIcon.BOOK.source();
    }

    @Subscribe("otmenit1ProvestiBtn")
    public void onOtmenit1ProvestiBtnClick(Button.ClickEvent event) {
        showConfirmDialog("Отменить проведение?", false);
    }

    @Subscribe("provestiBtn")
    public void onProvestiBtnClick(Button.ClickEvent event) {
        if (checkDaysInRegister())
            showNotification("В регистре уже записан с такими датами", "", Notifications.NotificationType.WARNING);
        else
            showConfirmDialog("Провести документ?", true);
    }


    private Boolean checkDaysInRegister() {
        RabotaSverhurocno rs = rabotaSverhurocnoesTable.getSingleSelected();
        for (RabotaSverhurocnoSotrudniki sotrudnik : rs.getSotrudniki()) {
            long register = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                    "where e.aktivnost1 = true " +
                    "and e.sotrudnik = :sotrudnik " +
                    "and e.organizacia = :organizacia " +
                    "and ((e.dataNacala >= :startDate and e.dataNacala <= :endDate) " +
                    "or (e.dataOkoncania >= :startDate and e.dataOkoncania <= :endDate))", Long.class)
                .parameter("sotrudnik", sotrudnik.getSotrudnik())
                .parameter("organizacia", rs.getOrganizacia())
                .parameter("startDate", sotrudnik.getDataVyhoda())
                .parameter("endDate", sotrudnik.getDataVyhoda())
                .one();
            if (0 != register) return true;
        }
        return false;
    }

    private void showConfirmDialog(String caption, Boolean active) {
        RabotaSverhurocno current = rabotaSverhurocnoesTable.getSingleSelected();
        if (current.getProveden() != active) {
            dialogs.createInputDialog(this)
                .withCaption(caption)
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        current.setProveden(active);
                        dataManager.save(current);
                        List<RabotaSverhurocnoSotrudniki> sotrudniki = current.getSotrudniki();
                        for (RabotaSverhurocnoSotrudniki sotrudnik : sotrudniki) {
                            Tabel1UcetaPoseshenia tabel1KajdogoSotrudnika = dataManager.load(Tabel1UcetaPoseshenia.class)
                                .query("select e from Tabel1UcetaPoseshenia e " +
                                    "where e.tabel = :tabelId and e.sotrudnik = :sotrudnik")
                                .parameter("tabelId", current.getId())
                                .parameter("sotrudnik", sotrudnik.getSotrudnik())
                                .one();
                            tabel1KajdogoSotrudnika.setAktivnost1(active);
                            dataManager.save(tabel1KajdogoSotrudnika);
                        }
                        showNotification("Успешно изменен!", "", Notifications.NotificationType.TRAY);
                        rabotaSverhurocnoesTableRefresh.execute();
                    }
                }).show();
        }
    }

}
