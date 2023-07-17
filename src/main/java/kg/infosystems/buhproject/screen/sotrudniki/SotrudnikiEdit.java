package kg.infosystems.buhproject.screen.sotrudniki;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;

@UiController("informations_Sotrudniki.edit")
@UiDescriptor("sotrudniki-edit.xml")
@EditedEntityContainer("sotrudnikiDc")
public class SotrudnikiEdit extends StandardEditor<Sotrudniki> {
}
