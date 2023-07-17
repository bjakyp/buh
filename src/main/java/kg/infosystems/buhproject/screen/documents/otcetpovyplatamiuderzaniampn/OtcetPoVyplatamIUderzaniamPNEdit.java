package kg.infosystems.buhproject.screen.documents.otcetpovyplatamiuderzaniampn;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.OtcetPoVyplatamIUderzaniamPN;
import kg.infosystems.buhproject.entity.parts.documents.OtcetPoVyplatamIUderzaniamPNOtcet;
import kg.infosystems.buhproject.entity.parts.documents.OtcetPoVyplatamIUderzaniamPNOtcetGodovoj;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("OtcetPoVyplatamIUderzaniamPN.edit")
@UiDescriptor("otcet-po-vyplatam-i-uderzaniam-pn-edit.xml")
@EditedEntityContainer("otcetPoVyplatamIUderzaniamPNDc")
public class OtcetPoVyplatamIUderzaniamPNEdit extends StandardEditor<OtcetPoVyplatamIUderzaniamPN> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<OtcetPoVyplatamIUderzaniamPNOtcet> otcetDc;
    @Autowired
    private CollectionPropertyContainer<OtcetPoVyplatamIUderzaniamPNOtcetGodovoj> otcetGodovojDc;

    @Subscribe("otcetTable.create")
    public void onOtcetTableCreate(Action.ActionPerformedEvent event) {
        OtcetPoVyplatamIUderzaniamPNOtcet item = dataContext.create(OtcetPoVyplatamIUderzaniamPNOtcet.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(otcetDc.getDisconnectedItems().size()));
        otcetDc.getMutableItems().add(item);
    }

    @Subscribe("otcetGodovojTable.create")
    public void onOtcetGodovojTableCreate(Action.ActionPerformedEvent event) {
        OtcetPoVyplatamIUderzaniamPNOtcetGodovoj item = dataContext.create(OtcetPoVyplatamIUderzaniamPNOtcetGodovoj.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(otcetGodovojDc.getDisconnectedItems().size()));
        otcetGodovojDc.getMutableItems().add(item);
    }
}