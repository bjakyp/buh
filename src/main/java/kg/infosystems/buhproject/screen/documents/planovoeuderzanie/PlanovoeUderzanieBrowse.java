package kg.infosystems.buhproject.screen.documents.planovoeuderzanie;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PlanovoeUderzanie;

@UiController("PlanovoeUderzanie.browse")
@UiDescriptor("planovoe-uderzanie-browse.xml")
@LookupComponent("planovoeUderzaniesTable")
public class PlanovoeUderzanieBrowse extends StandardLookup<PlanovoeUderzanie> {
}