package kg.infosystems.buhproject.screen.catalogs.podrazdeleniaorganizacij;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij;

@UiController("PodrazdeleniaOrganizacij.browse")
@UiDescriptor("podrazdelenia-organizacij-browse.xml")
@LookupComponent("podrazdeleniaOrganizacijsTable")
public class PodrazdeleniaOrganizacijBrowse extends StandardLookup<PodrazdeleniaOrganizacij> {
}