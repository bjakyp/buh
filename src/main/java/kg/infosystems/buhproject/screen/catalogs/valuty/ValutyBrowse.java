package kg.infosystems.buhproject.screen.catalogs.valuty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Valuty;

@UiController("Valuty.browse")
@UiDescriptor("valuty-browse.xml")
@LookupComponent("valutiesTable")
public class ValutyBrowse extends StandardLookup<Valuty> {
}