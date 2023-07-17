package kg.infosystems.buhproject.screen.documents.inventarizaciaos;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.InventarizaciaOS;
import kg.infosystems.buhproject.entity.parts.documents.InventarizaciaOSKomissia;
import kg.infosystems.buhproject.entity.parts.documents.InventarizaciaOSOS;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("InventarizaciaOS.edit")
@UiDescriptor("inventarizacia-os-edit.xml")
@EditedEntityContainer("inventarizaciaOSDc")
public class InventarizaciaOSEdit extends StandardEditor<InventarizaciaOS> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<InventarizaciaOSOS> osDc;
    @Autowired
    private CollectionPropertyContainer<InventarizaciaOSKomissia> komissiaDc;

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        InventarizaciaOSOS item = dataContext.create(InventarizaciaOSOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        InventarizaciaOSKomissia item = dataContext.create(InventarizaciaOSKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}