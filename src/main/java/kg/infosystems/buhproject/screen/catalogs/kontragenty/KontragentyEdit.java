package kg.infosystems.buhproject.screen.catalogs.kontragenty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Kontragenty;

@UiController("Kontragenty.edit")
@UiDescriptor("kontragenty-edit.xml")
@EditedEntityContainer("kontragentyDc")
public class KontragentyEdit extends StandardEditor<Kontragenty> {
}