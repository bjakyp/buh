package kg.infosystems.buhproject.screen.catalogs.profiligruppdostupa;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.ProfiliGruppDostupa;

@UiController("ProfiliGruppDostupa.browse")
@UiDescriptor("profili-grupp-dostupa-browse.xml")
@LookupComponent("profiliGruppDostupasTable")
public class ProfiliGruppDostupaBrowse extends StandardLookup<ProfiliGruppDostupa> {
}