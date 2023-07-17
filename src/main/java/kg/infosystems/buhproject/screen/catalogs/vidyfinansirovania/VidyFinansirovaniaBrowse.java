package kg.infosystems.buhproject.screen.catalogs.vidyfinansirovania;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania;

@UiController("VidyFinansirovania.browse")
@UiDescriptor("vidy-finansirovania-browse.xml")
@LookupComponent("vidyFinansirovaniasTable")
public class VidyFinansirovaniaBrowse extends StandardLookup<VidyFinansirovania> {
}