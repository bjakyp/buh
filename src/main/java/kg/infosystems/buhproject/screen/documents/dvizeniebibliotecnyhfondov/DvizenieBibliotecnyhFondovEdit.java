package kg.infosystems.buhproject.screen.documents.dvizeniebibliotecnyhfondov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.DvizenieBibliotecnyhFondov;
import kg.infosystems.buhproject.entity.parts.documents.DvizenieBibliotecnyhFondovBibliotecnyeFondy;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("DvizenieBibliotecnyhFondov.edit")
@UiDescriptor("dvizenie-bibliotecnyh-fondov-edit.xml")
@EditedEntityContainer("dvizenieBibliotecnyhFondovDc")
public class DvizenieBibliotecnyhFondovEdit extends StandardEditor<DvizenieBibliotecnyhFondov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<DvizenieBibliotecnyhFondovBibliotecnyeFondy> bibliotecnyeFondyDc;

    @Subscribe("bibliotecnyeFondyTable.create")
    public void onBibliotecnyeFondyTableCreate(Action.ActionPerformedEvent event) {
        DvizenieBibliotecnyhFondovBibliotecnyeFondy item = dataContext.create(DvizenieBibliotecnyhFondovBibliotecnyeFondy.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(bibliotecnyeFondyDc.getDisconnectedItems().size()));
        bibliotecnyeFondyDc.getMutableItems().add(item);
    }
}