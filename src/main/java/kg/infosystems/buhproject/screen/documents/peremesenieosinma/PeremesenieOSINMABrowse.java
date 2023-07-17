package kg.infosystems.buhproject.screen.documents.peremesenieosinma;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PeremesenieOSINMA;

@UiController("PeremesenieOSINMA.browse")
@UiDescriptor("peremesenie-osinma-browse.xml")
@LookupComponent("peremesenieOSINMAsTable")
public class PeremesenieOSINMABrowse extends StandardLookup<PeremesenieOSINMA> {
}