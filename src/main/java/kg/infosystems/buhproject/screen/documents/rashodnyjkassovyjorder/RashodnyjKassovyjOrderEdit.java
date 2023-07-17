package kg.infosystems.buhproject.screen.documents.rashodnyjkassovyjorder;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RashodnyjKassovyjOrder;
import kg.infosystems.buhproject.entity.parts.documents.RashodnyjKassovyjOrderRassifrovkaPlateza;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("RashodnyjKassovyjOrder.edit")
@UiDescriptor("rashodnyj-kassovyj-order-edit.xml")
@EditedEntityContainer("rashodnyjKassovyjOrderDc")
public class RashodnyjKassovyjOrderEdit extends StandardEditor<RashodnyjKassovyjOrder> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<RashodnyjKassovyjOrderRassifrovkaPlateza> rassifrovkaPlatezaDc;

    @Subscribe("rassifrovkaPlatezaTable.create")
    public void onRassifrovkaPlatezaTableCreate(Action.ActionPerformedEvent event) {
        RashodnyjKassovyjOrderRassifrovkaPlateza item = dataContext.create(RashodnyjKassovyjOrderRassifrovkaPlateza.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(rassifrovkaPlatezaDc.getDisconnectedItems().size()));
        rassifrovkaPlatezaDc.getMutableItems().add(item);
    }
}