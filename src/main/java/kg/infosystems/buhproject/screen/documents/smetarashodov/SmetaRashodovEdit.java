package kg.infosystems.buhproject.screen.documents.smetarashodov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.SmetaRashodov;
import kg.infosystems.buhproject.entity.parts.documents.SmetaRashodovDohody;
import kg.infosystems.buhproject.entity.parts.documents.SmetaRashodovElementyStatej;
import kg.infosystems.buhproject.entity.parts.documents.SmetaRashodovGruppyStatej;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("SmetaRashodov.edit")
@UiDescriptor("smeta-rashodov-edit.xml")
@EditedEntityContainer("smetaRashodovDc")
public class SmetaRashodovEdit extends StandardEditor<SmetaRashodov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<SmetaRashodovDohody> dohodyDc;
    @Autowired
    private CollectionPropertyContainer<SmetaRashodovGruppyStatej> gruppyStatejDc;
    @Autowired
    private CollectionPropertyContainer<SmetaRashodovElementyStatej> elementyStatejDc;

    @Subscribe("dohodyTable.create")
    public void onDohodyTableCreate(Action.ActionPerformedEvent event) {
        SmetaRashodovDohody item = dataContext.create(SmetaRashodovDohody.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(dohodyDc.getDisconnectedItems().size()));
        dohodyDc.getMutableItems().add(item);
    }

    @Subscribe("gruppyStatejTable.create")
    public void onGruppyStatejTableCreate(Action.ActionPerformedEvent event) {
        SmetaRashodovGruppyStatej item = dataContext.create(SmetaRashodovGruppyStatej.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(gruppyStatejDc.getDisconnectedItems().size()));
        gruppyStatejDc.getMutableItems().add(item);
    }

    @Subscribe("elementyStatejTable.create")
    public void onElementyStatejTableCreate(Action.ActionPerformedEvent event) {
        SmetaRashodovElementyStatej item = dataContext.create(SmetaRashodovElementyStatej.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(elementyStatejDc.getDisconnectedItems().size()));
        elementyStatejDc.getMutableItems().add(item);
    }
}