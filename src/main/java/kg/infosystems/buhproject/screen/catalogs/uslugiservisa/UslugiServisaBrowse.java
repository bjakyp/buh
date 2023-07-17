package kg.infosystems.buhproject.screen.catalogs.uslugiservisa;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.UslugiServisa;

@UiController("UslugiServisa.browse")
@UiDescriptor("uslugi-servisa-browse.xml")
@LookupComponent("uslugiServisasTable")
public class UslugiServisaBrowse extends StandardLookup<UslugiServisa> {
}