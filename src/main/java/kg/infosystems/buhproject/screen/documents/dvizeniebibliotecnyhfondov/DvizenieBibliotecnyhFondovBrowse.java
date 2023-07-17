package kg.infosystems.buhproject.screen.documents.dvizeniebibliotecnyhfondov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.DvizenieBibliotecnyhFondov;

@UiController("DvizenieBibliotecnyhFondov.browse")
@UiDescriptor("dvizenie-bibliotecnyh-fondov-browse.xml")
@LookupComponent("dvizenieBibliotecnyhFondovsTable")
public class DvizenieBibliotecnyhFondovBrowse extends StandardLookup<DvizenieBibliotecnyhFondov> {
}