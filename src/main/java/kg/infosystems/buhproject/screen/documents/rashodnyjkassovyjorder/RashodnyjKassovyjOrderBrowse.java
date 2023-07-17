package kg.infosystems.buhproject.screen.documents.rashodnyjkassovyjorder;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RashodnyjKassovyjOrder;

@UiController("RashodnyjKassovyjOrder.browse")
@UiDescriptor("rashodnyj-kassovyj-order-browse.xml")
@LookupComponent("rashodnyjKassovyjOrdersTable")
public class RashodnyjKassovyjOrderBrowse extends StandardLookup<RashodnyjKassovyjOrder> {
}