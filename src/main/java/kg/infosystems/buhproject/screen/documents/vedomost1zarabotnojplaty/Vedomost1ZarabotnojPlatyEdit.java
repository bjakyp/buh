package kg.infosystems.buhproject.screen.documents.vedomost1zarabotnojplaty;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Vedomost1ZarabotnojPlaty;
import kg.infosystems.buhproject.entity.parts.documents.Vedomost1ZarabotnojPlatyItogiPoStat1am;
import kg.infosystems.buhproject.entity.parts.documents.Vedomost1ZarabotnojPlatyItogiPoVidamFinansirovania;
import kg.infosystems.buhproject.entity.parts.documents.Vedomost1ZarabotnojPlatyRaspredelenie;
import kg.infosystems.buhproject.entity.parts.documents.Vedomost1ZarabotnojPlatyZarplata;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("Vedomost1ZarabotnojPlaty.edit")
@UiDescriptor("vedomost1-zarabotnoj-platy-edit.xml")
@EditedEntityContainer("vedomost1ZarabotnojPlatyDc")
public class Vedomost1ZarabotnojPlatyEdit extends StandardEditor<Vedomost1ZarabotnojPlaty> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<Vedomost1ZarabotnojPlatyZarplata> zarplataDc;
    @Autowired
    private CollectionPropertyContainer<Vedomost1ZarabotnojPlatyRaspredelenie> raspredelenieDc;
    @Autowired
    private CollectionPropertyContainer<Vedomost1ZarabotnojPlatyItogiPoStat1am> itogiPoStat1amDc;
    @Autowired
    private CollectionPropertyContainer<Vedomost1ZarabotnojPlatyItogiPoVidamFinansirovania> itogiPoVidamFinansirovaniaDc;

    @Subscribe("zarplataTable.create")
    public void onZarplataTableCreate(Action.ActionPerformedEvent event) {
        Vedomost1ZarabotnojPlatyZarplata item = dataContext.create(Vedomost1ZarabotnojPlatyZarplata.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(zarplataDc.getDisconnectedItems().size()));
        zarplataDc.getMutableItems().add(item);
    }

    @Subscribe("raspredelenieTable.create")
    public void onRaspredelenieTableCreate(Action.ActionPerformedEvent event) {
        Vedomost1ZarabotnojPlatyRaspredelenie item = dataContext.create(Vedomost1ZarabotnojPlatyRaspredelenie.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(raspredelenieDc.getDisconnectedItems().size()));
        raspredelenieDc.getMutableItems().add(item);
    }

    @Subscribe("itogiPoStat1amTable.create")
    public void onItogiPoStat1amTableCreate(Action.ActionPerformedEvent event) {
        Vedomost1ZarabotnojPlatyItogiPoStat1am item = dataContext.create(Vedomost1ZarabotnojPlatyItogiPoStat1am.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(itogiPoStat1amDc.getDisconnectedItems().size()));
        itogiPoStat1amDc.getMutableItems().add(item);
    }

    @Subscribe("itogiPoVidamFinansirovaniaTable.create")
    public void onItogiPoVidamFinansirovaniaTableCreate(Action.ActionPerformedEvent event) {
        Vedomost1ZarabotnojPlatyItogiPoVidamFinansirovania item = dataContext.create(Vedomost1ZarabotnojPlatyItogiPoVidamFinansirovania.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(itogiPoVidamFinansirovaniaDc.getDisconnectedItems().size()));
        itogiPoVidamFinansirovaniaDc.getMutableItems().add(item);
    }
}