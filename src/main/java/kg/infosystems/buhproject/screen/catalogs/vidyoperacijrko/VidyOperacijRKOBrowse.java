package kg.infosystems.buhproject.screen.catalogs.vidyoperacijrko;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyOperacijRKO;

@UiController("VidyOperacijRKO.browse")
@UiDescriptor("vidy-operacij-rko-browse.xml")
@LookupComponent("vidyOperacijRKoesTable")
public class VidyOperacijRKOBrowse extends StandardLookup<VidyOperacijRKO> {
}