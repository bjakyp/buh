package kg.infosystems.buhproject.screen.documents.peremesenietovarov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PeremesenieTovarov;

@UiController("PeremesenieTovarov.browse")
@UiDescriptor("peremesenie-tovarov-browse.xml")
@LookupComponent("peremesenieTovarovsTable")
public class PeremesenieTovarovBrowse extends StandardLookup<PeremesenieTovarov> {
}