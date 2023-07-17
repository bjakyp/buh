package kg.infosystems.buhproject.screen.documents.dopolnitel1nyerashody;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Dopolnitel1nyeRashody;
import kg.infosystems.buhproject.entity.parts.documents.Dopolnitel1nyeRashodyOS;
import kg.infosystems.buhproject.entity.parts.documents.Dopolnitel1nyeRashodyTovary;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("Dopolnitel1nyeRashody.edit")
@UiDescriptor("dopolnitel1nye-rashody-edit.xml")
@EditedEntityContainer("dopolnitel1nyeRashodyDc")
public class Dopolnitel1nyeRashodyEdit extends StandardEditor<Dopolnitel1nyeRashody> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<Dopolnitel1nyeRashodyTovary> tovaryDc;
    @Autowired
    private CollectionPropertyContainer<Dopolnitel1nyeRashodyOS> osDc;

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        Dopolnitel1nyeRashodyTovary item = dataContext.create(Dopolnitel1nyeRashodyTovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        Dopolnitel1nyeRashodyOS item = dataContext.create(Dopolnitel1nyeRashodyOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }
}