package kg.infosystems.buhproject.screen.catalogs.vidyoperacijppi;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyOperacijPPI;

@UiController("VidyOperacijPPI.browse")
@UiDescriptor("vidy-operacij-ppi-browse.xml")
@LookupComponent("vidyOperacijPPIsTable")
public class VidyOperacijPPIBrowse extends StandardLookup<VidyOperacijPPI> {
}