package kg.infosystems.buhproject.screen.catalogs.dolznosti;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Dolznosti;

@UiController("Dolznosti.edit")
@UiDescriptor("dolznosti-edit.xml")
@EditedEntityContainer("dolznostiDc")
public class DolznostiEdit extends StandardEditor<Dolznosti> {
}