package kg.infosystems.buhproject.screen.catalogs.vedomstvennayaclassifikacia;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VedomstvennayaClassifikacia;

@UiController("VedomstvennayaClassifikacia.edit")
@UiDescriptor("vedomstvennaya-classifikacia-edit.xml")
@EditedEntityContainer("vedomstvennayaClassifikaciaDc")
public class VedomstvennayaClassifikaciaEdit extends StandardEditor<VedomstvennayaClassifikacia> {
}
