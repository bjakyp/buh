package kg.infosystems.buhproject.screen.registers.informations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.registers.informations.RazovoeNacislenie;

@UiController("RazovoeNacislenie.browse")
@UiDescriptor("razovoe-nacislenie-browse.xml")
@LookupComponent("razovoeNacisleniesTable")
public class RazovoeNacislenieBrowse extends StandardLookup<RazovoeNacislenie> {
}
