package kg.infosystems.buhproject.screen.documents.predel1naacislennost1;

import io.jmix.core.DataManager;
import io.jmix.ui.Dialogs;
import io.jmix.ui.component.TextField;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Predel1naaCislennost1;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@UiController("Predel1naaCislennost1.browse")
@UiDescriptor("predel1naa-cislennost1-browse.xml")
@LookupComponent("predel1naaCislennost1sTable")
public class Predel1naaCislennost1Browse extends StandardLookup<Predel1naaCislennost1> {
    @Inject
    private TextField<Integer> vsegoTotalField;
    @Inject
    private TextField<Integer> topAndMopTotalField;
    @Inject
    private TextField<Integer> osnovnoyPersonalTotalField;
    @Inject
    private TextField<Integer> aupTotalField;
    @Inject
    private CollectionContainer<Predel1naaCislennost1> predel1naaCislennost1sDc;

    @Inject
    private DataManager dataManager;

    @Inject
    private Dialogs dialogs;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        sumAndSetValues();
    }


    @Subscribe(id = "predel1naaCislennost1sDc", target = Target.DATA_CONTAINER)
    public void onPredel1naaCislennost1sDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Predel1naaCislennost1> event) {
        BigDecimal total = BigDecimal.ZERO;
        Predel1naaCislennost1 pc = event.getItem();
        total = total.add(pc.getAup() == null ? BigDecimal.ZERO : new BigDecimal(pc.getAup()));
        total = total.add(pc.getOsnovnoyPersonal() == null ? BigDecimal.ZERO : new BigDecimal(pc.getOsnovnoyPersonal()));
        total = total.add(pc.getTopAndMop() == null ? BigDecimal.ZERO : new BigDecimal(pc.getTopAndMop()));
        pc.setVsego(total.intValue());
        dataManager.save(pc);
        sumAndSetValues();
    }

    private void sumAndSetValues() {
        List<Predel1naaCislennost1> currList = predel1naaCislennost1sDc.getItems();
        Integer aup = 0, osnovnoyPersonal = 0, topAndMop = 0, vsego = 0;
        for (Predel1naaCislennost1 pc : currList) {
            aup += pc.getAup() == null ? 0 : pc.getAup();
            osnovnoyPersonal += pc.getOsnovnoyPersonal() == null ? 0 : pc.getOsnovnoyPersonal();
            topAndMop += pc.getTopAndMop() == null ? 0 : pc.getTopAndMop();
            vsego += pc.getVsego() == null ? 0 : pc.getVsego();
        }
        vsegoTotalField.setValue(vsego);
        topAndMopTotalField.setValue(topAndMop);
        osnovnoyPersonalTotalField.setValue(osnovnoyPersonal);
        aupTotalField.setValue(aup);
    }


}
