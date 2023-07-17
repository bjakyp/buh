package kg.infosystems.buhproject.screen.catalogs.azykinarodovmira;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.AzykiNarodovMira;

@UiController("AzykiNarodovMira.browse")
@UiDescriptor("azyki-narodov-mira-browse.xml")
@LookupComponent("azykiNarodovMirasTable")
public class AzykiNarodovMiraBrowse extends StandardLookup<AzykiNarodovMira> {
}