package kg.infosystems.buhproject.screen.catalogs.doljnostnieoklady;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import kg.infosystems.buhproject.entity.catalogs.DoljnostnieOklady;

@UiController("DoljnostnieOklady.browse")
@UiDescriptor("doljnostnie-oklady-browse.xml")
@LookupComponent("doljnostnieOkladiesTable")
public class DoljnostnieOkladyBrowse extends StandardLookup<DoljnostnieOklady> {
}
