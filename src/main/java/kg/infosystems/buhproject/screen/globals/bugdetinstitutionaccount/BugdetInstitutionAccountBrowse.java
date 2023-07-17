package kg.infosystems.buhproject.screen.globals.bugdetinstitutionaccount;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.globals.BudgetInstitutionAccount;

@UiController("BugdetInstitutionAccount.browse")
@UiDescriptor("bugdet-institution-account-browse.xml")
@LookupComponent("bugdetInstitutionAccountsTable")
public class BugdetInstitutionAccountBrowse extends StandardLookup<BudgetInstitutionAccount> {
}
