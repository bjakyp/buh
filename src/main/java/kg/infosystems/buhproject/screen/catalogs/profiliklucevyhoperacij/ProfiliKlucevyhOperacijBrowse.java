package kg.infosystems.buhproject.screen.catalogs.profiliklucevyhoperacij;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.ProfiliKlucevyhOperacij;

@UiController("ProfiliKlucevyhOperacij.browse")
@UiDescriptor("profili-klucevyh-operacij-browse.xml")
@LookupComponent("profiliKlucevyhOperacijsTable")
public class ProfiliKlucevyhOperacijBrowse extends StandardLookup<ProfiliKlucevyhOperacij> {
}