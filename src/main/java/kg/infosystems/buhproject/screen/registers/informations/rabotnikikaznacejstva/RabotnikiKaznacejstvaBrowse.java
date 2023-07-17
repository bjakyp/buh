package kg.infosystems.buhproject.screen.registers.informations.rabotnikikaznacejstva;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.registers.informations.RabotnikiKaznacejstva;

@UiController("informations_RabotnikiKaznacejstva.browse")
@UiDescriptor("rabotniki-kaznacejstva-browse.xml")
@LookupComponent("rabotnikiKaznacejstvasTable")
public class RabotnikiKaznacejstvaBrowse extends StandardLookup<RabotnikiKaznacejstva> {
}