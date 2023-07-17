package kg.infosystems.buhproject.screen.documents.trudovoesoglasenie;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.TrudovoeSoglasenie;

@UiController("TrudovoeSoglasenie.browse")
@UiDescriptor("trudovoe-soglasenie-browse.xml")
@LookupComponent("trudovoeSoglaseniesTable")
public class TrudovoeSoglasenieBrowse extends StandardLookup<TrudovoeSoglasenie> {
}