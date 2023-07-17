package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.CvetaZametok;

@UiController("CvetaZametok.browse")
@UiDescriptor("CvetaZametok-browse.xml")
@LookupComponent("enumsTable")
public class CvetaZametokBrowse extends StandardLookup<CvetaZametok> {
}