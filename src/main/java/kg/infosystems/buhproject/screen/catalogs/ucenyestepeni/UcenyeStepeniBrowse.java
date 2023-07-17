package kg.infosystems.buhproject.screen.catalogs.ucenyestepeni;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.UcenyeStepeni;

@UiController("UcenyeStepeni.browse")
@UiDescriptor("ucenye-stepeni-browse.xml")
@LookupComponent("ucenyeStepenisTable")
public class UcenyeStepeniBrowse extends StandardLookup<UcenyeStepeni> {
}