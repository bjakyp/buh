package kg.infosystems.buhproject.screen.catalogs.vidyproverok;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyProverok;

@UiController("VidyProverok.browse")
@UiDescriptor("vidy-proverok-browse.xml")
@LookupComponent("vidyProveroksTable")
public class VidyProverokBrowse extends StandardLookup<VidyProverok> {
}