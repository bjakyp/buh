package kg.infosystems.buhproject.screen.catalogs.pravilauvazki;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.PravilaUvazki;

@UiController("PravilaUvazki.browse")
@UiDescriptor("pravila-uvazki-browse.xml")
@LookupComponent("pravilaUvazkisTable")
public class PravilaUvazkiBrowse extends StandardLookup<PravilaUvazki> {
}