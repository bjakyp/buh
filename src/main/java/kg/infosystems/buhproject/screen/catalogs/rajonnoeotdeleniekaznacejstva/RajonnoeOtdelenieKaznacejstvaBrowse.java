package kg.infosystems.buhproject.screen.catalogs.rajonnoeotdeleniekaznacejstva;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.RajonnoeOtdelenieKaznacejstva;

@UiController("RajonnoeOtdelenieKaznacejstva.browse")
@UiDescriptor("rajonnoe-otdelenie-kaznacejstva-browse.xml")
@LookupComponent("rajonnoeOtdelenieKaznacejstvasTable")
public class RajonnoeOtdelenieKaznacejstvaBrowse extends StandardLookup<RajonnoeOtdelenieKaznacejstva> {
}