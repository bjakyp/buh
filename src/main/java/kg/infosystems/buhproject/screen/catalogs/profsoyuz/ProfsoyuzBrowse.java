package kg.infosystems.buhproject.screen.catalogs.profsoyuz;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import kg.infosystems.buhproject.entity.catalogs.Profsoyuz;

@UiController("Profsoyuz.browse")
@UiDescriptor("profsoyuz-browse.xml")
@LookupComponent("profsoyuzesTable")
public class ProfsoyuzBrowse extends StandardLookup<Profsoyuz> {
}
