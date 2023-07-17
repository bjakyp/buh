package kg.infosystems.buhproject.screen.documents.modernizaciaos;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.ModernizaciaOS;

@UiController("ModernizaciaOS.browse")
@UiDescriptor("modernizacia-os-browse.xml")
@LookupComponent("modernizaciaOsesTable")
public class ModernizaciaOSBrowse extends StandardLookup<ModernizaciaOS> {
}