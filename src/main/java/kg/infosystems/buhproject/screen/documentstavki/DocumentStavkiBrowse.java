package kg.infosystems.buhproject.screen.documentstavki;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.DocumentStavki;

@UiController("DocumentStavki.browse")
@UiDescriptor("document-stavki-browse.xml")
@LookupComponent("documentStavkisTable")
public class DocumentStavkiBrowse extends StandardLookup<DocumentStavki> {
}
