package kg.infosystems.buhproject.screen.catalogs.stranymira;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.StranyMira;

@UiController("StranyMira.browse")
@UiDescriptor("strany-mira-browse.xml")
@LookupComponent("stranyMirasTable")
public class StranyMiraBrowse extends StandardLookup<StranyMira> {
}