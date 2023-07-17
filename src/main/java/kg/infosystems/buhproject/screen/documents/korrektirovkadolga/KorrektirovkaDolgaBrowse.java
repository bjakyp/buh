package kg.infosystems.buhproject.screen.documents.korrektirovkadolga;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.KorrektirovkaDolga;

@UiController("KorrektirovkaDolga.browse")
@UiDescriptor("korrektirovka-dolga-browse.xml")
@LookupComponent("korrektirovkaDolgasTable")
public class KorrektirovkaDolgaBrowse extends StandardLookup<KorrektirovkaDolga> {
}