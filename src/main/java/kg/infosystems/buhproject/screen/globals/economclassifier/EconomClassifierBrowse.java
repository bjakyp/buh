package kg.infosystems.buhproject.screen.globals.economclassifier;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import kg.infosystems.buhproject.entity.globals.EconomClassifier;

@UiController("EconomClassifier.browse")
@UiDescriptor("econom-classifier-browse.xml")
@LookupComponent("economClassifiersTable")
public class EconomClassifierBrowse extends StandardLookup<EconomClassifier> {
}
