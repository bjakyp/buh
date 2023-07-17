package kg.infosystems.buhproject.screen.documents.prihodnyjkassovyjorder;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PrihodnyjKassovyjOrder;
import kg.infosystems.buhproject.entity.parts.documents.PrihodnyjKassovyjOrderRassifrovkaPlateza;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PrihodnyjKassovyjOrder.edit")
@UiDescriptor("prihodnyj-kassovyj-order-edit.xml")
@EditedEntityContainer("prihodnyjKassovyjOrderDc")
public class PrihodnyjKassovyjOrderEdit extends StandardEditor<PrihodnyjKassovyjOrder> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PrihodnyjKassovyjOrderRassifrovkaPlateza> rassifrovkaPlatezaDc;

    @Subscribe("rassifrovkaPlatezaTable.create")
    public void onRassifrovkaPlatezaTableCreate(Action.ActionPerformedEvent event) {
        PrihodnyjKassovyjOrderRassifrovkaPlateza item = dataContext.create(PrihodnyjKassovyjOrderRassifrovkaPlateza.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(rassifrovkaPlatezaDc.getDisconnectedItems().size()));
        rassifrovkaPlatezaDc.getMutableItems().add(item);
    }
}