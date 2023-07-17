package kg.infosystems.buhproject.screen.documents.aktsverkivzaimorascetov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.AktSverkiVzaimorascetov;
import kg.infosystems.buhproject.entity.parts.documents.AktSverkiVzaimorascetovPoDannymKontragenta;
import kg.infosystems.buhproject.entity.parts.documents.AktSverkiVzaimorascetovPoDannymOrganizacii;
import kg.infosystems.buhproject.entity.parts.documents.AktSverkiVzaimorascetovSpisokScetov;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("AktSverkiVzaimorascetov.edit")
@UiDescriptor("akt-sverki-vzaimorascetov-edit.xml")
@EditedEntityContainer("aktSverkiVzaimorascetovDc")
public class AktSverkiVzaimorascetovEdit extends StandardEditor<AktSverkiVzaimorascetov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<AktSverkiVzaimorascetovPoDannymOrganizacii> poDannymOrganizaciiDc;
    @Autowired
    private CollectionPropertyContainer<AktSverkiVzaimorascetovPoDannymKontragenta> poDannymKontragentaDc;
    @Autowired
    private CollectionPropertyContainer<AktSverkiVzaimorascetovSpisokScetov> spisokScetovDc;

    @Subscribe("poDannymOrganizaciiTable.create")
    public void onPoDannymOrganizaciiTableCreate(Action.ActionPerformedEvent event) {
        AktSverkiVzaimorascetovPoDannymOrganizacii item = dataContext.create(AktSverkiVzaimorascetovPoDannymOrganizacii.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(poDannymOrganizaciiDc.getDisconnectedItems().size()));
        poDannymOrganizaciiDc.getMutableItems().add(item);
    }

    @Subscribe("poDannymKontragentaTable.create")
    public void onPoDannymKontragentaTableCreate(Action.ActionPerformedEvent event) {
        AktSverkiVzaimorascetovPoDannymKontragenta item = dataContext.create(AktSverkiVzaimorascetovPoDannymKontragenta.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(poDannymKontragentaDc.getDisconnectedItems().size()));
        poDannymKontragentaDc.getMutableItems().add(item);
    }

    @Subscribe("spisokScetovTable.create")
    public void onSpisokScetovTableCreate(Action.ActionPerformedEvent event) {
        AktSverkiVzaimorascetovSpisokScetov item = dataContext.create(AktSverkiVzaimorascetovSpisokScetov.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(spisokScetovDc.getDisconnectedItems().size()));
        spisokScetovDc.getMutableItems().add(item);
    }
}