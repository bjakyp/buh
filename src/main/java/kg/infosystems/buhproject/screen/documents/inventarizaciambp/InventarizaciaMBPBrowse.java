package kg.infosystems.buhproject.screen.documents.inventarizaciambp;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.InventarizaciaMBP;

@UiController("InventarizaciaMBP.browse")
@UiDescriptor("inventarizacia-mbp-browse.xml")
@LookupComponent("inventarizaciaMBPsTable")
public class InventarizaciaMBPBrowse extends StandardLookup<InventarizaciaMBP> {
}