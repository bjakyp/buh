package kg.infosystems.buhproject.screen.catalogs;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.RegistrDoljnosti;

@UiController("RegistrDoljnosti.browse")
@UiDescriptor("registr-doljnosti-browse.xml")
@LookupComponent("registrDoljnostisTable")
public class RegistrDoljnostiBrowse extends StandardLookup<RegistrDoljnosti> {
}
