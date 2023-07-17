package kg.infosystems.buhproject.screen.catalogs.sobytiastovarami;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.SobytiaSTovarami;

@UiController("SobytiaSTovarami.edit")
@UiDescriptor("sobytia-s-tovarami-edit.xml")
@EditedEntityContainer("sobytiaSTovaramiDc")
public class SobytiaSTovaramiEdit extends StandardEditor<SobytiaSTovarami> {
}