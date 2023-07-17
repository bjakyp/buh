package kg.infosystems.buhproject.screen.organizacii;

import io.jmix.core.DataManager;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;
import kg.infosystems.buhproject.entity.catalogs.StavkaProfsoyuza;
import kg.infosystems.buhproject.entity.compensations.VidyUderzanij;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@UiController("Organizacii.edit")
@UiDescriptor("organizacii-edit.xml")
@EditedEntityContainer("organizaciiDc")
public class OrganizaciiEdit extends StandardEditor<Organizacii> {
    @Inject
    private TextField<BigDecimal> stavka;
    @Inject
    private EntityPicker<VidyUderzanij> vidyUderzanij;
    @Inject
    private DateField<LocalDateTime> dataNachalaDeistvia;
    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (getEditedEntity().getStavkaProfsoyuza() == null) {
            StavkaProfsoyuza sp = dataManager.create(StavkaProfsoyuza.class);
            sp.setDataNachalaDeistvia(dataNachalaDeistvia.getValue());
            sp.setStavka(stavka.getValue());
            sp.setVidyUderzanij(vidyUderzanij.getValue());
            dataManager.save(sp);
            getEditedEntity().setStavkaProfsoyuza(sp);
        }
    }
}
