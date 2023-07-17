package kg.infosystems.buhproject.screen.documents.uvol1nenie;

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
import kg.infosystems.buhproject.entity.documents.Uvol1nenie;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;
import kg.infosystems.buhproject.screen.base.BaseReportScreen;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

@UiController("Uvol1nenie.browse")
@UiDescriptor("uvol1nenie-browse.xml")
@LookupComponent("uvol1neniesTable")
public class Uvol1nenieBrowse extends BaseReportScreen<Uvol1nenie> {

    @Inject
    private GroupTable<Uvol1nenie> uvol1neniesTable;

    @Named("uvol1neniesTable.refresh")
    private RefreshAction uvol1neniesTableRefresh;

    private Uvol1nenie uvol1nenie;

    private Boolean checkLastEvent() {
        uvol1nenie = uvol1neniesTable.getSingleSelected();
        List<Sotrudniki> sotrudnikiList = dataManager.loadValue("select e from informations_Sotrudniki e " +
                "where e.sotrudnik = :sotrudnik and e.organizacia = :organizacia order by e.period desc", Sotrudniki.class)
            .parameter("sotrudnik", uvol1nenie.getSotrudnik())
            .parameter("organizacia", uvol1nenie.getOrganizacia())
            .list();
        if (sotrudnikiList.isEmpty() || uvol1nenie.getRegisterSotrudnika() == null) {
            showNotification("Сотрудник не записан в регистр",
                "", Notifications.NotificationType.ERROR);
            return false;
        } else if (Objects.equals(sotrudnikiList.get(0).getId(), uvol1nenie.getRegisterSotrudnika().getId())) return true;
        else {
            showNotification("Вы не можете изменить",
                "Этот документ нельзя изменить",
                Notifications.NotificationType.WARNING);
            return false;
        }
    }

    @Subscribe("editBtn")
    public void onEditBtnClick(Button.ClickEvent event) {
        if (checkLastEvent()) screenBuilders.editor(uvol1neniesTable)
            .withOpenMode(OpenMode.NEW_TAB)
            .build().show();
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
            .addParam("pnr3", uvol1neniesTable.getSingleSelected())
            .withOutputNamePattern("Увольнение сотрудника").run();
        downloader.download(document.getContent(), document.getDocumentName(), DownloadFormat.PDF);
    }


    @Install(to = "uvol1neniesTable", subject = "iconProvider")
    private String uvol1neniesTableIconProvider(Uvol1nenie uvol1nenie) {
        if (uvol1nenie.getRegisterSotrudnika().getAktivnost1() != null && uvol1nenie.getRegisterSotrudnika().getAktivnost1())
            return JmixIcon.OK.source();
        return JmixIcon.BOOK.source();
    }

    @Subscribe("uvol1neniesTable.provesti")
    public void onUvol1neniesTableProvesti(Action.ActionPerformedEvent event) {
        showConfirmDialog("Провести документ?", true);
    }

    @Subscribe("uvol1neniesTable.otmenit1Provedenie")
    public void onUvol1neniesTableOtmenit1Provedenie(Action.ActionPerformedEvent event) {
        showConfirmDialog("Отменить проведение?", false);
    }

    private void showConfirmDialog(String caption, Boolean active) {
        uvol1nenie = uvol1neniesTable.getSingleSelected();
        Sotrudniki sotrudnik = uvol1nenie.getRegisterSotrudnika();
        if (sotrudnik != null && sotrudnik.getAktivnost1() != active) {
            dialogs.createInputDialog(this)
                .withCaption(caption)
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        sotrudnik.setAktivnost1(active);
                        dataManager.save(sotrudnik);
                        showNotification("Успешно изменен!", "", Notifications.NotificationType.TRAY);
                        uvol1neniesTableRefresh.execute();
                    }
                }).show();
        }
    }
}
