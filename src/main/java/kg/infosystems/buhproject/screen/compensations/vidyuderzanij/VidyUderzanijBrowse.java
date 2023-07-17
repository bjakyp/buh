package kg.infosystems.buhproject.screen.compensations.vidyuderzanij;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.compensations.VidyUderzanij;

@UiController("VidyUderzanij.browse")
@UiDescriptor("vidy-uderzanij-browse.xml")
@LookupComponent("vidyUderzanijsTable")
public class VidyUderzanijBrowse extends StandardLookup<VidyUderzanij> {
}