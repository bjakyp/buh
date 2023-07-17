package kg.infosystems.buhproject.screen.catalogs.grafikiraboty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty;

@UiController("GrafikiRaboty.browse")
@UiDescriptor("grafiki-raboty-browse.xml")
@LookupComponent("grafikiRabotiesTable")
public class GrafikiRabotyBrowse extends StandardLookup<GrafikiRaboty> {
}