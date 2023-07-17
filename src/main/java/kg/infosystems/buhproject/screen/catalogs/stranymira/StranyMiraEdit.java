package kg.infosystems.buhproject.screen.catalogs.stranymira;

import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.StranyMira;

@UiController("StranyMira.edit")
@UiDescriptor("strany-mira-edit.xml")
@EditedEntityContainer("stranyMiraDc")
public class StranyMiraEdit extends StandardEditor<StranyMira> {
    @Subscribe("naimenovanieField")
    public void onNaimenovanieFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        String name = event.getValue();
        if (name != null && name.length() > 0) {
            getEditedEntity().setNaimenovanie(name.substring(0, 1).toUpperCase() + name.substring(1));
        }
    }
}
