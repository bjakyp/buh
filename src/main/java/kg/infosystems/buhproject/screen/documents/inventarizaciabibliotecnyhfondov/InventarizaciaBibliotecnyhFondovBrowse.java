package kg.infosystems.buhproject.screen.documents.inventarizaciabibliotecnyhfondov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.InventarizaciaBibliotecnyhFondov;

@UiController("InventarizaciaBibliotecnyhFondov.browse")
@UiDescriptor("inventarizacia-bibliotecnyh-fondov-browse.xml")
@LookupComponent("inventarizaciaBibliotecnyhFondovsTable")
public class InventarizaciaBibliotecnyhFondovBrowse extends StandardLookup<InventarizaciaBibliotecnyhFondov> {
}