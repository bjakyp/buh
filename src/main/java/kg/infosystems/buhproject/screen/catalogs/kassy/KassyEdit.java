package kg.infosystems.buhproject.screen.catalogs.kassy;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Kassy;

@UiController("Kassy.edit")
@UiDescriptor("kassy-edit.xml")
@EditedEntityContainer("kassyDc")
public class KassyEdit extends StandardEditor<Kassy> {
}