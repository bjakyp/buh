package kg.infosystems.buhproject.screen.stavkipodohodnogonaloga;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.StavkiPodohodnogoNaloga;

@UiController("StavkiPodohodnogoNaloga.browse")
@UiDescriptor("stavki-podohodnogo-naloga-browse.xml")
@LookupComponent("stavkiPodohodnogoNalogasTable")
public class StavkiPodohodnogoNalogaBrowse extends StandardLookup<StavkiPodohodnogoNaloga> {
}
