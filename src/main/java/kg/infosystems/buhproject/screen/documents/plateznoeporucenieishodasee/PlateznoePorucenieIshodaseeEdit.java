package kg.infosystems.buhproject.screen.documents.plateznoeporucenieishodasee;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PlateznoePorucenieIshodasee;
import kg.infosystems.buhproject.entity.parts.documents.PlateznoePorucenieIshodaseeRassifrovkaPlateza;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PlateznoePorucenieIshodasee.edit")
@UiDescriptor("plateznoe-porucenie-ishodasee-edit.xml")
@EditedEntityContainer("plateznoePorucenieIshodaseeDc")
public class PlateznoePorucenieIshodaseeEdit extends StandardEditor<PlateznoePorucenieIshodasee> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PlateznoePorucenieIshodaseeRassifrovkaPlateza> rassifrovkaPlatezaDc;

    @Subscribe("rassifrovkaPlatezaTable.create")
    public void onRassifrovkaPlatezaTableCreate(Action.ActionPerformedEvent event) {
        PlateznoePorucenieIshodaseeRassifrovkaPlateza item = dataContext.create(PlateznoePorucenieIshodaseeRassifrovkaPlateza.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(rassifrovkaPlatezaDc.getDisconnectedItems().size()));
        rassifrovkaPlatezaDc.getMutableItems().add(item);
    }
}