package kg.infosystems.buhproject.entity.globals;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.globals.Programmy;

@UiController("Programmy.browse")
@UiDescriptor("programmy-browse.xml")
@LookupComponent("programmiesTable")
public class ProgrammyBrowse extends StandardLookup<Programmy> {
}
