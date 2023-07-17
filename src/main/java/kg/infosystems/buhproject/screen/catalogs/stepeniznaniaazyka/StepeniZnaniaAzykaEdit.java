package kg.infosystems.buhproject.screen.catalogs.stepeniznaniaazyka;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.StepeniZnaniaAzyka;

@UiController("StepeniZnaniaAzyka.edit")
@UiDescriptor("stepeni-znania-azyka-edit.xml")
@EditedEntityContainer("stepeniZnaniaAzykaDc")
public class StepeniZnaniaAzykaEdit extends StandardEditor<StepeniZnaniaAzyka> {
}