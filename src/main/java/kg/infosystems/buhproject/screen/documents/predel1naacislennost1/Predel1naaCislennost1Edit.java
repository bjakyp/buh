package kg.infosystems.buhproject.screen.documents.predel1naacislennost1;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;
import kg.infosystems.buhproject.entity.documents.Predel1naaCislennost1;
import kg.infosystems.buhproject.entity.globals.Rok;

import javax.inject.Inject;
import java.util.List;

@UiController("Predel1naaCislennost1.edit")
@UiDescriptor("predel1naa-cislennost1-edit.xml")
@EditedEntityContainer("predel1naaCislennost1Dc")
public class Predel1naaCislennost1Edit extends StandardEditor<Predel1naaCislennost1> {
    @Inject
    private ComboBox<Organizacii> organizaciaField;
    @Inject
    private ComboBox<Rok> tumfField;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;

    private Organizacii organizacii;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        organizacii = getEditedEntity().getOrganizacia();
    }

    @Subscribe
    public void onInit(InitEvent event) {
        organizaciaField.setOptionsList(dataManager.load(Organizacii.class).all().fetchPlan("organizacii-fetch-plan").list());
        tumfField.setOptionsList(dataManager.load(Rok.class).all().fetchPlan("rok-fetch-plan").list());
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Organizacii org = organizaciaField.getValue();
        List<Predel1naaCislennost1> pcList = dataManager.load(Predel1naaCislennost1.class)
            .query("select e from Predel1naaCislennost1 e where e.organizacia = :org")
            .parameter("org", org)
            .list();
        if (!pcList.isEmpty() && org != organizacii) {
            showNotification("Организация с таким именем уже есть!", "Выберите другую", Notifications.NotificationType.WARNING);
            organizaciaField.setValue(organizacii);
            event.preventCommit();
        }
    }


    private void showNotification(String caption, String desc, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(desc)
            .withType(type)
            .show();
    }

}
