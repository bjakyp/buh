package kg.infosystems.buhproject.screen.catalogs.bankovskiesceta;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.BankovskieSceta;

@UiController("BankovskieSceta.edit")
@UiDescriptor("bankovskie-sceta-edit.xml")
@EditedEntityContainer("bankovskieScetaDc")
public class BankovskieScetaEdit extends StandardEditor<BankovskieSceta> {
}