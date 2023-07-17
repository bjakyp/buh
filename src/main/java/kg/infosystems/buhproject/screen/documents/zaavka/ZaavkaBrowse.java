package kg.infosystems.buhproject.screen.documents.zaavka;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Zaavka;

@UiController("Zaavka.browse")
@UiDescriptor("zaavka-browse.xml")
@LookupComponent("zaavkasTable")
public class ZaavkaBrowse extends StandardLookup<Zaavka> {
}