package kg.infosystems.buhproject.screen.documents.rabotavvyhodnyeiprazdnicnyedni;

import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RabotaVVyhodnyeIPrazdnicnyeDni;
import kg.infosystems.buhproject.entity.enumerations.VidyTabelyaUceta;
import kg.infosystems.buhproject.entity.parts.documents.RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("RabotaVVyhodnyeIPrazdnicnyeDni.edit")
@UiDescriptor("rabota-v-vyhodnye-i-prazdnicnye-dni-edit.xml")
@EditedEntityContainer("rabotaVVyhodnyeIPrazdnicnyeDniDc")
public class RabotaVVyhodnyeIPrazdnicnyeDniEdit extends StandardEditor<RabotaVVyhodnyeIPrazdnicnyeDni> {
    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionPropertyContainer<RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki> sotrudnikiDc;
    @Inject
    private EntityStates entityStates;
    @Inject
    private Notifications notifications;

    @Subscribe("sotrudnikiTable.create")
    public void onSotrudnikiTableCreate(Action.ActionPerformedEvent event) {
        RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki item = dataManager.create(RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(sotrudnikiDc.getDisconnectedItems().size()));
        sotrudnikiDc.getMutableItems().add(item);
    }

    @Subscribe(id = "sotrudnikiDc", target = Target.DATA_CONTAINER)
    public void onSotrudnikiDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki> event) {
        if (event.getItem().getSotrudnik() != null) {
            event.getItem().setNomerStroki(BigDecimal.valueOf(event.getItem().getSotrudnik().getKod()));
        }
    }

    private Boolean isOneTimeInMonth() {
        return dataManager.loadValue("select count(e) from RabotaVVyhodnyeIPrazdnicnyeDni e " +
                "where e.organizacia = :organ and e.data between :firstDayOfMonth and :lastDayOfMonth", Long.class)
            .parameter("organ", getEditedEntity().getOrganizacia())
            .parameter("firstDayOfMonth", getEditedEntity().getData().withDayOfMonth(1))
            .parameter("lastDayOfMonth", getEditedEntity().getData().withDayOfMonth(1).plusMonths(1).minusDays(1))
            .one() == 0;
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        int type = entityStates.isNew(getEditedEntity()) ? 0 : 1;
        if (!isOneTimeInMonth()) {
            showNotifications("За этот месяц уже добавлен документ!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else if (!checkDaysInRegister(type)) {
            notifications.create()
                .withCaption("Измените даты работы работников")
                .withDescription("Не должно совподать с регистром!")
                .withType(Notifications.NotificationType.WARNING)
                .withPosition(Notifications.Position.MIDDLE_CENTER)
                .show();
            event.preventCommit();
        } else if (sotrudnikiDc.getItems().isEmpty()) {
            showNotifications("Заполните таблицу работники!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else {
            for (RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki sotrudnik : sotrudnikiDc.getItems()) {
                if (type == 0) {
                    Tabel1UcetaPoseshenia tup = dataManager.create(Tabel1UcetaPoseshenia.class);
                    tup.setAktivnost1(false);
                    tup.setVidyTabelyaUceta(dataManager.load(VidyTabelyaUceta.class).id(5).one());
                    getEditedEntity().setProveden(false);
                    setValuesToRegister(tup, sotrudnik);
                } else {
                    RabotaVVyhodnyeIPrazdnicnyeDni editedVP = getEditedEntity();
                    setValuesToRegister(dataManager.load(Tabel1UcetaPoseshenia.class)
                        .query("select e from Tabel1UcetaPoseshenia e " +
                            "where e.tabel = :tabelId and e.sotrudnik = :sotrudnik")
                        .parameter("tabelId", editedVP.getId())
                        .parameter("sotrudnik", sotrudnik.getSotrudnik())
                        .one(), sotrudnik);
                }
            }
        }
    }

    private void setValuesToRegister(Tabel1UcetaPoseshenia tup, RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki sotrudnik) {
        RabotaVVyhodnyeIPrazdnicnyeDni editedVP = getEditedEntity();
        tup.setNomerStroki(sotrudnik.getNomerStroki());
        tup.setOrganizacia(editedVP.getOrganizacia());
        tup.setSotrudnik(sotrudnik.getSotrudnik());
        tup.setDataNacala(sotrudnik.getDataNacala());
        tup.setDataOkoncania(sotrudnik.getDataOkoncania());
        tup.setPeriod(editedVP.getData());
        tup.setTabel(editedVP.getId());
        dataManager.save(tup);
    }

    private void showNotifications(String caption, String description, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(description)
            .withType(type)
            .withPosition(Notifications.Position.MIDDLE_CENTER)
            .show();
    }

    private Boolean checkDaysInRegister(int type) {
        RabotaVVyhodnyeIPrazdnicnyeDni editedVP = getEditedEntity();
        for (RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki sotrudnik : sotrudnikiDc.getItems()) {
            long register = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                    "where e.aktivnost1 = true " +
                    "and e.sotrudnik = :sotrudnik " +
                    "and e.organizacia = :organizacia " +
                    "and e.dataNacala >= :date and e.dataNacala <= :date", Long.class)
                .parameter("sotrudnik", sotrudnik.getSotrudnik())
                .parameter("organizacia", editedVP.getOrganizacia())
                .parameter("date", sotrudnik.getDataNacala())
                .one();
            if (type != register) return false;
        }
        return true;
    }

}
