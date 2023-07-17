package kg.infosystems.buhproject.screen.catalogs.bazoviyoklad;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.BazoviyOklad;

@UiController("BazoviyOklad.browse")
@UiDescriptor("bazoviy-oklad-browse.xml")
@LookupComponent("bazoviyOkladsTable")
public class BazoviyOkladBrowse extends StandardLookup<BazoviyOklad> {
}
