package kg.infosystems.buhproject.screen.catalogs.pol1zateli;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Pol1zovateli;

@UiController("Pol1zovateli.browse")
@UiDescriptor("pol1zovateli-browse.xml")
@LookupComponent("pol1zovatelisTable")
public class Pol1zovateliBrowse extends StandardLookup<Pol1zovateli> {
}
