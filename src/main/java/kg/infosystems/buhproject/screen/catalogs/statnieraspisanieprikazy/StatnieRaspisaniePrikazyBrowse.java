package kg.infosystems.buhproject.screen.catalogs.statnieraspisanieprikazy;

import com.haulmont.yarg.reporting.ReportOutputDocument;
import io.jmix.core.DataManager;
import io.jmix.reports.entity.Report;
import io.jmix.reports.entity.ReportOutputType;
import io.jmix.reports.entity.ReportTemplate;
import io.jmix.reports.runner.ReportRunner;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.download.DownloadFormat;
import io.jmix.ui.download.Downloader;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.StatnieRaspisaniePrikazy;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("StatnieRaspisaniePrikazy.browse")
@UiDescriptor("statnie-raspisanie-prikazy-browse.xml")
@LookupComponent("statnieRaspisaniePrikaziesTable")
public class StatnieRaspisaniePrikazyBrowse extends StandardLookup<StatnieRaspisaniePrikazy> {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private ReportRunner reportRunner;
    @Autowired
    private GroupTable<StatnieRaspisaniePrikazy> statnieRaspisaniePrikaziesTable;
    @Autowired
    private Downloader downloader;

    @Subscribe("reportBtn")
    public void onReportBtnClick(Button.ClickEvent event) {
        Report report = dataManager.loadValue("select e from report_Report e " +
            "where e.code = 'ShtatnoeChislennostReport'", Report.class).one();
        ReportTemplate template = dataManager.loadValue("select e from report_ReportTemplate e " +
            "where e.code = 'ShtatnoeChislennostTemplate'", ReportTemplate.class).one();
        ReportOutputDocument context = reportRunner.byReportEntity(report)
            .withOutputType(ReportOutputType.PDF)
            .withTemplate(template)
            .addParam("pnr3", statnieRaspisaniePrikaziesTable.getSingleSelected().getOrganizasia())
            .withOutputNamePattern("Штатное расписание").run();
        downloader.download(context.getContent(), context.getDocumentName(), DownloadFormat.PDF);
    }
    @Subscribe("reportBtn123")
    public void onReportBtnClick1(Button.ClickEvent event) {
        Report report = dataManager.loadValue("select e from report_Report e " +
            "where e.code = 'shtatnoe_rasp'", Report.class).one();
        ReportTemplate template = dataManager.loadValue("select e from report_ReportTemplate e " +
            "where e.code = 'shtatnoe_rasp'", ReportTemplate.class).one();
        ReportOutputDocument context = reportRunner.byReportEntity(report)
            .withOutputType(ReportOutputType.PDF)
            .withTemplate(template)
            .addParam("pnr3", statnieRaspisaniePrikaziesTable.getSingleSelected().getOrganizasia())
            .withOutputNamePattern("Штатное расписание").run();
        downloader.download(context.getContent(), context.getDocumentName(), DownloadFormat.PDF);
    }
}
