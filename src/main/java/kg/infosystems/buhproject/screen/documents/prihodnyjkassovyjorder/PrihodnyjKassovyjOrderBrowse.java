package kg.infosystems.buhproject.screen.documents.prihodnyjkassovyjorder;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.PrihodnyjKassovyjOrder;

@UiController("PrihodnyjKassovyjOrder.browse")
@UiDescriptor("prihodnyj-kassovyj-order-browse.xml")
@LookupComponent("prihodnyjKassovyjOrdersTable")
public class PrihodnyjKassovyjOrderBrowse extends StandardLookup<PrihodnyjKassovyjOrder> {
}