package kg.infosystems.buhproject.screen.documents;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RegionalnyeOrganyUGNS;

@UiController("RegionalnyeOrganyUGNS.browse")
@UiDescriptor("regionalnye-organy-ugns-browse.xml")
@LookupComponent("regionalnyeOrganyUGNsesTable")
public class RegionalnyeOrganyUGNSBrowse extends StandardLookup<RegionalnyeOrganyUGNS> {
}
