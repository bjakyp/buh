package kg.infosystems.buhproject.screen.documents.uderzaniezaperiod;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.UderzanieZaPeriod;

@UiController("UderzanieZaPeriod.browse")
@UiDescriptor("uderzanie-za-period-browse.xml")
@LookupComponent("uderzanieZaPeriodsTable")
public class UderzanieZaPeriodBrowse extends StandardLookup<UderzanieZaPeriod> {
}