package kg.infosystems.buhproject.screen.catalogs.kvalifikaciisotrudnikov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KvalifikaciiSotrudnikov;

@UiController("KvalifikaciiSotrudnikov.edit")
@UiDescriptor("kvalifikacii-sotrudnikov-edit.xml")
@EditedEntityContainer("kvalifikaciiSotrudnikovDc")
public class KvalifikaciiSotrudnikovEdit extends StandardEditor<KvalifikaciiSotrudnikov> {
}