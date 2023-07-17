package kg.infosystems.buhproject.screen.catalogs.vidyotvetstvennyhlic;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyOtvetstvennyhLic;

@UiController("VidyOtvetstvennyhLic.browse")
@UiDescriptor("vidy-otvetstvennyh-lic-browse.xml")
@LookupComponent("vidyOtvetstvennyhLicsTable")
public class VidyOtvetstvennyhLicBrowse extends StandardLookup<VidyOtvetstvennyhLic> {
}