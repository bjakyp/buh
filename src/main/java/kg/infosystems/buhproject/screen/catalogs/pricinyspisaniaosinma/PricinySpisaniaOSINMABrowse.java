package kg.infosystems.buhproject.screen.catalogs.pricinyspisaniaosinma;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.PricinySpisaniaOSINMA;

@UiController("PricinySpisaniaOSINMA.browse")
@UiDescriptor("priciny-spisania-osinma-browse.xml")
@LookupComponent("pricinySpisaniaOSINMAsTable")
public class PricinySpisaniaOSINMABrowse extends StandardLookup<PricinySpisaniaOSINMA> {
}