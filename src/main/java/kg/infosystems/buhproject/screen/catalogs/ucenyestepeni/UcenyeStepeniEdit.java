package kg.infosystems.buhproject.screen.catalogs.ucenyestepeni;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.UcenyeStepeni;

@UiController("UcenyeStepeni.edit")
@UiDescriptor("ucenye-stepeni-edit.xml")
@EditedEntityContainer("ucenyeStepeniDc")
public class UcenyeStepeniEdit extends StandardEditor<UcenyeStepeni> {
}