package kg.infosystems.buhproject.screen.catalogs.sostavyvoennosluzasih;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.SostavyVoennosluzasih;

@UiController("SostavyVoennosluzasih.edit")
@UiDescriptor("sostavy-voennosluzasih-edit.xml")
@EditedEntityContainer("sostavyVoennosluzasihDc")
public class SostavyVoennosluzasihEdit extends StandardEditor<SostavyVoennosluzasih> {
}