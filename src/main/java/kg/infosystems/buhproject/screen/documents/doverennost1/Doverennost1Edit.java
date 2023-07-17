package kg.infosystems.buhproject.screen.documents.doverennost1;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Doverennost1;
import kg.infosystems.buhproject.entity.parts.documents.Doverennost1OS;
import kg.infosystems.buhproject.entity.parts.documents.Doverennost1Tovary;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("Doverennost1.edit")
@UiDescriptor("doverennost1-edit.xml")
@EditedEntityContainer("doverennost1Dc")
public class Doverennost1Edit extends StandardEditor<Doverennost1> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<Doverennost1Tovary> tovaryDc;
    @Autowired
    private CollectionPropertyContainer<Doverennost1OS> osDc;

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        Doverennost1Tovary item = dataContext.create(Doverennost1Tovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        Doverennost1OS item = dataContext.create(Doverennost1OS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }
}