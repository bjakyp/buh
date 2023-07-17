package kg.infosystems.buhproject.screen.accounts.hozrascetnyj;


import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import kg.infosystems.buhproject.entity.accounts.Hozrascetnyj;

@UiController("Hozrascetnyj.browse")
@UiDescriptor("hozrascetnyj-browse.xml")
@LookupComponent("hozrascetnyjsTable")
public class HozrascetnyjBrowse extends StandardLookup<Hozrascetnyj> {

}
