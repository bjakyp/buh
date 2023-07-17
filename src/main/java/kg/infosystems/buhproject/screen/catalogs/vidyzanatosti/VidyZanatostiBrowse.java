package kg.infosystems.buhproject.screen.catalogs.vidyzanatosti;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyZanatosti;

@UiController("VidyZanatosti.browse")
@UiDescriptor("vidy-zanatosti-browse.xml")
@LookupComponent("vidyZanatostisTable")
public class VidyZanatostiBrowse extends StandardLookup<VidyZanatosti> {
}