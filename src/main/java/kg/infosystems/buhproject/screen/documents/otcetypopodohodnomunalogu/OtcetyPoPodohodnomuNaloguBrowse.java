package kg.infosystems.buhproject.screen.documents.otcetypopodohodnomunalogu;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.OtcetyPoPodohodnomuNalogu;

@UiController("OtcetyPoPodohodnomuNalogu.browse")
@UiDescriptor("otcety-po-podohodnomu-nalogu-browse.xml")
@LookupComponent("otcetyPoPodohodnomuNalogusTable")
public class OtcetyPoPodohodnomuNaloguBrowse extends StandardLookup<OtcetyPoPodohodnomuNalogu> {
}