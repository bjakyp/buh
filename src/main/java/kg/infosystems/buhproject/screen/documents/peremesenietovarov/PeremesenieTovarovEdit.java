package kg.infosystems.buhproject.screen.documents.peremesenietovarov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PeremesenieTovarov;
import kg.infosystems.buhproject.entity.parts.documents.PeremesenieTovarovTovary;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PeremesenieTovarov.edit")
@UiDescriptor("peremesenie-tovarov-edit.xml")
@EditedEntityContainer("peremesenieTovarovDc")
public class PeremesenieTovarovEdit extends StandardEditor<PeremesenieTovarov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PeremesenieTovarovTovary> tovaryDc;

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        PeremesenieTovarovTovary item = dataContext.create(PeremesenieTovarovTovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }
}