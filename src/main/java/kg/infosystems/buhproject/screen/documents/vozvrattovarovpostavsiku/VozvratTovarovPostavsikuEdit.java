package kg.infosystems.buhproject.screen.documents.vozvrattovarovpostavsiku;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.VozvratTovarovPostavsiku;
import kg.infosystems.buhproject.entity.parts.documents.VozvratTovarovPostavsikuTovary;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("VozvratTovarovPostavsiku.edit")
@UiDescriptor("vozvrat-tovarov-postavsiku-edit.xml")
@EditedEntityContainer("vozvratTovarovPostavsikuDc")
public class VozvratTovarovPostavsikuEdit extends StandardEditor<VozvratTovarovPostavsiku> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<VozvratTovarovPostavsikuTovary> tovaryDc;

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        VozvratTovarovPostavsikuTovary item = dataContext.create(VozvratTovarovPostavsikuTovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }
}