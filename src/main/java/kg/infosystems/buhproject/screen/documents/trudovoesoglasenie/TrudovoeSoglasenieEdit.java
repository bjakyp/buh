package kg.infosystems.buhproject.screen.documents.trudovoesoglasenie;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.TrudovoeSoglasenie;

@UiController("TrudovoeSoglasenie.edit")
@UiDescriptor("trudovoe-soglasenie-edit.xml")
@EditedEntityContainer("trudovoeSoglasenieDc")
public class TrudovoeSoglasenieEdit extends StandardEditor<TrudovoeSoglasenie> {
}