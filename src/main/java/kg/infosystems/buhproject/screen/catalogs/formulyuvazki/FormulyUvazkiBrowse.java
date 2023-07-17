package kg.infosystems.buhproject.screen.catalogs.formulyuvazki;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.FormulyUvazki;

@UiController("FormulyUvazki.browse")
@UiDescriptor("formuly-uvazki-browse.xml")
@LookupComponent("formulyUvazkisTable")
public class FormulyUvazkiBrowse extends StandardLookup<FormulyUvazki> {
}