package kg.infosystems.buhproject.screen.documents.izmenenieparametrovosinma;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.IzmenenieParametrovOSINMA;

@UiController("IzmenenieParametrovOSINMA.browse")
@UiDescriptor("izmenenie-parametrov-osinma-browse.xml")
@LookupComponent("izmenenieParametrovOSINMAsTable")
public class IzmenenieParametrovOSINMABrowse extends StandardLookup<IzmenenieParametrovOSINMA> {
}