package kg.infosystems.buhproject.screen.catalogs.vedomstvennayaclassifikacia;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VedomstvennayaClassifikacia;

@UiController("VedomstvennayaClassifikacia.browse")
@UiDescriptor("vedomstvennaya-classifikacia-browse.xml")
@LookupComponent("vedomstvennayaClassifikaciasTable")
public class VedomstvennayaClassifikaciaBrowse extends StandardLookup<VedomstvennayaClassifikacia> {
}
