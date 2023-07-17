package kg.infosystems.buhproject.screen.catalogs.vidykontaktnojinformacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyKontaktnojInformacii;

@UiController("VidyKontaktnojInformacii.browse")
@UiDescriptor("vidy-kontaktnoj-informacii-browse.xml")
@LookupComponent("vidyKontaktnojInformaciisTable")
public class VidyKontaktnojInformaciiBrowse extends StandardLookup<VidyKontaktnojInformacii> {
}