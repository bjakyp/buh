package kg.infosystems.buhproject.screen.documents.bol1nicnyjlist;

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
import kg.infosystems.buhproject.entity.documents.Bol1nicnyjList;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;
import kg.infosystems.buhproject.screen.base.BaseReportScreen;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("Bol1nicnyjList.browse")
@UiDescriptor("bol1nicnyj-list-browse.xml")
@LookupComponent("bol1nicnyjListsTable")
public class Bol1nicnyjListBrowse extends BaseReportScreen<Bol1nicnyjList> {
    @Inject
    private GroupTable<Bol1nicnyjList> bol1nicnyjListsTable;
    @Named("bol1nicnyjListsTable.refresh")
    private RefreshAction bol1nicnyjListsTableRefresh;

    @Subscribe("reportRunBtn")
    public void onReportRunBtnClick(Button.ClickEvent event) {
        if (checkTemplate()) {
            Report report = getReport();
            ReportOutputDocument context = reportRunner.byReportEntity(report)
                .withOutputType(ReportOutputType.PDF)
                .withTemplate(getCurrentTemplate())
                .withOutputNamePattern(report.getName())
                .addParam("pnr3", bol1nicnyjListsTable.getSingleSelected()).run();
            downloader.download(context.getContent(), context.getDocumentName(), DownloadFormat.PDF);
        }
    }

    @Install(to = "bol1nicnyjListsTable", subject = "iconProvider")
    private String bol1nicnyjListsTableIconProvider(Bol1nicnyjList posobia) {
        if (posobia.getProveden()) return JmixIcon.OK.source();
        return JmixIcon.BOOK.source();
    }

    @Subscribe("provestiBtn")
    public void onProvestiBtnClick(Button.ClickEvent event) {
        Bol1nicnyjList posobie = bol1nicnyjListsTable.getSingleSelected();
        Long registerSize = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                "where e.aktivnost1 = true " +
                "and e.sotrudnik = :sotrudnik " +
                "and e.organizacia = :organizacia " +
                "and ((e.dataNacala >= :dateFrom and e.dataNacala <= :dateTo) " +
                "or (e.dataOkoncania >= :dateFrom and e.dataOkoncania <= :dateTo))", Long.class)
            .parameter("sotrudnik", posobie.getSotrudnik())
            .parameter("organizacia", posobie.getOrganizacia())
            .parameter("dateFrom", posobie.getDataNacala())
            .parameter("dateTo", posobie.getDataOkoncania())
            .one();
        if (registerSize != 0) {
            showNotification("В регистре уже записан с такими датами", "", Notifications.NotificationType.WARNING);
        } else
            showConfirmDialog("Провести документ?", true);
    }

    @Subscribe("otmenit1ProvedenieBtn")
    public void onOtmenit1ProvedenieBtnClick(Button.ClickEvent event) {
        showConfirmDialog("Отменить проведение?", false);
    }

    private void showConfirmDialog(String caption, Boolean active) {
        Bol1nicnyjList current = bol1nicnyjListsTable.getSingleSelected();
        Tabel1UcetaPoseshenia register = current.getRegisterPosobia();
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
                        bol1nicnyjListsTableRefresh.execute();
                    }
                }).show();
        }
    }
}
