package kg.infosystems.buhproject.screen.catalogs.tomahraneniafajlov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.TomaHraneniaFajlov;

@UiController("TomaHraneniaFajlov.edit")
@UiDescriptor("toma-hranenia-fajlov-edit.xml")
@EditedEntityContainer("tomaHraneniaFajlovDc")
public class TomaHraneniaFajlovEdit extends StandardEditor<TomaHraneniaFajlov> {
}