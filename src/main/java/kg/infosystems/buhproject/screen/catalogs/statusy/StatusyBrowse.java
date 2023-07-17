package kg.infosystems.buhproject.screen.catalogs.statusy;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Statusy;

@UiController("Statusy.browse")
@UiDescriptor("statusy-browse.xml")
@LookupComponent("statusiesTable")
public class StatusyBrowse extends StandardLookup<Statusy> {
}