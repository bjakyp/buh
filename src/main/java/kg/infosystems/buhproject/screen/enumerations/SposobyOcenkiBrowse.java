package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.SposobyOcenki;

@UiController("SposobyOcenki.browse")
@UiDescriptor("SposobyOcenki-browse.xml")
@LookupComponent("enumsTable")
public class SposobyOcenkiBrowse extends StandardLookup<SposobyOcenki> {
}