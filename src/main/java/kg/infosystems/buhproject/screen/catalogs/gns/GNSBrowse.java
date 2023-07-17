package kg.infosystems.buhproject.screen.catalogs.gns;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.GNS;

@UiController("GNS.browse")
@UiDescriptor("gns-browse.xml")
@LookupComponent("gNsesTable")
public class GNSBrowse extends StandardLookup<GNS> {
}