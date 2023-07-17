package kg.infosystems.buhproject.screen.documents.centralizovannaaoplata;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.CentralizovannaaOplata;

@UiController("CentralizovannaaOplata.browse")
@UiDescriptor("centralizovannaa-oplata-browse.xml")
@LookupComponent("centralizovannaaOplatasTable")
public class CentralizovannaaOplataBrowse extends StandardLookup<CentralizovannaaOplata> {
}