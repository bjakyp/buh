package kg.infosystems.buhproject.screen.catalogs.voenkomaty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Voenkomaty;

@UiController("Voenkomaty.browse")
@UiDescriptor("voenkomaty-browse.xml")
@LookupComponent("voenkomatiesTable")
public class VoenkomatyBrowse extends StandardLookup<Voenkomaty> {
}