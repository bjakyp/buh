package kg.infosystems.buhproject.screen.documents.spisanieosinma;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.SpisanieOSINMA;

@UiController("SpisanieOSINMA.browse")
@UiDescriptor("spisanie-osinma-browse.xml")
@LookupComponent("spisanieOSINMAsTable")
public class SpisanieOSINMABrowse extends StandardLookup<SpisanieOSINMA> {
}