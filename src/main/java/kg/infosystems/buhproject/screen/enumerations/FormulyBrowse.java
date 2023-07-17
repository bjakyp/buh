package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.Formuly;

@UiController("Formuly.browse")
@UiDescriptor("Formuly-browse.xml")
@LookupComponent("enumsTable")
public class FormulyBrowse extends StandardLookup<Formuly> {
}