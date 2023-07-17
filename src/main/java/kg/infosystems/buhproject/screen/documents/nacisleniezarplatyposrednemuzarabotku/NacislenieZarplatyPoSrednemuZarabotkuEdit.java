package kg.infosystems.buhproject.screen.documents.nacisleniezarplatyposrednemuzarabotku;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.NacislenieZarplatyPoSrednemuZarabotku;
import kg.infosystems.buhproject.entity.parts.documents.NacislenieZarplatyPoSrednemuZarabotkuSrednijZarabotok;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("NacislenieZarplatyPoSrednemuZarabotku.edit")
@UiDescriptor("nacislenie-zarplaty-po-srednemu-zarabotku-edit.xml")
@EditedEntityContainer("nacislenieZarplatyPoSrednemuZarabotkuDc")
public class NacislenieZarplatyPoSrednemuZarabotkuEdit extends StandardEditor<NacislenieZarplatyPoSrednemuZarabotku> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<NacislenieZarplatyPoSrednemuZarabotkuSrednijZarabotok> srednijZarabotokDc;

    @Subscribe("srednijZarabotokTable.create")
    public void onSrednijZarabotokTableCreate(Action.ActionPerformedEvent event) {
        NacislenieZarplatyPoSrednemuZarabotkuSrednijZarabotok item = dataContext.create(NacislenieZarplatyPoSrednemuZarabotkuSrednijZarabotok.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(srednijZarabotokDc.getDisconnectedItems().size()));
        srednijZarabotokDc.getMutableItems().add(item);
    }
}