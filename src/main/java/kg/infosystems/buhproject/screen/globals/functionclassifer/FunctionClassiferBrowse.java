package kg.infosystems.buhproject.screen.globals.functionclassifer;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.globals.FunctionClassifer;

@UiController("FunctionClassifer.browse")
@UiDescriptor("function-classifer-browse.xml")
@LookupComponent("functionClassifersTable")
public class FunctionClassiferBrowse extends StandardLookup<FunctionClassifer> {
}
