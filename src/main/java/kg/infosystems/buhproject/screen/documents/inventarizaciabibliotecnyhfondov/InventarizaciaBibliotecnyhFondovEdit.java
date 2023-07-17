package kg.infosystems.buhproject.screen.documents.inventarizaciabibliotecnyhfondov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.InventarizaciaBibliotecnyhFondov;
import kg.infosystems.buhproject.entity.parts.documents.InventarizaciaBibliotecnyhFondovBibliotecnyeFondy;
import kg.infosystems.buhproject.entity.parts.documents.InventarizaciaBibliotecnyhFondovKomissia;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("InventarizaciaBibliotecnyhFondov.edit")
@UiDescriptor("inventarizacia-bibliotecnyh-fondov-edit.xml")
@EditedEntityContainer("inventarizaciaBibliotecnyhFondovDc")
public class InventarizaciaBibliotecnyhFondovEdit extends StandardEditor<InventarizaciaBibliotecnyhFondov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<InventarizaciaBibliotecnyhFondovBibliotecnyeFondy> bibliotecnyeFondyDc;
    @Autowired
    private CollectionPropertyContainer<InventarizaciaBibliotecnyhFondovKomissia> komissiaDc;

    @Subscribe("bibliotecnyeFondyTable.create")
    public void onBibliotecnyeFondyTableCreate(Action.ActionPerformedEvent event) {
        InventarizaciaBibliotecnyhFondovBibliotecnyeFondy item = dataContext.create(InventarizaciaBibliotecnyhFondovBibliotecnyeFondy.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(bibliotecnyeFondyDc.getDisconnectedItems().size()));
        bibliotecnyeFondyDc.getMutableItems().add(item);
    }

    @Subscribe("komissiaTable.create")
    public void onKomissiaTableCreate(Action.ActionPerformedEvent event) {
        InventarizaciaBibliotecnyhFondovKomissia item = dataContext.create(InventarizaciaBibliotecnyhFondovKomissia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(komissiaDc.getDisconnectedItems().size()));
        komissiaDc.getMutableItems().add(item);
    }
}