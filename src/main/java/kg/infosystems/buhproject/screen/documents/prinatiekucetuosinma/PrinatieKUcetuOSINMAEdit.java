package kg.infosystems.buhproject.screen.documents.prinatiekucetuosinma;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PrinatieKUcetuOSINMA;
import kg.infosystems.buhproject.entity.parts.documents.PrinatieKUcetuOSINMAKomissia;
import kg.infosystems.buhproject.entity.parts.documents.PrinatieKUcetuOSINMANMA;
import kg.infosystems.buhproject.entity.parts.documents.PrinatieKUcetuOSINMAOS;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PrinatieKUcetuOSINMA.edit")
@UiDescriptor("prinatie-k-ucetu-osinma-edit.xml")
@EditedEntityContainer("prinatieKUcetuOSINMADc")
public class PrinatieKUcetuOSINMAEdit extends StandardEditor<PrinatieKUcetuOSINMA> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PrinatieKUcetuOSINMAOS> osDc;
    @Autowired
    private CollectionPropertyContainer<PrinatieKUcetuOSINMANMA> nmaDc;
    @Autowired
    private CollectionPropertyContainer<PrinatieKUcetuOSINMAKomissia> komissiaDc;

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        PrinatieKUcetuOSINMAOS item = dataContext.create(PrinatieKUcetuOSINMAOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }

    @Subscribe("nmaTable.create")
    public void onNmaTableCreate(Action.ActionPerformedEvent event) {
        PrinatieKUcetuOSINMANMA item = dataContext.create(PrinatieKUcetuOSINMANMA.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nmaDc.getDisconnectedItems().size()));
        nmaDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        PrinatieKUcetuOSINMAKomissia item = dataContext.create(PrinatieKUcetuOSINMAKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}