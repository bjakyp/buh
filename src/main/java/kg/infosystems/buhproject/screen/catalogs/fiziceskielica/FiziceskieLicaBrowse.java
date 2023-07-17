package kg.infosystems.buhproject.screen.catalogs.fiziceskielica;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.FiziceskieLica;

@UiController("FiziceskieLica.browse")
@UiDescriptor("fiziceskie-lica-browse.xml")
@LookupComponent("fiziceskieLicasTable")
public class FiziceskieLicaBrowse extends StandardLookup<FiziceskieLica> {
}