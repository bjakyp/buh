package kg.infosystems.buhproject.screen.catalogs.gruppypol1zovatelej;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.GruppyPol1zovatelej;

@UiController("GruppyPol1zovatelej.browse")
@UiDescriptor("gruppy-pol1zovatelej-browse.xml")
@LookupComponent("gruppyPol1zovatelejsTable")
public class GruppyPol1zovatelejBrowse extends StandardLookup<GruppyPol1zovatelej> {
}