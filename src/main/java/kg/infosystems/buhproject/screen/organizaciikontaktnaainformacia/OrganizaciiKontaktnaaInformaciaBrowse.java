package kg.infosystems.buhproject.screen.organizaciikontaktnaainformacia;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.parts.catalogs.OrganizaciiKontaktnaaInformacia;

@UiController("OrganizaciiKontaktnaaInformacia.browse")
@UiDescriptor("organizacii-kontaktnaa-informacia-browse.xml")
@LookupComponent("organizaciiKontaktnaaInformaciasTable")
public class OrganizaciiKontaktnaaInformaciaBrowse extends StandardLookup<OrganizaciiKontaktnaaInformacia> {
}
