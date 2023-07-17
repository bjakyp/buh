package kg.infosystems.buhproject.screen.catalogs.sostavyvoennosluzasih;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.SostavyVoennosluzasih;

@UiController("SostavyVoennosluzasih.browse")
@UiDescriptor("sostavy-voennosluzasih-browse.xml")
@LookupComponent("sostavyVoennosluzasihsTable")
public class SostavyVoennosluzasihBrowse extends StandardLookup<SostavyVoennosluzasih> {
}