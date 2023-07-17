package kg.infosystems.buhproject.screen.catalogs.nomenklatura;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Nomenklatura;

@UiController("Nomenklatura.browse")
@UiDescriptor("nomenklatura-browse.xml")
@LookupComponent("nomenklaturasTable")
public class NomenklaturaBrowse extends StandardLookup<Nomenklatura> {
}