package kg.infosystems.buhproject.screen.documents.dvizeniembp;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.DvizenieMBP;

@UiController("DvizenieMBP.browse")
@UiDescriptor("dvizenie-mbp-browse.xml")
@LookupComponent("dvizenieMBPsTable")
public class DvizenieMBPBrowse extends StandardLookup<DvizenieMBP> {
}