package kg.infosystems.buhproject.screen.catalogs.klucevyeoperacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KlucevyeOperacii;

@UiController("KlucevyeOperacii.browse")
@UiDescriptor("klucevye-operacii-browse.xml")
@LookupComponent("klucevyeOperaciisTable")
public class KlucevyeOperaciiBrowse extends StandardLookup<KlucevyeOperacii> {
}