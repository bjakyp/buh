package kg.infosystems.buhproject.screen.documents.dvizeniembp;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.DvizenieMBP;
import kg.infosystems.buhproject.entity.parts.documents.DvizenieMBPKomissia;
import kg.infosystems.buhproject.entity.parts.documents.DvizenieMBPMBP;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("DvizenieMBP.edit")
@UiDescriptor("dvizenie-mbp-edit.xml")
@EditedEntityContainer("dvizenieMBPDc")
public class DvizenieMBPEdit extends StandardEditor<DvizenieMBP> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<DvizenieMBPMBP> mbpDc;
    @Autowired
    private CollectionPropertyContainer<DvizenieMBPKomissia> komissiaDc;

    @Subscribe("mbpTable.create")
    public void onMbpTableCreate(Action.ActionPerformedEvent event) {
        DvizenieMBPMBP item = dataContext.create(DvizenieMBPMBP.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(mbpDc.getDisconnectedItems().size()));
        mbpDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        DvizenieMBPKomissia item = dataContext.create(DvizenieMBPKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}