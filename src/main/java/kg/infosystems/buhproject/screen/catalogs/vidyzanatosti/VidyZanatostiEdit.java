package kg.infosystems.buhproject.screen.catalogs.vidyzanatosti;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyZanatosti;

@UiController("VidyZanatosti.edit")
@UiDescriptor("vidy-zanatosti-edit.xml")
@EditedEntityContainer("vidyZanatostiDc")
public class VidyZanatostiEdit extends StandardEditor<VidyZanatosti> {
}