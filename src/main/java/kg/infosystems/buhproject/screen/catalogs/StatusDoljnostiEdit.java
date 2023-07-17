package kg.infosystems.buhproject.screen.catalogs;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.StatusDoljnosti;

@UiController("StatusDoljnosti.edit")
@UiDescriptor("status-doljnosti-edit.xml")
@EditedEntityContainer("statusDoljnostiDc")
public class StatusDoljnostiEdit extends StandardEditor<StatusDoljnosti> {
}
