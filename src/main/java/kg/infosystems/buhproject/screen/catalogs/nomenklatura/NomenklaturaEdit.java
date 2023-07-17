package kg.infosystems.buhproject.screen.catalogs.nomenklatura;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Nomenklatura;

@UiController("Nomenklatura.edit")
@UiDescriptor("nomenklatura-edit.xml")
@EditedEntityContainer("nomenklaturaDc")
public class NomenklaturaEdit extends StandardEditor<Nomenklatura> {
}