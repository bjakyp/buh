package kg.infosystems.buhproject.screen.catalogs.statusy;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Statusy;

@UiController("Statusy.edit")
@UiDescriptor("statusy-edit.xml")
@EditedEntityContainer("statusyDc")
public class StatusyEdit extends StandardEditor<Statusy> {
}