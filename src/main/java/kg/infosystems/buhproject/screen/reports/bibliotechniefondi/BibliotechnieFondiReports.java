package kg.infosystems.buhproject.screen.reports.bibliotechniefondi;

import io.jmix.core.DataManager;
import io.jmix.core.common.util.ParamsMap;
import io.jmix.reports.entity.Report;
import io.jmix.reportsui.screen.report.run.InputParametersDialog;
import io.jmix.ui.Notifications;
import io.jmix.ui.Screens;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.screen.*;

import javax.inject.Inject;

@UiController("BibliotechnieFondiReports")
@UiDescriptor("bibliotechnie-fondi-reports.xml")
public class BibliotechnieFondiReports extends Screen {
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private ComboBox<Report> reportField;
    @Inject
    private Screens screens;

    @Subscribe
    public void onInit(InitEvent event) {
        reportField.setOptionsList(dataManager.load(Report.class)
            .query("select r from report_Report r where r.group.code = 'BibliotechnieFondiReports'").list());
    }

    @Subscribe("runReportBtn")
    public void onRunReportBtnClick(Button.ClickEvent event) {
        Report report = reportField.getValue();
        if (report == null) {
            showNotification("Выберите отчет!", "", Notifications.NotificationType.WARNING);
            return;
        }
        InputParametersDialog ipg = screens.create(InputParametersDialog.class, OpenMode.NEW_TAB,
            new MapScreenOptions(ParamsMap.of("report", report)));
        ipg.show();
    }

    private void showNotification(String caption, String description, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(description)
            .withType(type)
            .show();
    }
}
