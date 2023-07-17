package kg.infosystems.buhproject.screen.documents.centralizovannaaoplata;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.CentralizovannaaOplata;
import kg.infosystems.buhproject.entity.parts.documents.CentralizovannaaOplataOplata;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("CentralizovannaaOplata.edit")
@UiDescriptor("centralizovannaa-oplata-edit.xml")
@EditedEntityContainer("centralizovannaaOplataDc")
public class CentralizovannaaOplataEdit extends StandardEditor<CentralizovannaaOplata> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<CentralizovannaaOplataOplata> oplataDc;

    @Subscribe("oplataTable.create")
    public void onOplataTableCreate(Action.ActionPerformedEvent event) {
        CentralizovannaaOplataOplata item = dataContext.create(CentralizovannaaOplataOplata.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(oplataDc.getDisconnectedItems().size()));
        oplataDc.getMutableItems().add(item);
    }
}