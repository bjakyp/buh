package kg.infosystems.buhproject.screen.catalogs.goroda;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Goroda;

@UiController("Goroda.edit")
@UiDescriptor("goroda-edit.xml")
@EditedEntityContainer("gorodaDc")
public class GorodaEdit extends StandardEditor<Goroda> {
}