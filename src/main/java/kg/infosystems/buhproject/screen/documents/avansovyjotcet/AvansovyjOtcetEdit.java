package kg.infosystems.buhproject.screen.documents.avansovyjotcet;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.AvansovyjOtcet;
import kg.infosystems.buhproject.entity.parts.documents.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("AvansovyjOtcet.edit")
@UiDescriptor("avansovyj-otcet-edit.xml")
@EditedEntityContainer("avansovyjOtcetDc")
public class AvansovyjOtcetEdit extends StandardEditor<AvansovyjOtcet> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<AvansovyjOtcetAvansyRassifrovka> avansyRassifrovkaDc;
    @Autowired
    private CollectionPropertyContainer<AvansovyjOtcetTovary> tovaryDc;
    @Autowired
    private CollectionPropertyContainer<AvansovyjOtcetOplata> oplataDc;
    @Autowired
    private CollectionPropertyContainer<AvansovyjOtcetProcee> proceeDc;
    @Autowired
    private CollectionPropertyContainer<AvansovyjOtcetVyplataZP> vyplataZPDc;
    @Autowired
    private CollectionPropertyContainer<AvansovyjOtcetOS> osDc;
    @Autowired
    private CollectionPropertyContainer<AvansovyjOtcetNMA> nmaDc;
    @Autowired
    private CollectionPropertyContainer<AvansovyjOtcetBibliotecnyeFondy> bibliotecnyeFondyDc;

    @Subscribe("avansyRassifrovkaTable.create")
    public void onAvansyRassifrovkaTableCreate(Action.ActionPerformedEvent event) {
        AvansovyjOtcetAvansyRassifrovka item = dataContext.create(AvansovyjOtcetAvansyRassifrovka.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(avansyRassifrovkaDc.getDisconnectedItems().size()));
        avansyRassifrovkaDc.getMutableItems().add(item);
    }

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        AvansovyjOtcetTovary item = dataContext.create(AvansovyjOtcetTovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }

    @Subscribe("oplataTable.create")
    public void onOplataTableCreate(Action.ActionPerformedEvent event) {
        AvansovyjOtcetOplata item = dataContext.create(AvansovyjOtcetOplata.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(oplataDc.getDisconnectedItems().size()));
        oplataDc.getMutableItems().add(item);
    }

    @Subscribe("proceeTable.create")
    public void onProceeTableCreate(Action.ActionPerformedEvent event) {
        AvansovyjOtcetProcee item = dataContext.create(AvansovyjOtcetProcee.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(proceeDc.getDisconnectedItems().size()));
        proceeDc.getMutableItems().add(item);
    }

    @Subscribe("vyplataZPTable.create")
    public void onVyplataZPTableCreate(Action.ActionPerformedEvent event) {
        AvansovyjOtcetVyplataZP item = dataContext.create(AvansovyjOtcetVyplataZP.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(vyplataZPDc.getDisconnectedItems().size()));
        vyplataZPDc.getMutableItems().add(item);
    }

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        AvansovyjOtcetOS item = dataContext.create(AvansovyjOtcetOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }

    @Subscribe("nmaTable.create")
    public void onNmaTableCreate(Action.ActionPerformedEvent event) {
        AvansovyjOtcetNMA item = dataContext.create(AvansovyjOtcetNMA.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nmaDc.getDisconnectedItems().size()));
        nmaDc.getMutableItems().add(item);
    }

    @Subscribe("bibliotecnyeFondyTable.create")
    public void onBibliotecnyeFondyTableCreate(Action.ActionPerformedEvent event) {
        AvansovyjOtcetBibliotecnyeFondy item = dataContext.create(AvansovyjOtcetBibliotecnyeFondy.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(bibliotecnyeFondyDc.getDisconnectedItems().size()));
        bibliotecnyeFondyDc.getMutableItems().add(item);
    }
}