package kg.infosystems.buhproject.screen.catalogs.kartscetasotrudnikov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KartScetaSotrudnikov;

@UiController("KartScetaSotrudnikov.browse")
@UiDescriptor("kart-sceta-sotrudnikov-browse.xml")
@LookupComponent("kartScetaSotrudnikovsTable")
public class KartScetaSotrudnikovBrowse extends StandardLookup<KartScetaSotrudnikov> {
}