package kg.infosystems.buhproject.screen.documents.uderzaniezaperiod;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.UderzanieZaPeriod;
import kg.infosystems.buhproject.entity.parts.documents.UderzanieZaPeriodUderzania;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("UderzanieZaPeriod.edit")
@UiDescriptor("uderzanie-za-period-edit.xml")
@EditedEntityContainer("uderzanieZaPeriodDc")
public class UderzanieZaPeriodEdit extends StandardEditor<UderzanieZaPeriod> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<UderzanieZaPeriodUderzania> uderzaniaDc;

    @Subscribe("uderzaniaTable.create")
    public void onUderzaniaTableCreate(Action.ActionPerformedEvent event) {
        UderzanieZaPeriodUderzania item = dataContext.create(UderzanieZaPeriodUderzania.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(uderzaniaDc.getDisconnectedItems().size()));
        uderzaniaDc.getMutableItems().add(item);
    }
}