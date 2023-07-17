package kg.infosystems.buhproject.screen.documents.inventarizaciatovarov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.InventarizaciaTovarov;
import kg.infosystems.buhproject.entity.parts.documents.InventarizaciaTovarovKomissia;
import kg.infosystems.buhproject.entity.parts.documents.InventarizaciaTovarovTovary;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("InventarizaciaTovarov.edit")
@UiDescriptor("inventarizacia-tovarov-edit.xml")
@EditedEntityContainer("inventarizaciaTovarovDc")
public class InventarizaciaTovarovEdit extends StandardEditor<InventarizaciaTovarov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<InventarizaciaTovarovTovary> tovaryDc;
    @Autowired
    private CollectionPropertyContainer<InventarizaciaTovarovKomissia> komissiaDc;

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        InventarizaciaTovarovTovary item = dataContext.create(InventarizaciaTovarovTovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        InventarizaciaTovarovKomissia item = dataContext.create(InventarizaciaTovarovKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}