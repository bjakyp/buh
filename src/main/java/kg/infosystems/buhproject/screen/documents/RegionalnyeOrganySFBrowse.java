package kg.infosystems.buhproject.screen.documents;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RegionalnyeOrganySF;

@UiController("RegionalnyeOrganySF.browse")
@UiDescriptor("regionalnye-organy-sf-browse.xml")
@LookupComponent("regionalnyeOrganySFsTable")
public class RegionalnyeOrganySFBrowse extends StandardLookup<RegionalnyeOrganySF> {
}
