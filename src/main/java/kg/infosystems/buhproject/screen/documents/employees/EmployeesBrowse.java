package kg.infosystems.buhproject.screen.documents.employees;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.parts.documents.Employees;

@UiController("Employees.browse")
@UiDescriptor("employees-browse.xml")
@LookupComponent("employeesesTable")
public class EmployeesBrowse extends StandardLookup<Employees> {
}
