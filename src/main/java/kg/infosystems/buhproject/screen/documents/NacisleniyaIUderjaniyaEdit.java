package kg.infosystems.buhproject.screen.documents;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.NacisleniyaIUderjaniya;
import kg.infosystems.buhproject.entity.parts.documents.NacisleniaNacisleniaIUderjania;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("NacisleniyaIUderjaniya.edit")
@UiDescriptor("nacisleniya-i-uderjaniya-edit.xml")
@EditedEntityContainer("nacisleniyaIUderjaniyaDc")
public class NacisleniyaIUderjaniyaEdit extends StandardEditor<NacisleniyaIUderjaniya> {

    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<NacisleniaNacisleniaIUderjania> nacisleniaDc;

    @Subscribe("nacisleniaTable.create")
    public void onNacisleniaTableCreate(Action.ActionPerformedEvent event) {
        NacisleniaNacisleniaIUderjania item = dataContext.create(NacisleniaNacisleniaIUderjania.class);
        item.setNacisleniaIUderjania(getEditedEntity());
        nacisleniaDc.getMutableItems().add(item);
    }

}
