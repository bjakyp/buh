package kg.infosystems.buhproject.screen.catalogs.vidyobrazovaniafiziceskihlic;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyObrazovaniaFiziceskihLic;

@UiController("VidyObrazovaniaFiziceskihLic.browse")
@UiDescriptor("vidy-obrazovania-fiziceskih-lic-browse.xml")
@LookupComponent("vidyObrazovaniaFiziceskihLicsTable")
public class VidyObrazovaniaFiziceskihLicBrowse extends StandardLookup<VidyObrazovaniaFiziceskihLic> {
}