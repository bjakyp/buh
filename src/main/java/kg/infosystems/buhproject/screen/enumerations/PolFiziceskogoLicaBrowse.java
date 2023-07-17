package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.PolFiziceskogoLica;

@UiController("PolFiziceskogoLica.browse")
@UiDescriptor("PolFiziceskogoLica-browse.xml")
@LookupComponent("enumsTable")
public class PolFiziceskogoLicaBrowse extends StandardLookup<PolFiziceskogoLica> {
}