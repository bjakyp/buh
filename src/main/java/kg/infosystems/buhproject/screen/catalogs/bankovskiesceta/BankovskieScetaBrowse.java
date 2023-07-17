package kg.infosystems.buhproject.screen.catalogs.bankovskiesceta;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.BankovskieSceta;

@UiController("BankovskieSceta.browse")
@UiDescriptor("bankovskie-sceta-browse.xml")
@LookupComponent("bankovskieScetasTable")
public class BankovskieScetaBrowse extends StandardLookup<BankovskieSceta> {
}