package kg.infosystems.buhproject.screen.catalogs.postavsikiuslugservisa;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.PostavsikiUslugServisa;

@UiController("PostavsikiUslugServisa.browse")
@UiDescriptor("postavsiki-uslug-servisa-browse.xml")
@LookupComponent("postavsikiUslugServisasTable")
public class PostavsikiUslugServisaBrowse extends StandardLookup<PostavsikiUslugServisa> {
}