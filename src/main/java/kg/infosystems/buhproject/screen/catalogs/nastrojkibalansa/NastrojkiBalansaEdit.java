package kg.infosystems.buhproject.screen.catalogs.nastrojkibalansa;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa;

@UiController("NastrojkiBalansa.edit")
@UiDescriptor("nastrojki-balansa-edit.xml")
@EditedEntityContainer("nastrojkiBalansaDc")
public class NastrojkiBalansaEdit extends StandardEditor<NastrojkiBalansa> {
}