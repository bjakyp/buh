package kg.infosystems.buhproject.screen.catalogs.sposobyotrazeniazarabotnojplaty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty;

@UiController("SposobyOtrazeniaZarabotnojPlaty.browse")
@UiDescriptor("sposoby-otrazenia-zarabotnoj-platy-browse.xml")
@LookupComponent("sposobyOtrazeniaZarabotnojPlatiesTable")
public class SposobyOtrazeniaZarabotnojPlatyBrowse extends StandardLookup<SposobyOtrazeniaZarabotnojPlaty> {
}
