package kg.infosystems.buhproject.screen.globals.accounttype;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.globals.AccountType;

@UiController("AccountType.browse")
@UiDescriptor("account-type-browse.xml")
@LookupComponent("accountTypesTable")
public class AccountTypeBrowse extends StandardLookup<AccountType> {
}
