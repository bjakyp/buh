package kg.infosystems.buhproject.screen.documents.izmenenieparametrovosinma;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.IzmenenieParametrovOSINMA;
import kg.infosystems.buhproject.entity.parts.documents.IzmenenieParametrovOSINMAParametryOb2ekta;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("IzmenenieParametrovOSINMA.edit")
@UiDescriptor("izmenenie-parametrov-osinma-edit.xml")
@EditedEntityContainer("izmenenieParametrovOSINMADc")
public class IzmenenieParametrovOSINMAEdit extends StandardEditor<IzmenenieParametrovOSINMA> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<IzmenenieParametrovOSINMAParametryOb2ekta> parametryOb2ektaDc;

    @Subscribe("parametryOb2ektaTable.create")
    public void onParametryOb2ektaTableCreate(Action.ActionPerformedEvent event) {
        IzmenenieParametrovOSINMAParametryOb2ekta item = dataContext.create(IzmenenieParametrovOSINMAParametryOb2ekta.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(parametryOb2ektaDc.getDisconnectedItems().size()));
        parametryOb2ektaDc.getMutableItems().add(item);
    }
}