package kg.infosystems.buhproject.screen.documents.rabotavvyhodnyeiprazdnicnyedni;

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
import kg.infosystems.buhproject.entity.documents.RabotaVVyhodnyeIPrazdnicnyeDni;
import kg.infosystems.buhproject.entity.parts.documents.RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;
import kg.infosystems.buhproject.screen.base.BaseReportScreen;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@UiController("RabotaVVyhodnyeIPrazdnicnyeDni.browse")
@UiDescriptor("rabota-v-vyhodnye-i-prazdnicnye-dni-browse.xml")
@LookupComponent("rabotaVVyhodnyeIPrazdnicnyeDnisTable")
public class RabotaVVyhodnyeIPrazdnicnyeDniBrowse extends BaseReportScreen<RabotaVVyhodnyeIPrazdnicnyeDni> {
    @Inject
    private GroupTable<RabotaVVyhodnyeIPrazdnicnyeDni> rabotaVVyhodnyeIPrazdnicnyeDnisTable;
    @Named("rabotaVVyhodnyeIPrazdnicnyeDnisTable.refresh")
    private RefreshAction rabotaVVyhodnyeIPrazdnicnyeDnisTableRefresh;

    @Subscribe("reportRunBtn")
    public void onReportRunBtnClick(Button.ClickEvent event) {
        if (checkTemplate()) {
            Report report = getReport();
            ReportOutputDocument context = reportRunner.byReportEntity(report)
                .withOutputType(ReportOutputType.PDF)
                .withTemplate(getCurrentTemplate())
                .withOutputNamePattern(report.getName())
                .addParam("pnr3", rabotaVVyhodnyeIPrazdnicnyeDnisTable.getSingleSelected()).run();
            downloader.download(context.getContent(), context.getDocumentName(), DownloadFormat.PDF);
        }
    }

    @Install(to = "rabotaVVyhodnyeIPrazdnicnyeDnisTable", subject = "iconProvider")
    private String rabotaVVyhodnyeIPrazdnicnyeDnisTableIconProvider(RabotaVVyhodnyeIPrazdnicnyeDni vp) {
        if (vp.getProveden()) return JmixIcon.OK.source();
        return JmixIcon.BOOK.source();
    }

    @Subscribe("otmenit1ProvestiBtn")
    public void onOtmenit1ProvestiBtnClick(Button.ClickEvent event) {
        if (checkDaysInRegister())
            showNotification("В регистре уже записан с такими датами", "", Notifications.NotificationType.WARNING);
        else
            showConfirmDialog("Отменить проведение?", false);
    }

    @Subscribe("provestiBtn")
    public void onProvestiBtnClick(Button.ClickEvent event) {
        showConfirmDialog("Провести документ?", true);
    }

    private Boolean checkDaysInRegister() {
        RabotaVVyhodnyeIPrazdnicnyeDni vd = rabotaVVyhodnyeIPrazdnicnyeDnisTable.getSingleSelected();
        for (RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki sotrudnik : vd.getSotrudniki()) {
            long register = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                    "where e.aktivnost1 = true " +
                    "and e.sotrudnik = :sotrudnik " +
                    "and e.organizacia = :organizacia " +
                    "and ((e.dataNacala >= :startDate and e.dataNacala <= :endDate) " +
                    "or (e.dataOkoncania >= :startDate and e.dataOkoncania <= :endDate))", Long.class)
                .parameter("sotrudnik", sotrudnik.getSotrudnik())
                .parameter("organizacia", vd.getOrganizacia())
                .parameter("startDate", sotrudnik.getDataNacala())
                .parameter("endDate", sotrudnik.getDataOkoncania())
                .one();
            if (0 != register) return true;
        }
        return false;
    }


    private void showConfirmDialog(String caption, Boolean active) {
        RabotaVVyhodnyeIPrazdnicnyeDni current = rabotaVVyhodnyeIPrazdnicnyeDnisTable.getSingleSelected();
        if (current.getProveden() != active) {
            dialogs.createInputDialog(this)
                .withCaption(caption)
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        current.setProveden(active);
                        dataManager.save(current);
                        List<RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki> sotrudniki = current.getSotrudniki();
                        for (RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki sotrudnik : sotrudniki) {
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
                        rabotaVVyhodnyeIPrazdnicnyeDnisTableRefresh.execute();
                    }
                }).show();
        }
    }

}
