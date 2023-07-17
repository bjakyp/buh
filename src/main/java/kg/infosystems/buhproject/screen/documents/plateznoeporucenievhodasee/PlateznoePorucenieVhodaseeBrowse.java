package kg.infosystems.buhproject.screen.documents.plateznoeporucenievhodasee;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PlateznoePorucenieVhodasee;

@UiController("PlateznoePorucenieVhodasee.browse")
@UiDescriptor("plateznoe-porucenie-vhodasee-browse.xml")
@LookupComponent("plateznoePorucenieVhodaseesTable")
public class PlateznoePorucenieVhodaseeBrowse extends StandardLookup<PlateznoePorucenieVhodasee> {
}