package kg.infosystems.buhproject.screen.base;

import io.jmix.core.DataManager;
import io.jmix.reports.entity.Report;
import io.jmix.reports.entity.ReportTemplate;
import io.jmix.reports.runner.ReportRunner;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.download.Downloader;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.Subscribe;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class BaseReportScreen<T> extends StandardLookup<T> {
    @Inject
    public DataManager dataManager;
    @Inject
    public Dialogs dialogs;
    @Inject
    private Notifications notifications;
    @Inject
    public ReportRunner reportRunner;
    @Inject
    public Downloader downloader;

    @Inject
    public ComboBox<ReportTemplate> reportTemplates;
    @Inject
    public ScreenBuilders screenBuilders;

    private String reportCode;

    private Report report;

    @Subscribe
    public void onInit(InitEvent event) {
        reportCode = this.getClass().getSimpleName();
        reportCode = reportCode.substring(0, reportCode.length() - 6);
        report = dataManager.load(Report.class)
            .query("select e from report_Report e where e.code = :code")
            .parameter("code", reportCode).optional().orElse(null);
        if (report == null) return;
        Map<String, ReportTemplate> templates = new HashMap<>();
        for (ReportTemplate r : report.getTemplates()) {
            templates.put(r.getOutputNamePattern(), r);
        }
        reportTemplates.setOptionsMap(templates);
    }

    public ReportTemplate getCurrentTemplate(){
        return reportTemplates.getValue();
    }

    public boolean checkTemplate(){
        ReportTemplate template = reportTemplates.getValue();
        if (template == null) {
            showNotification("Выберите нужный шаблон!", "", Notifications.NotificationType.WARNING);
            return false;
        }
        return true;
    }

    public void showNotification(String caption, String description, Notifications.NotificationType type) {
        notifications.create().withCaption(caption).withDescription(description).withType(type).withPosition(Notifications.Position.MIDDLE_CENTER).show();
    }
}
