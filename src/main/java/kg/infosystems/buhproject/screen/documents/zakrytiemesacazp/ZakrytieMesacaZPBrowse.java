package kg.infosystems.buhproject.screen.documents.zakrytiemesacazp;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.ZakrytieMesacaZP;

@UiController("ZakrytieMesacaZP.browse")
@UiDescriptor("zakrytie-mesaca-zp-browse.xml")
@LookupComponent("zakrytieMesacaZPsTable")
public class ZakrytieMesacaZPBrowse extends StandardLookup<ZakrytieMesacaZP> {
}