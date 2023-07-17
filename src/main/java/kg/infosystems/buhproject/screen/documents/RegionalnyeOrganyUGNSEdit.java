package kg.infosystems.buhproject.screen.documents;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import kg.infosystems.buhproject.entity.documents.RegionalnyeOrganyUGNS;

@UiController("RegionalnyeOrganyUGNS.edit")
@UiDescriptor("regionalnye-organy-ugns-edit.xml")
@EditedEntityContainer("regionalnyeOrganyUGNSDc")
public class RegionalnyeOrganyUGNSEdit extends StandardEditor<RegionalnyeOrganyUGNS> {
}
