package kg.infosystems.buhproject.screen.documents.profvznosy;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Profvznosy;

@UiController("Profvznosy.browse")
@UiDescriptor("profvznosy-browse.xml")
@LookupComponent("profvznosiesTable")
public class ProfvznosyBrowse extends StandardLookup<Profvznosy> {
}