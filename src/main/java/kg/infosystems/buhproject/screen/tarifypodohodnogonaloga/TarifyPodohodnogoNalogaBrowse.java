package kg.infosystems.buhproject.screen.tarifypodohodnogonaloga;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.compensations.TarifyPodohodnogoNaloga;

@UiController("TarifyPodohodnogoNaloga.browse")
@UiDescriptor("tarify-podohodnogo-naloga-browse.xml")
@LookupComponent("tarifyPodohodnogoNalogasTable")
public class TarifyPodohodnogoNalogaBrowse extends StandardLookup<TarifyPodohodnogoNaloga> {
}
