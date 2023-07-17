package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.PrilozeniaDlaUvazki;

@UiController("PrilozeniaDlaUvazki.browse")
@UiDescriptor("PrilozeniaDlaUvazki-browse.xml")
@LookupComponent("enumsTable")
public class PrilozeniaDlaUvazkiBrowse extends StandardLookup<PrilozeniaDlaUvazki> {
}