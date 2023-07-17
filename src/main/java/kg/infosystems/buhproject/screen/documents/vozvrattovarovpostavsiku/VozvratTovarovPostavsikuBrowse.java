package kg.infosystems.buhproject.screen.documents.vozvrattovarovpostavsiku;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.VozvratTovarovPostavsiku;

@UiController("VozvratTovarovPostavsiku.browse")
@UiDescriptor("vozvrat-tovarov-postavsiku-browse.xml")
@LookupComponent("vozvratTovarovPostavsikusTable")
public class VozvratTovarovPostavsikuBrowse extends StandardLookup<VozvratTovarovPostavsiku> {
}