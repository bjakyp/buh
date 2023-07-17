package kg.infosystems.buhproject.screen.documents.plateznoeporucenieishodasee;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PlateznoePorucenieIshodasee;

@UiController("PlateznoePorucenieIshodasee.browse")
@UiDescriptor("plateznoe-porucenie-ishodasee-browse.xml")
@LookupComponent("plateznoePorucenieIshodaseesTable")
public class PlateznoePorucenieIshodaseeBrowse extends StandardLookup<PlateznoePorucenieIshodasee> {
}