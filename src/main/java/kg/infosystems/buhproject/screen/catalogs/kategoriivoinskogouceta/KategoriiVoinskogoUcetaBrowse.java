package kg.infosystems.buhproject.screen.catalogs.kategoriivoinskogouceta;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KategoriiVoinskogoUceta;

@UiController("KategoriiVoinskogoUceta.browse")
@UiDescriptor("kategorii-voinskogo-uceta-browse.xml")
@LookupComponent("kategoriiVoinskogoUcetasTable")
public class KategoriiVoinskogoUcetaBrowse extends StandardLookup<KategoriiVoinskogoUceta> {
}