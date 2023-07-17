package kg.infosystems.buhproject.screen.documents.avansovyjotcet;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.AvansovyjOtcet;

@UiController("AvansovyjOtcet.browse")
@UiDescriptor("avansovyj-otcet-browse.xml")
@LookupComponent("avansovyjOtcetsTable")
public class AvansovyjOtcetBrowse extends StandardLookup<AvansovyjOtcet> {
}