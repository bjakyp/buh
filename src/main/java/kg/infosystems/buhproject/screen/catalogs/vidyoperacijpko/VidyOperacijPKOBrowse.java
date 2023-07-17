package kg.infosystems.buhproject.screen.catalogs.vidyoperacijpko;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyOperacijPKO;

@UiController("VidyOperacijPKO.browse")
@UiDescriptor("vidy-operacij-pko-browse.xml")
@LookupComponent("vidyOperacijPKoesTable")
public class VidyOperacijPKOBrowse extends StandardLookup<VidyOperacijPKO> {
}