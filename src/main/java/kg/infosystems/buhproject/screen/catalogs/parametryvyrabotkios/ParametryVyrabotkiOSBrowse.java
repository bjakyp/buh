package kg.infosystems.buhproject.screen.catalogs.parametryvyrabotkios;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.ParametryVyrabotkiOS;

@UiController("ParametryVyrabotkiOS.browse")
@UiDescriptor("parametry-vyrabotki-os-browse.xml")
@LookupComponent("parametryVyrabotkiOsesTable")
public class ParametryVyrabotkiOSBrowse extends StandardLookup<ParametryVyrabotkiOS> {
}