package kg.infosystems.buhproject.screen.documents.planovoeuderzanie;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PlanovoeUderzanie;
import kg.infosystems.buhproject.entity.parts.documents.PlanovoeUderzanieSotrudniki;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PlanovoeUderzanie.edit")
@UiDescriptor("planovoe-uderzanie-edit.xml")
@EditedEntityContainer("planovoeUderzanieDc")
public class PlanovoeUderzanieEdit extends StandardEditor<PlanovoeUderzanie> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PlanovoeUderzanieSotrudniki> sotrudnikiDc;

    @Subscribe("sotrudnikiTable.create")
    public void onSotrudnikiTableCreate(Action.ActionPerformedEvent event) {
        PlanovoeUderzanieSotrudniki item = dataContext.create(PlanovoeUderzanieSotrudniki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(sotrudnikiDc.getDisconnectedItems().size()));
        sotrudnikiDc.getMutableItems().add(item);
    }
}