package kg.infosystems.buhproject.screen.catalogs.uslugiservisa;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.UslugiServisa;

@UiController("UslugiServisa.edit")
@UiDescriptor("uslugi-servisa-edit.xml")
@EditedEntityContainer("uslugiServisaDc")
public class UslugiServisaEdit extends StandardEditor<UslugiServisa> {
}