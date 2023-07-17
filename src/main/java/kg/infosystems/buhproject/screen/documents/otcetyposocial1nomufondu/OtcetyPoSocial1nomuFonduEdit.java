package kg.infosystems.buhproject.screen.documents.otcetyposocial1nomufondu;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.OtcetyPoSocial1nomuFondu;
import kg.infosystems.buhproject.entity.parts.documents.OtcetyPoSocial1nomuFonduFondOplatyTrudaPoKategoriam;
import kg.infosystems.buhproject.entity.parts.documents.OtcetyPoSocial1nomuFonduSvedeniaOZanatostiIZarabotnojPlate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("OtcetyPoSocial1nomuFondu.edit")
@UiDescriptor("otcety-po-social1nomu-fondu-edit.xml")
@EditedEntityContainer("otcetyPoSocial1nomuFonduDc")
public class OtcetyPoSocial1nomuFonduEdit extends StandardEditor<OtcetyPoSocial1nomuFondu> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<OtcetyPoSocial1nomuFonduSvedeniaOZanatostiIZarabotnojPlate> svedeniaDc;
    @Autowired
    private CollectionPropertyContainer<OtcetyPoSocial1nomuFonduFondOplatyTrudaPoKategoriam> fondDc;

    @Subscribe("svedeniaTable.create")
    public void onSvedeniaTableCreate(Action.ActionPerformedEvent event) {
        OtcetyPoSocial1nomuFonduSvedeniaOZanatostiIZarabotnojPlate item = dataContext.create(OtcetyPoSocial1nomuFonduSvedeniaOZanatostiIZarabotnojPlate.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(svedeniaDc.getDisconnectedItems().size()));
        svedeniaDc.getMutableItems().add(item);
    }

    @Subscribe("fondTable.create")
    public void onFondTableCreate(Action.ActionPerformedEvent event) {
        OtcetyPoSocial1nomuFonduFondOplatyTrudaPoKategoriam item = dataContext.create(OtcetyPoSocial1nomuFonduFondOplatyTrudaPoKategoriam.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(fondDc.getDisconnectedItems().size()));
        fondDc.getMutableItems().add(item);
    }
}