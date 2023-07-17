package kg.infosystems.buhproject.screen.catalogs.tiporganizacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.TipOrganizacii;

@UiController("TipOrganizacii.browse")
@UiDescriptor("tip-organizacii-browse.xml")
@LookupComponent("tipOrganizaciisTable")
public class TipOrganizaciiBrowse extends StandardLookup<TipOrganizacii> {
}
