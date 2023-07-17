package kg.infosystems.buhproject.screen.catalogs.sklady;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Sklady;

@UiController("Sklady.edit")
@UiDescriptor("sklady-edit.xml")
@EditedEntityContainer("skladyDc")
public class SkladyEdit extends StandardEditor<Sklady> {
}