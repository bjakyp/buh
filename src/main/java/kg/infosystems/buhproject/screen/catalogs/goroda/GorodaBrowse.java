package kg.infosystems.buhproject.screen.catalogs.goroda;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Goroda;

@UiController("Goroda.browse")
@UiDescriptor("goroda-browse.xml")
@LookupComponent("gorodasTable")
public class GorodaBrowse extends StandardLookup<Goroda> {
}