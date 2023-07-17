package kg.infosystems.buhproject.screen.catalogs.pravilauvazki;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.PravilaUvazki;

@UiController("PravilaUvazki.edit")
@UiDescriptor("pravila-uvazki-edit.xml")
@EditedEntityContainer("pravilaUvazkiDc")
public class PravilaUvazkiEdit extends StandardEditor<PravilaUvazki> {
}