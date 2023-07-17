package kg.infosystems.buhproject.screen.catalogs.kartscetasotrudnikov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KartScetaSotrudnikov;

@UiController("KartScetaSotrudnikov.edit")
@UiDescriptor("kart-sceta-sotrudnikov-edit.xml")
@EditedEntityContainer("kartScetaSotrudnikovDc")
public class KartScetaSotrudnikovEdit extends StandardEditor<KartScetaSotrudnikov> {
}