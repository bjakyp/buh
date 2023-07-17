package kg.infosystems.buhproject.screen.catalogs.sklady;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Sklady;

@UiController("Sklady.browse")
@UiDescriptor("sklady-browse.xml")
@LookupComponent("skladiesTable")
public class SkladyBrowse extends StandardLookup<Sklady> {
}