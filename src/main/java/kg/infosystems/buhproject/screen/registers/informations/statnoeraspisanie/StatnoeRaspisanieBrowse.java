package kg.infosystems.buhproject.screen.registers.informations.statnoeraspisanie;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.registers.informations.StatnoeRaspisanie;

@UiController("informations_StatnoeRaspisanie.browse")
@UiDescriptor("statnoe-raspisanie-browse.xml")
@LookupComponent("statnoeRaspisaniesTable")
public class StatnoeRaspisanieBrowse extends StandardLookup<StatnoeRaspisanie> {
}