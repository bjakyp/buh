package kg.infosystems.buhproject.screen.accounts.hozrascetnyj;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import kg.infosystems.buhproject.entity.accounts.Hozrascetnyj;

@UiController("Hozrascetnyj.edit")
@UiDescriptor("hozrascetnyj-edit.xml")
@EditedEntityContainer("hozrascetnyjDc")
public class HozrascetnyjEdit extends StandardEditor<Hozrascetnyj> {
}
