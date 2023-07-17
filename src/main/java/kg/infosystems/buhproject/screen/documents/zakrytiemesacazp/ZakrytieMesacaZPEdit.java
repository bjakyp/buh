package kg.infosystems.buhproject.screen.documents.zakrytiemesacazp;

import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.ZakrytieMesacaZP;
import kg.infosystems.buhproject.entity.parts.documents.ZakrytieMesacaZPNalogiPoZarplate;
import kg.infosystems.buhproject.entity.parts.documents.ZakrytieMesacaZPProvodki;
import kg.infosystems.buhproject.entity.parts.documents.ZakrytieMesacaZPUderzania;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@UiController("ZakrytieMesacaZP.edit")
@UiDescriptor("zakrytie-mesaca-zp-edit.xml")
@EditedEntityContainer("zakrytieMesacaZPDc")
public class ZakrytieMesacaZPEdit extends StandardEditor<ZakrytieMesacaZP> {
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionPropertyContainer<ZakrytieMesacaZPNalogiPoZarplate> nalogiPoZarplateDc;
    @Autowired
    private CollectionPropertyContainer<ZakrytieMesacaZPUderzania> uderzaniaDc;
    @Autowired
    private CollectionPropertyContainer<ZakrytieMesacaZPProvodki> provodkiDc;

    @Subscribe("nalogiPoZarplateTable.create")
    public void onNalogiPoZarplateTableCreate(Action.ActionPerformedEvent event) {
        ZakrytieMesacaZPNalogiPoZarplate item = dataContext.create(ZakrytieMesacaZPNalogiPoZarplate.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nalogiPoZarplateDc.getDisconnectedItems().size()));
        nalogiPoZarplateDc.getMutableItems().add(item);
    }

    @Subscribe("uderzaniaTable.create")
    public void onUderzaniaTableCreate(Action.ActionPerformedEvent event) {
        ZakrytieMesacaZPUderzania item = dataContext.create(ZakrytieMesacaZPUderzania.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(uderzaniaDc.getDisconnectedItems().size()));
        uderzaniaDc.getMutableItems().add(item);
    }

    @Subscribe("provodkiTable.create")
    public void onProvodkiTableCreate(Action.ActionPerformedEvent event) {
        ZakrytieMesacaZPProvodki item = dataContext.create(ZakrytieMesacaZPProvodki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(provodkiDc.getDisconnectedItems().size()));
        provodkiDc.getMutableItems().add(item);
    }
}