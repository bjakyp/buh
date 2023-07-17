package kg.infosystems.buhproject.screen.catalogs.sobytiaos;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.SobytiaOS;

@UiController("SobytiaOS.edit")
@UiDescriptor("sobytia-os-edit.xml")
@EditedEntityContainer("sobytiaOSDc")
public class SobytiaOSEdit extends StandardEditor<SobytiaOS> {
}