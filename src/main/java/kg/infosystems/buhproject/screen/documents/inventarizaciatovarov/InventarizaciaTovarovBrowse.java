package kg.infosystems.buhproject.screen.documents.inventarizaciatovarov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.InventarizaciaTovarov;

@UiController("InventarizaciaTovarov.browse")
@UiDescriptor("inventarizacia-tovarov-browse.xml")
@LookupComponent("inventarizaciaTovarovsTable")
public class InventarizaciaTovarovBrowse extends StandardLookup<InventarizaciaTovarov> {
}