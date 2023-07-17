package kg.infosystems.buhproject.screen.documents.rabotasverhurocno;

import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.RabotaSverhurocno;
import kg.infosystems.buhproject.entity.enumerations.VidyTabelyaUceta;
import kg.infosystems.buhproject.entity.parts.documents.RabotaSverhurocnoSotrudniki;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("RabotaSverhurocno.edit")
@UiDescriptor("rabota-sverhurocno-edit.xml")
@EditedEntityContainer("rabotaSverhurocnoDc")
public class RabotaSverhurocnoEdit extends StandardEditor<RabotaSverhurocno> {
    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionPropertyContainer<RabotaSverhurocnoSotrudniki> sotrudnikiDc;
    @Inject
    private EntityStates entityStates;
    @Inject
    private Notifications notifications;

    @Subscribe("sotrudnikiTable.create")
    public void onSotrudnikiTableCreate(Action.ActionPerformedEvent event) {
        RabotaSverhurocnoSotrudniki item = dataManager.create(RabotaSverhurocnoSotrudniki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(sotrudnikiDc.getDisconnectedItems().size()));
        sotrudnikiDc.getMutableItems().add(item);
    }

    @Subscribe(id = "sotrudnikiDc", target = Target.DATA_CONTAINER)
    public void onSotrudnikiDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<RabotaSverhurocnoSotrudniki> event) {
        if (event.getItem().getSotrudnik() != null) {
            event.getItem().setNomerStroki(BigDecimal.valueOf(event.getItem().getSotrudnik().getKod()));
        }
    }

    private Boolean isOneTimeInMonth() {
        return dataManager.loadValue("select count(e) from RabotaSverhurocno e " +
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
        }
        else if (!checkDaysInRegister(type)) {
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
            for (RabotaSverhurocnoSotrudniki sotrudnik : sotrudnikiDc.getItems()) {
                if (type == 0) {
                    Tabel1UcetaPoseshenia tup = dataManager.create(Tabel1UcetaPoseshenia.class);
                    tup.setAktivnost1(false);
                    tup.setVidyTabelyaUceta(dataManager.load(VidyTabelyaUceta.class).id(5).one());
                    getEditedEntity().setProveden(false);
                    setValuesToRegister(tup, sotrudnik);
                } else {
                    RabotaSverhurocno editedRS = getEditedEntity();
                    setValuesToRegister(dataManager.load(Tabel1UcetaPoseshenia.class)
                        .query("select e from Tabel1UcetaPoseshenia e " +
                            "where e.tabel = :tabelId and e.sotrudnik = :sotrudnik")
                        .parameter("tabelId", editedRS.getId())
                        .parameter("sotrudnik", sotrudnik.getSotrudnik())
                        .one(), sotrudnik);
                }
            }
        }
    }

    private void setValuesToRegister(Tabel1UcetaPoseshenia tup, RabotaSverhurocnoSotrudniki sotrudnik) {
        RabotaSverhurocno editedRS = getEditedEntity();
        tup.setNomerStroki(sotrudnik.getNomerStroki());
        tup.setOrganizacia(editedRS.getOrganizacia());
        tup.setSotrudnik(sotrudnik.getSotrudnik());
        tup.setDataNacala(sotrudnik.getDataVyhoda());
        tup.setDataOkoncania(sotrudnik.getDataVyhoda());
        tup.setPeriod(editedRS.getData());
        tup.setTabel(editedRS.getId());
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
        RabotaSverhurocno editedRS = getEditedEntity();
        for (RabotaSverhurocnoSotrudniki sotrudnik : sotrudnikiDc.getItems()) {
            long register = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                    "where e.aktivnost1 = true " +
                    "and e.sotrudnik = :sotrudnik " +
                    "and e.organizacia = :organizacia " +
                    "and e.dataNacala >= :date and e.dataNacala <= :date", Long.class)
                .parameter("sotrudnik", sotrudnik.getSotrudnik())
                .parameter("organizacia", editedRS.getOrganizacia())
                .parameter("date", sotrudnik.getDataVyhoda())
                .one();
            if (type != register) return false;
        }
        return true;
    }

}
