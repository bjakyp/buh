package kg.infosystems.buhproject.screen.documents.inventarizaciambp;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.InventarizaciaMBP;
import kg.infosystems.buhproject.entity.parts.documents.InventarizaciaMBPKomissia;
import kg.infosystems.buhproject.entity.parts.documents.InventarizaciaMBPMBP;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("InventarizaciaMBP.edit")
@UiDescriptor("inventarizacia-mbp-edit.xml")
@EditedEntityContainer("inventarizaciaMBPDc")
public class InventarizaciaMBPEdit extends StandardEditor<InventarizaciaMBP> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<InventarizaciaMBPMBP> mbpDc;
    @Autowired
    private CollectionPropertyContainer<InventarizaciaMBPKomissia> komissiaDc;

    @Subscribe("mbpTable.create")
    public void onMbpTableCreate(Action.ActionPerformedEvent event) {
        InventarizaciaMBPMBP item = dataContext.create(InventarizaciaMBPMBP.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(mbpDc.getDisconnectedItems().size()));
        mbpDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        InventarizaciaMBPKomissia item = dataContext.create(InventarizaciaMBPKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}