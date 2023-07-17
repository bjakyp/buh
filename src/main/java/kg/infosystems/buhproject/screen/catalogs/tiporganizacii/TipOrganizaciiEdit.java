package kg.infosystems.buhproject.screen.catalogs.tiporganizacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.TipOrganizacii;

@UiController("TipOrganizacii.edit")
@UiDescriptor("tip-organizacii-edit.xml")
@EditedEntityContainer("tipOrganizaciiDc")
public class TipOrganizaciiEdit extends StandardEditor<TipOrganizacii> {
}
