package kg.infosystems.buhproject.screen.globals.bugdetinstitution;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.globals.BudgetInstitution;

@UiController("BugdetInstitution.browse")
@UiDescriptor("bugdet-institution-browse.xml")
@LookupComponent("bugdetInstitutionsTable")
public class BugdetInstitutionBrowse extends StandardLookup<BudgetInstitution> {
}
