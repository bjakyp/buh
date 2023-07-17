package kg.infosystems.buhproject.screen.globals.budget;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.globals.Budget;

@UiController("Budget.browse")
@UiDescriptor("budget-browse.xml")
@LookupComponent("budgetsTable")
public class BudgetBrowse extends StandardLookup<Budget> {
}
