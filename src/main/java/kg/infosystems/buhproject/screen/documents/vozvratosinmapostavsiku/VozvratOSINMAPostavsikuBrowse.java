package kg.infosystems.buhproject.screen.documents.vozvratosinmapostavsiku;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.VozvratOSINMAPostavsiku;

@UiController("VozvratOSINMAPostavsiku.browse")
@UiDescriptor("vozvrat-osinma-postavsiku-browse.xml")
@LookupComponent("vozvratOSINMAPostavsikusTable")
public class VozvratOSINMAPostavsikuBrowse extends StandardLookup<VozvratOSINMAPostavsiku> {
}