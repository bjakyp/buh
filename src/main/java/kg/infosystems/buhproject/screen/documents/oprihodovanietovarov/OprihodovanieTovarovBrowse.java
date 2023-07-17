package kg.infosystems.buhproject.screen.documents.oprihodovanietovarov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.OprihodovanieTovarov;

@UiController("OprihodovanieTovarov.browse")
@UiDescriptor("oprihodovanie-tovarov-browse.xml")
@LookupComponent("oprihodovanieTovarovsTable")
public class OprihodovanieTovarovBrowse extends StandardLookup<OprihodovanieTovarov> {
}