package kg.infosystems.buhproject.screen.catalogs.klassifikatoredinicizmerenia;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KlassifikatorEdinicIzmerenia;

@UiController("KlassifikatorEdinicIzmerenia.browse")
@UiDescriptor("klassifikator-edinic-izmerenia-browse.xml")
@LookupComponent("klassifikatorEdinicIzmereniasTable")
public class KlassifikatorEdinicIzmereniaBrowse extends StandardLookup<KlassifikatorEdinicIzmerenia> {
}