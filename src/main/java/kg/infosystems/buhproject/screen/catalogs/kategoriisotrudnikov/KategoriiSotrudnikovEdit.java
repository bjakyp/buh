package kg.infosystems.buhproject.screen.catalogs.kategoriisotrudnikov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.KategoriiSotrudnikov;

@UiController("KategoriiSotrudnikov.edit")
@UiDescriptor("kategorii-sotrudnikov-edit.xml")
@EditedEntityContainer("kategoriiSotrudnikovDc")
public class KategoriiSotrudnikovEdit extends StandardEditor<KategoriiSotrudnikov> {
}