package kg.infosystems.buhproject.screen.documents.budzetnoeporucenie;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.BudzetnoePorucenie;
import kg.infosystems.buhproject.entity.parts.documents.BudzetnoePorucenieRassifrovkaPlateza;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("BudzetnoePorucenie.edit")
@UiDescriptor("budzetnoe-porucenie-edit.xml")
@EditedEntityContainer("budzetnoePorucenieDc")
public class BudzetnoePorucenieEdit extends StandardEditor<BudzetnoePorucenie> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<BudzetnoePorucenieRassifrovkaPlateza> rassifrovkaPlatezaDc;

    @Subscribe("table1.create")
    public void onTable1Create(Action.ActionPerformedEvent event) {
        BudzetnoePorucenieRassifrovkaPlateza item = dataContext.create(BudzetnoePorucenieRassifrovkaPlateza.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(rassifrovkaPlatezaDc.getDisconnectedItems().size()));
        rassifrovkaPlatezaDc.getMutableItems().add(item);
    }
}