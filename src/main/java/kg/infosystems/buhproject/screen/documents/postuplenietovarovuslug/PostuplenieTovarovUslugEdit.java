package kg.infosystems.buhproject.screen.documents.postuplenietovarovuslug;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PostuplenieTovarovUslug;
import kg.infosystems.buhproject.entity.parts.documents.PostuplenieTovarovUslugNMA;
import kg.infosystems.buhproject.entity.parts.documents.PostuplenieTovarovUslugOS;
import kg.infosystems.buhproject.entity.parts.documents.PostuplenieTovarovUslugTovary;
import kg.infosystems.buhproject.entity.parts.documents.PostuplenieTovarovUslugUslugi;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("PostuplenieTovarovUslug.edit")
@UiDescriptor("postuplenie-tovarov-uslug-edit.xml")
@EditedEntityContainer("postuplenieTovarovUslugDc")
public class PostuplenieTovarovUslugEdit extends StandardEditor<PostuplenieTovarovUslug> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<PostuplenieTovarovUslugTovary> tovaryDc;
    @Autowired
    private CollectionPropertyContainer<PostuplenieTovarovUslugUslugi> uslugiDc;
    @Autowired
    private CollectionPropertyContainer<PostuplenieTovarovUslugOS> osDc;
    @Autowired
    private CollectionPropertyContainer<PostuplenieTovarovUslugNMA> nmaDc;

    @Subscribe("tovaryTable.create")
    public void onTovaryTableCreate(Action.ActionPerformedEvent event) {
        PostuplenieTovarovUslugTovary item = dataContext.create(PostuplenieTovarovUslugTovary.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(tovaryDc.getDisconnectedItems().size()));
        tovaryDc.getMutableItems().add(item);
    }

    @Subscribe("uslugiTable.create")
    public void onUslugiTableCreate(Action.ActionPerformedEvent event) {
        PostuplenieTovarovUslugUslugi item = dataContext.create(PostuplenieTovarovUslugUslugi.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(uslugiDc.getDisconnectedItems().size()));
        uslugiDc.getMutableItems().add(item);
    }

    @Subscribe("osTable.create")
    public void onOsTableCreate(Action.ActionPerformedEvent event) {
        PostuplenieTovarovUslugOS item = dataContext.create(PostuplenieTovarovUslugOS.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(osDc.getDisconnectedItems().size()));
        osDc.getMutableItems().add(item);
    }

    @Subscribe("nmaTable.create")
    public void onNmaTableCreate(Action.ActionPerformedEvent event) {
        PostuplenieTovarovUslugNMA item = dataContext.create(PostuplenieTovarovUslugNMA.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nmaDc.getDisconnectedItems().size()));
        nmaDc.getMutableItems().add(item);
    }
}