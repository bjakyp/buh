package kg.infosystems.buhproject.screen.catalogs.dolznosti;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Dolznosti;

@UiController("Dolznosti.browse")
@UiDescriptor("dolznosti-browse.xml")
@LookupComponent("dolznostisTable")
public class DolznostiBrowse extends StandardLookup<Dolznosti> {
}