package kg.infosystems.buhproject.screen.catalogs.stepeniznaniaazyka;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.StepeniZnaniaAzyka;

@UiController("StepeniZnaniaAzyka.browse")
@UiDescriptor("stepeni-znania-azyka-browse.xml")
@LookupComponent("stepeniZnaniaAzykasTable")
public class StepeniZnaniaAzykaBrowse extends StandardLookup<StepeniZnaniaAzyka> {
}