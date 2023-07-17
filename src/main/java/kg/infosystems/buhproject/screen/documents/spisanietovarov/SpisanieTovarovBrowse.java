package kg.infosystems.buhproject.screen.documents.spisanietovarov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.SpisanieTovarov;

@UiController("SpisanieTovarov.browse")
@UiDescriptor("spisanie-tovarov-browse.xml")
@LookupComponent("spisanieTovarovsTable")
public class SpisanieTovarovBrowse extends StandardLookup<SpisanieTovarov> {
}