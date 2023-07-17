package kg.infosystems.buhproject.screen.documents.peremesenieosinma;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PeremesenieOSINMA;
import kg.infosystems.buhproject.entity.parts.documents.PeremesenieOSINMANMA;
import kg.infosystems.buhproject.entity.parts.documents.PeremesenieOSINMAOS;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PeremesenieOSINMA.edit")
@UiDescriptor("peremesenie-osinma-edit.xml")
@EditedEntityContainer("peremesenieOSINMADc")
public class PeremesenieOSINMAEdit extends StandardEditor<PeremesenieOSINMA> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PeremesenieOSINMAOS> osDc;
    @Autowired
    private CollectionPropertyContainer<PeremesenieOSINMANMA> nmaDc;

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        PeremesenieOSINMAOS item = dataContext.create(PeremesenieOSINMAOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }

    @Subscribe("nmaTable.create")
    public void onNmaTableCreate(Action.ActionPerformedEvent event) {
        PeremesenieOSINMANMA item = dataContext.create(PeremesenieOSINMANMA.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nmaDc.getDisconnectedItems().size()));
        nmaDc.getMutableItems().add(item);
    }
}