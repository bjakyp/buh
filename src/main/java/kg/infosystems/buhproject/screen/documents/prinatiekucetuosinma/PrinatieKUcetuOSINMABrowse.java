package kg.infosystems.buhproject.screen.documents.prinatiekucetuosinma;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PrinatieKUcetuOSINMA;

@UiController("PrinatieKUcetuOSINMA.browse")
@UiDescriptor("prinatie-k-ucetu-osinma-browse.xml")
@LookupComponent("prinatieKUcetuOSINMAsTable")
public class PrinatieKUcetuOSINMABrowse extends StandardLookup<PrinatieKUcetuOSINMA> {
}