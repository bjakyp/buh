package kg.infosystems.buhproject.screen.catalogs.vidyoperacijppv;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyOperacijPPV;

@UiController("VidyOperacijPPV.browse")
@UiDescriptor("vidy-operacij-ppv-browse.xml")
@LookupComponent("vidyOperacijPPVsTable")
public class VidyOperacijPPVBrowse extends StandardLookup<VidyOperacijPPV> {
}