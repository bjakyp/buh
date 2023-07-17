package kg.infosystems.buhproject.screen.documents.neavka;

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
import kg.infosystems.buhproject.entity.documents.Neavka;
import kg.infosystems.buhproject.entity.parts.documents.NeavkaSotrudniki;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;
import kg.infosystems.buhproject.screen.base.BaseReportScreen;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@UiController("Neavka.browse")
@UiDescriptor("neavka-browse.xml")
@LookupComponent("neavkasTable")
public class NeavkaBrowse extends BaseReportScreen<Neavka> {
    @Inject
    private GroupTable<Neavka> neavkasTable;
    @Named("neavkasTable.refresh")
    private RefreshAction neavkasTableRefresh;

    @Subscribe("reportRunBtn")
    public void onReportRunBtnClick(Button.ClickEvent event) {
        if (checkTemplate()) {
            Report report = getReport();
            ReportOutputDocument context = reportRunner.byReportEntity(report)
                .withOutputType(ReportOutputType.PDF)
                .withTemplate(getCurrentTemplate())
                .withOutputNamePattern(report.getName())
                .addParam("pnr3", neavkasTable.getSingleSelected()).run();
            downloader.download(context.getContent(), context.getDocumentName(), DownloadFormat.PDF);
        }
    }

    @Install(to = "neavkasTable", subject = "iconProvider")
    private String neavkasTableIconProvider(Neavka neavka) {
        if (neavka.getProveden()) return JmixIcon.OK.source();
        return JmixIcon.BOOK.source();
    }

    private Boolean checkDaysInRegister() {
        Neavka neavka = neavkasTable.getSingleSelected();
        for (NeavkaSotrudniki sotrudnik : neavka.getSotrudniki()) {
            long register = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                    "where e.aktivnost1 = true " +
                    "and e.sotrudnik = :sotrudnik " +
                    "and e.organizacia = :organizacia " +
                    "and ((e.dataNacala >= :startDate and e.dataNacala <= :endDate) " +
                    "or (e.dataOkoncania >= :startDate and e.dataOkoncania <= :endDate))", Long.class)
                .parameter("sotrudnik", sotrudnik.getSotrudnik())
                .parameter("organizacia", neavka.getOrganizacia())
                .parameter("startDate", sotrudnik.getDataOtsutstvia())
                .parameter("endDate", sotrudnik.getDataOtsutstvia())
                .one();
            if (0 != register) return true;
        }
        return false;
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

    private void showConfirmDialog(String caption, Boolean active) {
        Neavka current = neavkasTable.getSingleSelected();
        if (current.getProveden() != active) {
            dialogs.createInputDialog(this)
                .withCaption(caption)
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        current.setProveden(active);
                        dataManager.save(current);
                        List<NeavkaSotrudniki> sotrudniki = current.getSotrudniki();
                        for (NeavkaSotrudniki sotrudnik : sotrudniki) {
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
                        neavkasTableRefresh.execute();
                    }
                }).show();
        }
    }
}
