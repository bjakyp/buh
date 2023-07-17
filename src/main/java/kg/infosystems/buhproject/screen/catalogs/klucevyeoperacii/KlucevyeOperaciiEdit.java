package kg.infosystems.buhproject.screen.catalogs.klucevyeoperacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KlucevyeOperacii;

@UiController("KlucevyeOperacii.edit")
@UiDescriptor("klucevye-operacii-edit.xml")
@EditedEntityContainer("klucevyeOperaciiDc")
public class KlucevyeOperaciiEdit extends StandardEditor<KlucevyeOperacii> {
}