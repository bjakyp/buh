package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.FormaObucenia;

@UiController("FormaObucenia.browse")
@UiDescriptor("FormaObucenia-browse.xml")
@LookupComponent("enumsTable")
public class FormaObuceniaBrowse extends StandardLookup<FormaObucenia> {
}