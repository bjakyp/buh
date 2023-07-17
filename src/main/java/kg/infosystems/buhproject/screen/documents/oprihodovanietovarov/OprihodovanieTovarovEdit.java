package kg.infosystems.buhproject.screen.documents.oprihodovanietovarov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.OprihodovanieTovarov;
import kg.infosystems.buhproject.entity.parts.documents.OprihodovanieTovarovTovary;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("OprihodovanieTovarov.edit")
@UiDescriptor("oprihodovanie-tovarov-edit.xml")
@EditedEntityContainer("oprihodovanieTovarovDc")
public class OprihodovanieTovarovEdit extends StandardEditor<OprihodovanieTovarov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<OprihodovanieTovarovTovary> tovaryDc;

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        OprihodovanieTovarovTovary item = dataContext.create(OprihodovanieTovarovTovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }
}