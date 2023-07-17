package kg.infosystems.buhproject.screen.catalogs.tipovyeoperacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.TipovyeOperacii;

@UiController("TipovyeOperacii.edit")
@UiDescriptor("tipovye-operacii-edit.xml")
@EditedEntityContainer("tipovyeOperaciiDc")
public class TipovyeOperaciiEdit extends StandardEditor<TipovyeOperacii> {
}