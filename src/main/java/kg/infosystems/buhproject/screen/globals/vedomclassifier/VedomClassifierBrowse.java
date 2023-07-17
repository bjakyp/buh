package kg.infosystems.buhproject.screen.globals.vedomclassifier;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.globals.VedomClassifier;

@UiController("VedomClassifier.browse")
@UiDescriptor("vedom-classifier-browse.xml")
@LookupComponent("vedomClassifiersTable")
public class VedomClassifierBrowse extends StandardLookup<VedomClassifier> {
}
