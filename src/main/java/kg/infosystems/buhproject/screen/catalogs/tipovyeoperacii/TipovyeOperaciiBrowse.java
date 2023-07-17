package kg.infosystems.buhproject.screen.catalogs.tipovyeoperacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.TipovyeOperacii;

@UiController("TipovyeOperacii.browse")
@UiDescriptor("tipovye-operacii-browse.xml")
@LookupComponent("tipovyeOperaciisTable")
public class TipovyeOperaciiBrowse extends StandardLookup<TipovyeOperacii> {
}