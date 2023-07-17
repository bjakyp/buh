package kg.infosystems.buhproject.screen.documents.peredacaosinma;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PeredacaOSINMA;
import kg.infosystems.buhproject.entity.parts.documents.PeredacaOSINMAKomissia;
import kg.infosystems.buhproject.entity.parts.documents.PeredacaOSINMANMA;
import kg.infosystems.buhproject.entity.parts.documents.PeredacaOSINMAOS;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PeredacaOSINMA.edit")
@UiDescriptor("peredaca-osinma-edit.xml")
@EditedEntityContainer("peredacaOSINMADc")
public class PeredacaOSINMAEdit extends StandardEditor<PeredacaOSINMA> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PeredacaOSINMAOS> osDc;
    @Autowired
    private CollectionPropertyContainer<PeredacaOSINMANMA> nmaDc;
    @Autowired
    private CollectionPropertyContainer<PeredacaOSINMAKomissia> komissiaDc;

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        PeredacaOSINMAOS item = dataContext.create(PeredacaOSINMAOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }

    @Subscribe("nmaTable.create")
    public void onNmaTableCreate(Action.ActionPerformedEvent event) {
        PeredacaOSINMANMA item = dataContext.create(PeredacaOSINMANMA.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nmaDc.getDisconnectedItems().size()));
        nmaDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        PeredacaOSINMAKomissia item = dataContext.create(PeredacaOSINMAKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}