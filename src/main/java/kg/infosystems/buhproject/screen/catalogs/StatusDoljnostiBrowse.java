package kg.infosystems.buhproject.screen.catalogs;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.StatusDoljnosti;

@UiController("StatusDoljnosti.browse")
@UiDescriptor("status-doljnosti-browse.xml")
@LookupComponent("statusDoljnostisTable")
public class StatusDoljnostiBrowse extends StandardLookup<StatusDoljnosti> {
}
