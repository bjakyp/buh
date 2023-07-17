package kg.infosystems.buhproject.screen.organizacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;

@UiController("Organizacii.browse")
@UiDescriptor("organizacii-browse.xml")
@LookupComponent("organizaciisTable")
public class OrganizaciiBrowse extends StandardLookup<Organizacii> {
}
