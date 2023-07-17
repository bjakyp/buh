package kg.infosystems.buhproject.screen.documents.plateznoeporucenievhodasee;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PlateznoePorucenieVhodasee;
import kg.infosystems.buhproject.entity.parts.documents.PlateznoePorucenieVhodaseeRassifrovkaPlateza;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PlateznoePorucenieVhodasee.edit")
@UiDescriptor("plateznoe-porucenie-vhodasee-edit.xml")
@EditedEntityContainer("plateznoePorucenieVhodaseeDc")
public class PlateznoePorucenieVhodaseeEdit extends StandardEditor<PlateznoePorucenieVhodasee> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PlateznoePorucenieVhodaseeRassifrovkaPlateza> rassifrovkaPlatezaDc;

    @Subscribe("rassifrovkaPlatezaTable.create")
    public void onRassifrovkaPlatezaTableCreate(Action.ActionPerformedEvent event) {
        PlateznoePorucenieVhodaseeRassifrovkaPlateza item = dataContext.create(PlateznoePorucenieVhodaseeRassifrovkaPlateza.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(rassifrovkaPlatezaDc.getDisconnectedItems().size()));
        rassifrovkaPlatezaDc.getMutableItems().add(item);
    }
}