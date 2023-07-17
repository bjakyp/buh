package kg.infosystems.buhproject.screen.documents.otcetypopodohodnomunalogu;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.OtcetyPoPodohodnomuNalogu;
import kg.infosystems.buhproject.entity.parts.documents.OtcetyPoPodohodnomuNaloguPodohodnyjNalog;
import kg.infosystems.buhproject.entity.parts.documents.OtcetyPoPodohodnomuNaloguPodohodnyjNalogPervyjMesacKvartala;
import kg.infosystems.buhproject.entity.parts.documents.OtcetyPoPodohodnomuNaloguPodohodnyjNalogTretijMesacKvartala;
import kg.infosystems.buhproject.entity.parts.documents.OtcetyPoPodohodnomuNaloguPodohodnyjNalogVtorojMesacKvartala;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("OtcetyPoPodohodnomuNalogu.edit")
@UiDescriptor("otcety-po-podohodnomu-nalogu-edit.xml")
@EditedEntityContainer("otcetyPoPodohodnomuNaloguDc")
public class OtcetyPoPodohodnomuNaloguEdit extends StandardEditor<OtcetyPoPodohodnomuNalogu> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<OtcetyPoPodohodnomuNaloguPodohodnyjNalog> pdohonyjNalogDc;
    @Autowired
    private CollectionPropertyContainer<OtcetyPoPodohodnomuNaloguPodohodnyjNalogPervyjMesacKvartala> podohonyjNalogPervyjMesacKvartalaDc;
    @Autowired
    private CollectionPropertyContainer<OtcetyPoPodohodnomuNaloguPodohodnyjNalogVtorojMesacKvartala> podohodnyjNalogVtorojMesacKvartalaDc;
    @Autowired
    private CollectionPropertyContainer<OtcetyPoPodohodnomuNaloguPodohodnyjNalogTretijMesacKvartala> podohodnyjNalogTretijMesacKvartalaDc;

    @Subscribe("pdohonyjNalogTable.create")
    public void onPdohonyjNalogTableCreate(Action.ActionPerformedEvent event) {
        OtcetyPoPodohodnomuNaloguPodohodnyjNalog item = dataContext.create(OtcetyPoPodohodnomuNaloguPodohodnyjNalog.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(pdohonyjNalogDc.getDisconnectedItems().size()));
        pdohonyjNalogDc.getMutableItems().add(item);
    }

    @Subscribe("podohonyjNalogPervyjMesacKvartalaTable.create")
    public void onPodohonyjNalogPervyjMesacKvartalaTableCreate(Action.ActionPerformedEvent event) {
        OtcetyPoPodohodnomuNaloguPodohodnyjNalogPervyjMesacKvartala item = dataContext.create(OtcetyPoPodohodnomuNaloguPodohodnyjNalogPervyjMesacKvartala.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(podohonyjNalogPervyjMesacKvartalaDc.getDisconnectedItems().size()));
        podohonyjNalogPervyjMesacKvartalaDc.getMutableItems().add(item);
    }

    @Subscribe("podohodnyjNalogVtorojMesacKvartalaTable.create")
    public void onPodohodnyjNalogVtorojMesacKvartalaTableCreate(Action.ActionPerformedEvent event) {
        OtcetyPoPodohodnomuNaloguPodohodnyjNalogVtorojMesacKvartala item = dataContext.create(OtcetyPoPodohodnomuNaloguPodohodnyjNalogVtorojMesacKvartala.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(podohodnyjNalogVtorojMesacKvartalaDc.getDisconnectedItems().size()));
        podohodnyjNalogVtorojMesacKvartalaDc.getMutableItems().add(item);
    }

    @Subscribe("podohodnyjNalogTretijMesacKvartalaTable.create")
    public void onPodohodnyjNalogTretijMesacKvartalaTableCreate(Action.ActionPerformedEvent event) {
        OtcetyPoPodohodnomuNaloguPodohodnyjNalogTretijMesacKvartala item = dataContext.create(OtcetyPoPodohodnomuNaloguPodohodnyjNalogTretijMesacKvartala.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(podohodnyjNalogTretijMesacKvartalaDc.getDisconnectedItems().size()));
        podohodnyjNalogTretijMesacKvartalaDc.getMutableItems().add(item);
    }
}