package kg.infosystems.buhproject.screen.documents.zaavka;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Zaavka;
import kg.infosystems.buhproject.entity.parts.documents.ZaavkaRassifrovkaZaavki;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("Zaavka.edit")
@UiDescriptor("zaavka-edit.xml")
@EditedEntityContainer("zaavkaDc")
public class ZaavkaEdit extends StandardEditor<Zaavka> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<ZaavkaRassifrovkaZaavki> rassifrovkaZaavkiDc;

    @Subscribe("rassifrovkaZaavkiTable.create")
    public void onRassifrovkaZaavkiTableCreate(Action.ActionPerformedEvent event) {
        ZaavkaRassifrovkaZaavki item = dataContext.create(ZaavkaRassifrovkaZaavki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(rassifrovkaZaavkiDc.getDisconnectedItems().size()));
        rassifrovkaZaavkiDc.getMutableItems().add(item);
    }
}