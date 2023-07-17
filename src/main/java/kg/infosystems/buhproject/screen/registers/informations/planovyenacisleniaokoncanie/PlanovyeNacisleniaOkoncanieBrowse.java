package kg.infosystems.buhproject.screen.registers.informations.planovyenacisleniaokoncanie;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaOkoncanie;

@UiController("informations_PlanovyeNacisleniaOkoncanie.browse")
@UiDescriptor("planovye-nacislenia-okoncanie-browse.xml")
@LookupComponent("planovyeNacisleniaOkoncaniesTable")
public class PlanovyeNacisleniaOkoncanieBrowse extends StandardLookup<PlanovyeNacisleniaOkoncanie> {
}
