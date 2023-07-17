package kg.infosystems.buhproject.screen.globals.rok;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.globals.Rok;

@UiController("Rok.browse")
@UiDescriptor("rok-browse.xml")
@LookupComponent("roksTable")
public class RokBrowse extends StandardLookup<Rok> {
}
