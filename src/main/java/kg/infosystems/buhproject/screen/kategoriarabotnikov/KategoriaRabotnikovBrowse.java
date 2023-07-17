package kg.infosystems.buhproject.screen.kategoriarabotnikov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.compensations.KategoriaRabotnikov;

@UiController("KategoriaRabotnikov.browse")
@UiDescriptor("kategoria-rabotnikov-browse.xml")
@LookupComponent("kategoriaRabotnikovsTable")
public class KategoriaRabotnikovBrowse extends StandardLookup<KategoriaRabotnikov> {
}
