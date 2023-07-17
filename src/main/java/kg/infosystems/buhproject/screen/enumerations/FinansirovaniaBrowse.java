package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.Finansirovania;

@UiController("Finansirovania.browse")
@UiDescriptor("Finansirovania-browse.xml")
@LookupComponent("enumsTable")
public class FinansirovaniaBrowse extends StandardLookup<Finansirovania> {
}