package kg.infosystems.buhproject.screen.catalogs.sobytiastovarami;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.SobytiaSTovarami;

@UiController("SobytiaSTovarami.browse")
@UiDescriptor("sobytia-s-tovarami-browse.xml")
@LookupComponent("sobytiaSTovaramisTable")
public class SobytiaSTovaramiBrowse extends StandardLookup<SobytiaSTovarami> {
}