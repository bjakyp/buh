package kg.infosystems.buhproject.screen.catalogs.valuty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Valuty;

@UiController("Valuty.edit")
@UiDescriptor("valuty-edit.xml")
@EditedEntityContainer("valutyDc")
public class ValutyEdit extends StandardEditor<Valuty> {
}