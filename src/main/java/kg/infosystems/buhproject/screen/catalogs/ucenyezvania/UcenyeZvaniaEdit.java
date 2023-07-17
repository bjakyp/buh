package kg.infosystems.buhproject.screen.catalogs.ucenyezvania;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.UcenyeZvania;

@UiController("UcenyeZvania.edit")
@UiDescriptor("ucenye-zvania-edit.xml")
@EditedEntityContainer("ucenyeZvaniaDc")
public class UcenyeZvaniaEdit extends StandardEditor<UcenyeZvania> {
}