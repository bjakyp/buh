package kg.infosystems.buhproject.screen.documents.izmeneniestatusovidopolnitel1nyhvycetov;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.IzmenenieStatusovIDopolnitel1nyhVycetov;
import kg.infosystems.buhproject.entity.parts.documents.IzmenenieStatusovIDopolnitel1nyhVycetovSotrudniki;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("IzmenenieStatusovIDopolnitel1nyhVycetov.edit")
@UiDescriptor("izmenenie-statusov-i-dopolnitel1nyh-vycetov-edit.xml")
@EditedEntityContainer("izmenenieStatusovIDopolnitel1nyhVycetovDc")
public class IzmenenieStatusovIDopolnitel1nyhVycetovEdit extends StandardEditor<IzmenenieStatusovIDopolnitel1nyhVycetov> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<IzmenenieStatusovIDopolnitel1nyhVycetovSotrudniki> sotrudnikiDc;

    @Subscribe("sotrudnikiTable.create")
    public void onSotrudnikiTableCreate(Action.ActionPerformedEvent event) {
        IzmenenieStatusovIDopolnitel1nyhVycetovSotrudniki item = dataContext.create(IzmenenieStatusovIDopolnitel1nyhVycetovSotrudniki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(sotrudnikiDc.getDisconnectedItems().size()));
        sotrudnikiDc.getMutableItems().add(item);
    }
}