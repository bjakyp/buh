package kg.infosystems.buhproject.screen.registers.informations.scetaucetanomenklatury;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.registers.informations.ScetaUcetaNomenklatury;

@UiController("informations_ScetaUcetaNomenklatury.browse")
@UiDescriptor("sceta-uceta-nomenklatury-browse.xml")
@LookupComponent("scetaUcetaNomenklaturiesTable")
public class ScetaUcetaNomenklaturyBrowse extends StandardLookup<ScetaUcetaNomenklatury> {
}