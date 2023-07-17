package kg.infosystems.buhproject.screen.catalogs.kontragenty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Kontragenty;

@UiController("Kontragenty.browse")
@UiDescriptor("kontragenty-browse.xml")
@LookupComponent("kontragentiesTable")
public class KontragentyBrowse extends StandardLookup<Kontragenty> {
}