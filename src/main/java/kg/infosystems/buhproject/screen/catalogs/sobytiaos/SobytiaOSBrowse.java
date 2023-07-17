package kg.infosystems.buhproject.screen.catalogs.sobytiaos;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.SobytiaOS;

@UiController("SobytiaOS.browse")
@UiDescriptor("sobytia-os-browse.xml")
@LookupComponent("sobytiaOsesTable")
public class SobytiaOSBrowse extends StandardLookup<SobytiaOS> {
}