package kg.infosystems.buhproject.screen.catalogs;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.RegistrDoljnosti;

@UiController("RegistrDoljnosti.edit")
@UiDescriptor("registr-doljnosti-edit.xml")
@EditedEntityContainer("registrDoljnostiDc")
public class RegistrDoljnostiEdit extends StandardEditor<RegistrDoljnosti> {
}
