package kg.infosystems.buhproject.screen.one;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.one.Multiple;

@UiController("Multiple.browse")
@UiDescriptor("multiple-browse.xml")
@LookupComponent("multiplesTable")
public class MultipleBrowse extends StandardLookup<Multiple> {
}
