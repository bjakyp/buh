package kg.infosystems.buhproject.screen.catalogs.podrazdeleniaorganizacij;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij;

@UiController("PodrazdeleniaOrganizacij.edit")
@UiDescriptor("podrazdelenia-organizacij-edit.xml")
@EditedEntityContainer("podrazdeleniaOrganizacijDc")
public class PodrazdeleniaOrganizacijEdit extends StandardEditor<PodrazdeleniaOrganizacij> {
}