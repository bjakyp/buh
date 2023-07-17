package kg.infosystems.buhproject.screen.catalogs.grafikiamortizacii;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.GrafikiAmortizacii;

@UiController("GrafikiAmortizacii.browse")
@UiDescriptor("grafiki-amortizacii-browse.xml")
@LookupComponent("grafikiAmortizaciisTable")
public class GrafikiAmortizaciiBrowse extends StandardLookup<GrafikiAmortizacii> {
}