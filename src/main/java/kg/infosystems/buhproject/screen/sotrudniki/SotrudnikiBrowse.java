package kg.infosystems.buhproject.screen.sotrudniki;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;

@UiController("informations_Sotrudniki.browse")
@UiDescriptor("sotrudniki-browse.xml")
@LookupComponent("sotrudnikisTable")
public class SotrudnikiBrowse extends StandardLookup<Sotrudniki> {
}
