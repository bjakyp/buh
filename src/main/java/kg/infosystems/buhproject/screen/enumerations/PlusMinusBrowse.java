package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.PlusMinus;

@UiController("PlusMinus.browse")
@UiDescriptor("PlusMinus-browse.xml")
@LookupComponent("enumsTable")
public class PlusMinusBrowse extends StandardLookup<PlusMinus> {
}