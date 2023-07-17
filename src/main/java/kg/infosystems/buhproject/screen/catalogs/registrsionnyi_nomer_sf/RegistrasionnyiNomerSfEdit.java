package kg.infosystems.buhproject.screen.catalogs.registrsionnyi_nomer_sf;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.ValidationException;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.RegistrasionnyiNomerSf;
import kg.infosystems.buhproject.entity.documents.RegionalnyeOrganySF;

import javax.inject.Inject;

@UiController("RegistrasionnyiNomerSf.edit")
@UiDescriptor("registrasionnyi-nomer-sf-edit.xml")
@EditedEntityContainer("registrasionnyiNomerSfDc")
public class RegistrasionnyiNomerSfEdit extends StandardEditor<RegistrasionnyiNomerSf> {
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;

    @Subscribe("registrasionnyiNomerField")
    public void onRegistrasionnyiNomerFieldValueChange(HasValue.ValueChangeEvent<Long> event) {
        if (event.getValue() != null && event.getValue() > 99) {
            String code = event.getValue().toString().substring(0, 3);
            RegionalnyeOrganySF kodRayona = dataManager.load(RegionalnyeOrganySF.class)
                .query("select e from RegionalnyeOrganySF e where e.kod = :code")
                .parameter("code", code)
                .optional().orElse(null);
            getEditedEntity().setKodRayonaSf(kodRayona);
        }
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (!getEditedEntity().getRegistrasionnyiNomer().toString().substring(0, 3).equals(getEditedEntity().getKodRayonaSf().getKod())) {
            notifications.create()
                .withCaption("Регистрационный номер и код района не совпадают!")
                .withPosition(Notifications.Position.MIDDLE_CENTER)
                .withType(Notifications.NotificationType.WARNING)
                .show();
            event.preventCommit();
        }
    }

    @Install(to = "registrasionnyiNomerField", subject = "validator")
    private void registrasionnyiNomerFieldValidator(Long value) {
        if (value.toString().length() < 12) {
            throw new ValidationException("Минимальная длина 12 символов");
        }
    }
}
