package kg.infosystems.buhproject.screen.catalogs.osnovnyesredstva;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.OsnovnyeSredstva;

@UiController("OsnovnyeSredstva.edit")
@UiDescriptor("osnovnye-sredstva-edit.xml")
@EditedEntityContainer("osnovnyeSredstvaDc")
public class OsnovnyeSredstvaEdit extends StandardEditor<OsnovnyeSredstva> {
}