package kg.infosystems.buhproject.screen.catalogs.gruppydostupa;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.GruppyDostupa;

@UiController("GruppyDostupa.browse")
@UiDescriptor("gruppy-dostupa-browse.xml")
@LookupComponent("gruppyDostupasTable")
public class GruppyDostupaBrowse extends StandardLookup<GruppyDostupa> {
}