package kg.infosystems.buhproject.screen.documents.spisanietovarov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.SpisanieTovarov;
import kg.infosystems.buhproject.entity.parts.documents.SpisanieTovarovKomissia;
import kg.infosystems.buhproject.entity.parts.documents.SpisanieTovarovTovary;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("SpisanieTovarov.edit")
@UiDescriptor("spisanie-tovarov-edit.xml")
@EditedEntityContainer("spisanieTovarovDc")
public class SpisanieTovarovEdit extends StandardEditor<SpisanieTovarov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<SpisanieTovarovTovary> tovaryDc;
    @Autowired
    private CollectionPropertyContainer<SpisanieTovarovKomissia> komissiaDc;

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        SpisanieTovarovTovary item = dataContext.create(SpisanieTovarovTovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        SpisanieTovarovKomissia item = dataContext.create(SpisanieTovarovKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}