package kg.infosystems.buhproject.screen.catalogs.kassy;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Kassy;

@UiController("Kassy.browse")
@UiDescriptor("kassy-browse.xml")
@LookupComponent("kassiesTable")
public class KassyBrowse extends StandardLookup<Kassy> {
}