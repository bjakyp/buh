package kg.infosystems.buhproject.screen.catalogs.nastrojkibalansa;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa;

@UiController("NastrojkiBalansa.browse")
@UiDescriptor("nastrojki-balansa-browse.xml")
@LookupComponent("nastrojkiBalansasTable")
public class NastrojkiBalansaBrowse extends StandardLookup<NastrojkiBalansa> {
}