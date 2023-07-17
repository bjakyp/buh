package kg.infosystems.buhproject.screen.catalogs.voenkomaty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Voenkomaty;

@UiController("Voenkomaty.edit")
@UiDescriptor("voenkomaty-edit.xml")
@EditedEntityContainer("voenkomatyDc")
public class VoenkomatyEdit extends StandardEditor<Voenkomaty> {
}