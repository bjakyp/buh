package kg.infosystems.buhproject.screen.compensations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.compensations.VidyPosobiy;

@UiController("VidyPosobiy.browse")
@UiDescriptor("vidy-posobiy-browse.xml")
@LookupComponent("vidyPosobiysTable")
public class VidyPosobiyBrowse extends StandardLookup<VidyPosobiy> {
}
