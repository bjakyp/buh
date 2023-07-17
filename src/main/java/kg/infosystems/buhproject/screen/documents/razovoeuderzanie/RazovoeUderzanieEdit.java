package kg.infosystems.buhproject.screen.documents.razovoeuderzanie;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RazovoeUderzanie;
import kg.infosystems.buhproject.entity.parts.documents.RazovoeUderzanieUderzania;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("RazovoeUderzanie.edit")
@UiDescriptor("razovoe-uderzanie-edit.xml")
@EditedEntityContainer("razovoeUderzanieDc")
public class RazovoeUderzanieEdit extends StandardEditor<RazovoeUderzanie> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<RazovoeUderzanieUderzania> uderzaniaDc;

    @Subscribe("uderzaniaTable.create")
    public void onUderzaniaTableCreate(Action.ActionPerformedEvent event) {
        RazovoeUderzanieUderzania item = dataContext.create(RazovoeUderzanieUderzania.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(uderzaniaDc.getDisconnectedItems().size()));
        uderzaniaDc.getMutableItems().add(item);
    }
}