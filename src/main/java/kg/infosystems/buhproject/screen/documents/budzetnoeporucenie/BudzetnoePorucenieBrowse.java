package kg.infosystems.buhproject.screen.documents.budzetnoeporucenie;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.BudzetnoePorucenie;

@UiController("BudzetnoePorucenie.browse")
@UiDescriptor("budzetnoe-porucenie-browse.xml")
@LookupComponent("budzetnoePoruceniesTable")
public class BudzetnoePorucenieBrowse extends StandardLookup<BudzetnoePorucenie> {
}