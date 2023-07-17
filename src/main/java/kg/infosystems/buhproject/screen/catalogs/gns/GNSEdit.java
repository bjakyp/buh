package kg.infosystems.buhproject.screen.catalogs.gns;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.GNS;

@UiController("GNS.edit")
@UiDescriptor("gns-edit.xml")
@EditedEntityContainer("gNSDc")
public class GNSEdit extends StandardEditor<GNS> {
}