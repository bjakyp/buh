package kg.infosystems.buhproject.screen.compensations.vidynacislenij;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;

@UiController("VidyNacislenij.browse")
@UiDescriptor("vidy-nacislenij-browse.xml")
@LookupComponent("vidyNacislenijsTable")
public class VidyNacislenijBrowse extends StandardLookup<VidyNacislenij> {
}