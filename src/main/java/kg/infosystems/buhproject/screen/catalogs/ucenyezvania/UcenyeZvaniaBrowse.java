package kg.infosystems.buhproject.screen.catalogs.ucenyezvania;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.UcenyeZvania;

@UiController("UcenyeZvania.browse")
@UiDescriptor("ucenye-zvania-browse.xml")
@LookupComponent("ucenyeZvaniasTable")
public class UcenyeZvaniaBrowse extends StandardLookup<UcenyeZvania> {
}