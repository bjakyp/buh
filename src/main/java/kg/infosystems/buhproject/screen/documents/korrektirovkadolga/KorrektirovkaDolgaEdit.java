package kg.infosystems.buhproject.screen.documents.korrektirovkadolga;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.KorrektirovkaDolga;
import kg.infosystems.buhproject.entity.parts.documents.KorrektirovkaDolgaDebitorskaaZadolzennost1;
import kg.infosystems.buhproject.entity.parts.documents.KorrektirovkaDolgaKreditorskaaZadolzennost1;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("KorrektirovkaDolga.edit")
@UiDescriptor("korrektirovka-dolga-edit.xml")
@EditedEntityContainer("korrektirovkaDolgaDc")
public class KorrektirovkaDolgaEdit extends StandardEditor<KorrektirovkaDolga> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<KorrektirovkaDolgaDebitorskaaZadolzennost1> debitorskaaZadolzennost1Dc;
    @Autowired
    private CollectionPropertyContainer<KorrektirovkaDolgaKreditorskaaZadolzennost1> kreditorskaaZadolzennost1Dc;

    @Subscribe("debitorskaaZadolzennost1Table.create")
    public void onDebitorskaaZadolzennost1TableCreate(Action.ActionPerformedEvent event) {
        KorrektirovkaDolgaDebitorskaaZadolzennost1 item = dataContext.create(KorrektirovkaDolgaDebitorskaaZadolzennost1.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(debitorskaaZadolzennost1Dc.getDisconnectedItems().size()));
        debitorskaaZadolzennost1Dc.getMutableItems().add(item);
    }

    @Subscribe("kreditorskaaZadolzennost1Table.create")
    public void onKreditorskaaZadolzennost1TableCreate(Action.ActionPerformedEvent event) {
        KorrektirovkaDolgaKreditorskaaZadolzennost1 item = dataContext.create(KorrektirovkaDolgaKreditorskaaZadolzennost1.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(kreditorskaaZadolzennost1Dc.getDisconnectedItems().size()));
        kreditorskaaZadolzennost1Dc.getMutableItems().add(item);
    }
}