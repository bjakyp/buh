package kg.infosystems.buhproject.screen.catalogs.profsoyuz;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import kg.infosystems.buhproject.entity.catalogs.Profsoyuz;

@UiController("Profsoyuz.edit")
@UiDescriptor("profsoyuz-edit.xml")
@EditedEntityContainer("profsoyuzDc")
public class ProfsoyuzEdit extends StandardEditor<Profsoyuz> {
}
