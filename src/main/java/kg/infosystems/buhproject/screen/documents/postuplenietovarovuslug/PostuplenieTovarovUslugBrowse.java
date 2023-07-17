package kg.infosystems.buhproject.screen.documents.postuplenietovarovuslug;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PostuplenieTovarovUslug;

@UiController("PostuplenieTovarovUslug.browse")
@UiDescriptor("postuplenie-tovarov-uslug-browse.xml")
@LookupComponent("postuplenieTovarovUslugsTable")
public class PostuplenieTovarovUslugBrowse extends StandardLookup<PostuplenieTovarovUslug> {
}