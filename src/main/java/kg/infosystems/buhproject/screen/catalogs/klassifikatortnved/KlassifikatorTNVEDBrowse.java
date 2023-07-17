package kg.infosystems.buhproject.screen.catalogs.klassifikatortnved;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KlassifikatorTNVED;

@UiController("KlassifikatorTNVED.browse")
@UiDescriptor("klassifikator-tnved-browse.xml")
@LookupComponent("klassifikatorTNVEDsTable")
public class KlassifikatorTNVEDBrowse extends StandardLookup<KlassifikatorTNVED> {
}