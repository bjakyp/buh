package kg.infosystems.buhproject.screen.documents.nacisleniezarplaty;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.NacislenieZarplaty;

@UiController("NacislenieZarplaty.browse")
@UiDescriptor("nacislenie-zarplaty-browse.xml")
@LookupComponent("nacislenieZarplatiesTable")
public class NacislenieZarplatyBrowse extends StandardLookup<NacislenieZarplaty> {
}