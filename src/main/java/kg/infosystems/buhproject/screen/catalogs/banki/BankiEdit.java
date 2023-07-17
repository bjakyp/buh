package kg.infosystems.buhproject.screen.catalogs.banki;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Banki;

@UiController("Banki.edit")
@UiDescriptor("banki-edit.xml")
@EditedEntityContainer("bankiDc")
public class BankiEdit extends StandardEditor<Banki> {
}