package kg.infosystems.buhproject.screen.catalogs.banki;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Banki;

@UiController("Banki.browse")
@UiDescriptor("banki-browse.xml")
@LookupComponent("bankisTable")
public class BankiBrowse extends StandardLookup<Banki> {
}