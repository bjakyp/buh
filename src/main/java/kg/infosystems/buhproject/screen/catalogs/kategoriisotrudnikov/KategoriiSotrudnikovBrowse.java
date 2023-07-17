package kg.infosystems.buhproject.screen.catalogs.kategoriisotrudnikov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KategoriiSotrudnikov;

@UiController("KategoriiSotrudnikov.browse")
@UiDescriptor("kategorii-sotrudnikov-browse.xml")
@LookupComponent("kategoriiSotrudnikovsTable")
public class KategoriiSotrudnikovBrowse extends StandardLookup<KategoriiSotrudnikov> {
}