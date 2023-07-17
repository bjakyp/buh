package kg.infosystems.buhproject.screen.catalogs.tomahraneniafajlov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.TomaHraneniaFajlov;

@UiController("TomaHraneniaFajlov.browse")
@UiDescriptor("toma-hranenia-fajlov-browse.xml")
@LookupComponent("tomaHraneniaFajlovsTable")
public class TomaHraneniaFajlovBrowse extends StandardLookup<TomaHraneniaFajlov> {
}