package kg.infosystems.buhproject.screen.documents.profvznosy;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Profvznosy;
import kg.infosystems.buhproject.entity.parts.documents.ProfvznosySotrudniki;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("Profvznosy.edit")
@UiDescriptor("profvznosy-edit.xml")
@EditedEntityContainer("profvznosyDc")
public class ProfvznosyEdit extends StandardEditor<Profvznosy> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<ProfvznosySotrudniki> sotrudnikiDc;

    @Subscribe("sotrudnikiTable.create")
    public void onSotrudnikiTableCreate(Action.ActionPerformedEvent event) {
        ProfvznosySotrudniki item = dataContext.create(ProfvznosySotrudniki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(sotrudnikiDc.getDisconnectedItems().size()));
        sotrudnikiDc.getMutableItems().add(item);
    }
}