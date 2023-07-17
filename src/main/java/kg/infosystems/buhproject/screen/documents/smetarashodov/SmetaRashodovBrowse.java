package kg.infosystems.buhproject.screen.documents.smetarashodov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.SmetaRashodov;

@UiController("SmetaRashodov.browse")
@UiDescriptor("smeta-rashodov-browse.xml")
@LookupComponent("smetaRashodovsTable")
public class SmetaRashodovBrowse extends StandardLookup<SmetaRashodov> {
}