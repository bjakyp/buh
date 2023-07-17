package kg.infosystems.buhproject.screen.compensations.vidyuderzanij;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.ContentMode;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.compensations.VidyUderzanij;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("VidyUderzanij.edit")
@UiDescriptor("vidy-uderzanij-edit.xml")
@EditedEntityContainer("vidyUderzanijDc")
public class VidyUderzanijEdit extends StandardEditor<VidyUderzanij> {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private Notifications notifications;
    @Autowired
    private TextField<Integer> poradokField;

    @Subscribe("poradokField")
    public void onPoradokFieldValueChange(HasValue.ValueChangeEvent<Integer> event) {
        if(event.getValue() != null){
            List<VidyUderzanij> vidyUderzanijs = dataManager.load(VidyUderzanij.class)
                .query("select o from VidyUderzanij o where o.poradok = :poradok and o.id <> :id")
                .parameter("poradok", event.getValue())
                .parameter("id", getEditedEntity().getId())
                .list();
            if(!vidyUderzanijs.isEmpty()){
                notifications.create()
                    .withCaption("<code>Ошибка!</code>")
                    .withDescription("Вид удержания с таким порядковым номером уже существует!")
                    .withType(Notifications.NotificationType.ERROR)
                    .withContentMode(ContentMode.HTML)
                    .show();
                poradokField.setValue(null);
            }
        }
    }
}
