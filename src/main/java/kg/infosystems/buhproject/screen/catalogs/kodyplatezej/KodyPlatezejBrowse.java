package kg.infosystems.buhproject.screen.catalogs.kodyplatezej;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KodyPlatezej;

@UiController("KodyPlatezej.browse")
@UiDescriptor("kody-platezej-browse.xml")
@LookupComponent("kodyPlatezejsTable")
public class KodyPlatezejBrowse extends StandardLookup<KodyPlatezej> {
}