package kg.infosystems.buhproject.screen.documents.spisanieosinma;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.SpisanieOSINMA;
import kg.infosystems.buhproject.entity.parts.documents.SpisanieOSINMAKomissia;
import kg.infosystems.buhproject.entity.parts.documents.SpisanieOSINMANMA;
import kg.infosystems.buhproject.entity.parts.documents.SpisanieOSINMAOS;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("SpisanieOSINMA.edit")
@UiDescriptor("spisanie-osinma-edit.xml")
@EditedEntityContainer("spisanieOSINMADc")
public class SpisanieOSINMAEdit extends StandardEditor<SpisanieOSINMA> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<SpisanieOSINMAOS> osDc;
    @Autowired
    private CollectionPropertyContainer<SpisanieOSINMANMA> nmaDc;
    @Autowired
    private CollectionPropertyContainer<SpisanieOSINMAKomissia> komissiaDc;

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        SpisanieOSINMAOS item = dataContext.create(SpisanieOSINMAOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }

    @Subscribe("nmaTable.create")
    public void onNmaTableCreate(Action.ActionPerformedEvent event) {
        SpisanieOSINMANMA item = dataContext.create(SpisanieOSINMANMA.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nmaDc.getDisconnectedItems().size()));
        nmaDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        SpisanieOSINMAKomissia item = dataContext.create(SpisanieOSINMAKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}