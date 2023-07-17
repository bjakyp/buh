package kg.infosystems.buhproject.screen.kategoriarabotnikov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.compensations.KategoriaRabotnikov;

@UiController("KategoriaRabotnikov.edit")
@UiDescriptor("kategoria-rabotnikov-edit.xml")
@EditedEntityContainer("kategoriaRabotnikovDc")
public class KategoriaRabotnikovEdit extends StandardEditor<KategoriaRabotnikov> {
}
