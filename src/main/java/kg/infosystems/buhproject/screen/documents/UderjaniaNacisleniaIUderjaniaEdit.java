package kg.infosystems.buhproject.screen.documents;

import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.parts.documents.UderjaniaNacisleniaIUderjania;

import javax.inject.Inject;

@UiController("UderjaniaNacisleniaIUderjania.edit")
@UiDescriptor("uderjania-nacislenia-i-uderjania-edit.xml")
@EditedEntityContainer("uderjaniaNacisleniaIUderjaniaDc")
public class UderjaniaNacisleniaIUderjaniaEdit extends StandardEditor<UderjaniaNacisleniaIUderjania> {
    @Inject
    private TextField<String> FIOField;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        FIOField.setValue(getEditedEntity().getNacisleniyaIUderjaniya().getSotrudnik().getFizLico().getFirsName() +
            " " + getEditedEntity().getNacisleniyaIUderjaniya().getSotrudnik().getFizLico().getName().charAt(0) +
            ". " + getEditedEntity().getNacisleniyaIUderjaniya().getSotrudnik().getFizLico().getLastName().charAt(0) + ".");
    }

}
