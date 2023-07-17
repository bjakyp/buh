package kg.infosystems.buhproject.screen.documents.otpusk;

import com.haulmont.yarg.reporting.ReportOutputDocument;
import io.jmix.reports.entity.Report;
import io.jmix.reports.entity.ReportOutputType;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.list.RefreshAction;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.DialogOutcome;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.download.DownloadFormat;
import io.jmix.ui.icon.JmixIcon;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Otpusk;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;
import kg.infosystems.buhproject.screen.base.BaseReportScreen;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("Otpusk.browse")
@UiDescriptor("otpusk-browse.xml")
@LookupComponent("otpusksTable")
public class OtpuskBrowse extends BaseReportScreen<Otpusk> {
    @Inject
    private GroupTable<Otpusk> otpusksTable;
    @Inject
    private ScreenBuilders screenBuilders;
    @Named("otpusksTable.refresh")
    private RefreshAction otpusksTableRefresh;

    @Subscribe("createBtn")
    public void onCreateBtnClick(Button.ClickEvent event) {
        screenBuilders.editor(otpusksTable)
            .newEntity()
            .build()
            .show();
    }

    @Subscribe("reportRunBtn")
    public void onReportRunBtnClick(Button.ClickEvent event) {
        if (checkTemplate()) {
            Report report = getReport();
            ReportOutputDocument context = reportRunner.byReportEntity(report)
                .withOutputType(ReportOutputType.PDF)
                .withTemplate(getCurrentTemplate())
                .withOutputNamePattern(report.getName())
                .addParam("pnr3", otpusksTable.getSingleSelected()).run();
            downloader.download(context.getContent(), context.getDocumentName(), DownloadFormat.PDF);
        }
    }

    @Install(to = "otpusksTable", subject = "iconProvider")
    private String otpusksTableIconProvider(Otpusk otpusk) {
        if (otpusk.getProveden()) return JmixIcon.OK.source();
        return JmixIcon.BOOK.source();
    }

    @Subscribe("provestiBtn")
    public void onProvestiBtnClick(Button.ClickEvent event) {
        Otpusk otpusk = otpusksTable.getSingleSelected();
        Long registerSize = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                "where e.aktivnost1 = true " +
                "and e.sotrudnik = :sotrudnik " +
                "and e.organizacia = :organizacia " +
                "and ((e.dataNacala >= :dateFrom and e.dataNacala <= :dateTo) " +
                "or (e.dataOkoncania >= :dateFrom and e.dataOkoncania <= :dateTo))", Long.class)
            .parameter("sotrudnik", otpusk.getSotrudnik())
            .parameter("organizacia", otpusk.getOrganizacia())
            .parameter("dateFrom", otpusk.getDataNacala())
            .parameter("dateTo", otpusk.getDataOkoncania())
            .one();
        if (registerSize != 0)
            showNotification("В регистре уже записан с такими датами", "", Notifications.NotificationType.WARNING);
        else
            showConfirmDialog("Провести документ?", true);
    }

    @Subscribe("otmenit1ProvestiBtn")
    public void onOtmenit1ProvestiBtnClick(Button.ClickEvent event) {
        showConfirmDialog("Отменить проведение?", false);
    }

    private void showConfirmDialog(String caption, Boolean active) {
        Otpusk current = otpusksTable.getSingleSelected();
        Tabel1UcetaPoseshenia register = current.getRegisterTabelya();
        if (current.getProveden() != active) {
            dialogs.createInputDialog(this)
                .withCaption(caption)
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        register.setAktivnost1(active);
                        current.setProveden(active);
                        dataManager.save(current);
                        dataManager.save(register);
                        showNotification("Успешно изменен!", "", Notifications.NotificationType.TRAY);
                        otpusksTableRefresh.execute();
                    }
                }).show();
        }
    }

}
