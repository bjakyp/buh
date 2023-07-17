package kg.infosystems.buhproject.screen.catalogs.osnovnyesredstva;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.OsnovnyeSredstva;

@UiController("OsnovnyeSredstva.browse")
@UiDescriptor("osnovnye-sredstva-browse.xml")
@LookupComponent("osnovnyeSredstvasTable")
public class OsnovnyeSredstvaBrowse extends StandardLookup<OsnovnyeSredstva> {
}