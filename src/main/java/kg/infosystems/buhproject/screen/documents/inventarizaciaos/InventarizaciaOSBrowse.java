package kg.infosystems.buhproject.screen.documents.inventarizaciaos;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.InventarizaciaOS;

@UiController("InventarizaciaOS.browse")
@UiDescriptor("inventarizacia-os-browse.xml")
@LookupComponent("inventarizaciaOsesTable")
public class InventarizaciaOSBrowse extends StandardLookup<InventarizaciaOS> {
}