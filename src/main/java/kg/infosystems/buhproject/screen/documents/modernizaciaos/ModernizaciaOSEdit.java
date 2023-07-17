package kg.infosystems.buhproject.screen.documents.modernizaciaos;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.ModernizaciaOS;
import kg.infosystems.buhproject.entity.parts.documents.ModernizaciaOSParametryOb2ekta;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("ModernizaciaOS.edit")
@UiDescriptor("modernizacia-os-edit.xml")
@EditedEntityContainer("modernizaciaOSDc")
public class ModernizaciaOSEdit extends StandardEditor<ModernizaciaOS> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<ModernizaciaOSParametryOb2ekta> parametryOb2ektaDc;

    @Subscribe("parametryOb2ektaTable.create")
    public void onParametryOb2ektaTableCreate(Action.ActionPerformedEvent event) {
        ModernizaciaOSParametryOb2ekta item = dataContext.create(ModernizaciaOSParametryOb2ekta.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(parametryOb2ektaDc.getDisconnectedItems().size()));
        parametryOb2ektaDc.getMutableItems().add(item);
    }
}