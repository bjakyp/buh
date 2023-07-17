package kg.infosystems.buhproject.screen.documents.peredacaosinma;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PeredacaOSINMA;

@UiController("PeredacaOSINMA.browse")
@UiDescriptor("peredaca-osinma-browse.xml")
@LookupComponent("peredacaOSINMAsTable")
public class PeredacaOSINMABrowse extends StandardLookup<PeredacaOSINMA> {
}