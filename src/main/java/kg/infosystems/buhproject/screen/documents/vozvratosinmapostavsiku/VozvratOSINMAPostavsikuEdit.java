package kg.infosystems.buhproject.screen.documents.vozvratosinmapostavsiku;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.VozvratOSINMAPostavsiku;
import kg.infosystems.buhproject.entity.parts.documents.VozvratOSINMAPostavsikuNMA;
import kg.infosystems.buhproject.entity.parts.documents.VozvratOSINMAPostavsikuOS;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("VozvratOSINMAPostavsiku.edit")
@UiDescriptor("vozvrat-osinma-postavsiku-edit.xml")
@EditedEntityContainer("vozvratOSINMAPostavsikuDc")
public class VozvratOSINMAPostavsikuEdit extends StandardEditor<VozvratOSINMAPostavsiku> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<VozvratOSINMAPostavsikuOS> osDc;
    @Autowired
    private CollectionPropertyContainer<VozvratOSINMAPostavsikuNMA> nmaDc;

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        VozvratOSINMAPostavsikuOS item = dataContext.create(VozvratOSINMAPostavsikuOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }

    @Subscribe("nmaTable.create")
    public void onNmaTableCreate(Action.ActionPerformedEvent event) {
        VozvratOSINMAPostavsikuNMA item = dataContext.create(VozvratOSINMAPostavsikuNMA.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nmaDc.getDisconnectedItems().size()));
        nmaDc.getMutableItems().add(item);
    }
}