package kg.infosystems.buhproject.screen.documents.vedomost1zarabotnojplaty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Vedomost1ZarabotnojPlaty;

@UiController("Vedomost1ZarabotnojPlaty.browse")
@UiDescriptor("vedomost1-zarabotnoj-platy-browse.xml")
@LookupComponent("vedomost1ZarabotnojPlatiesTable")
public class Vedomost1ZarabotnojPlatyBrowse extends StandardLookup<Vedomost1ZarabotnojPlaty> {
}