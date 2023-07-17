package kg.infosystems.buhproject.screen.catalogs.kvalifikaciisotrudnikov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KvalifikaciiSotrudnikov;

@UiController("KvalifikaciiSotrudnikov.browse")
@UiDescriptor("kvalifikacii-sotrudnikov-browse.xml")
@LookupComponent("kvalifikaciiSotrudnikovsTable")
public class KvalifikaciiSotrudnikovBrowse extends StandardLookup<KvalifikaciiSotrudnikov> {
}