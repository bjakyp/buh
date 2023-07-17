package kg.infosystems.buhproject.screen.documents.razovoeuderzanie;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RazovoeUderzanie;

@UiController("RazovoeUderzanie.browse")
@UiDescriptor("razovoe-uderzanie-browse.xml")
@LookupComponent("razovoeUderzaniesTable")
public class RazovoeUderzanieBrowse extends StandardLookup<RazovoeUderzanie> {
}