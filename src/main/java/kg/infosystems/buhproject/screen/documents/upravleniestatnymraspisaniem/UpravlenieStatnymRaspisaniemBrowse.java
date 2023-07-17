package kg.infosystems.buhproject.screen.documents.upravleniestatnymraspisaniem;

import io.jmix.core.DataManager;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.DialogOutcome;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.UpravlenieStatnymRaspisaniem;
import kg.infosystems.buhproject.entity.enumerations.StatnoeRaspisanieStatus;

import javax.inject.Inject;
import java.util.List;

@UiController("UpravlenieStatnymRaspisaniem.browse")
@UiDescriptor("upravlenie-statnym-raspisaniem-browse.xml")
@LookupComponent("upravlenieStatnymRaspisaniemsTable")
public class UpravlenieStatnymRaspisaniemBrowse extends StandardLookup<UpravlenieStatnymRaspisaniem> {
    @Inject
    GroupTable<UpravlenieStatnymRaspisaniem> upravlenieStatnymRaspisaniemsTable;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;

    @Inject
    private Dialogs dialogs;

    private List<StatnoeRaspisanieStatus> statusList;

    @Subscribe
    public void onInit(InitEvent event) {
        statusList = dataManager.loadValue("select srs from StatnoeRaspisanieStatus srs", StatnoeRaspisanieStatus.class).list();
    }

    @Subscribe("upravlenieStatnymRaspisaniemsTable.sendToStatnoeRaspisanie")
    public void onUpravlenieStatnymRaspisaniemsTableSendToStatnoeRaspisanie(Action.ActionPerformedEvent event) {
        UpravlenieStatnymRaspisaniem usr = upravlenieStatnymRaspisaniemsTable.getSingleSelected();
        if (usr.getStatus().getId() == 1 || usr.getStatus().getId() == 3)
            notifications(usr, statusList.get(3), "Отправить на штатное расписание?");

    }

    @Subscribe("upravlenieStatnymRaspisaniemsTable.reply")
    public void onUpravlenieStatnymRaspisaniemsTableReply(Action.ActionPerformedEvent event) {
        UpravlenieStatnymRaspisaniem usr = upravlenieStatnymRaspisaniemsTable.getSingleSelected();
        if (usr.getStatus().getId() == 4) {
            notifications(usr, statusList.get(2), "Есть доработки?");
        }

    }

    @Subscribe("upravlenieStatnymRaspisaniemsTable.finish")
    public void onUpravlenieStatnymRaspisaniemsTableFinish(Action.ActionPerformedEvent event) {
        UpravlenieStatnymRaspisaniem usr = upravlenieStatnymRaspisaniemsTable.getSingleSelected();
        if (usr.getStatus().getId() == 4) {
            notifications(usr, statusList.get(4), "Завершить?");
        }
    }


    public void notifications(UpravlenieStatnymRaspisaniem usr, StatnoeRaspisanieStatus status, String message) {
        dialogs.createInputDialog(this)
                .withCaption(message)
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        usr.setStatus(status);
                        dataManager.save(usr);
                        notifications.create()
                                .withType(Notifications.NotificationType.TRAY)
                                .withCaption("Статус успешно изменен").show();
                    }
                })
                .show();

    }

}
