package kg.infosystems.buhproject.screen.documents.neavka;

import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Neavka;
import kg.infosystems.buhproject.entity.enumerations.VidyTabelyaUceta;
import kg.infosystems.buhproject.entity.parts.documents.NeavkaSotrudniki;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("Neavka.edit")
@UiDescriptor("neavka-edit.xml")
@EditedEntityContainer("neavkaDc")
public class NeavkaEdit extends StandardEditor<Neavka> {
    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionPropertyContainer<NeavkaSotrudniki> sotrudnikiDc;
    @Inject
    private EntityStates entityStates;
    @Inject
    private Notifications notifications;

    @Subscribe("sotrudnikiTable.create")
    public void onSotrudnikiTableCreate(Action.ActionPerformedEvent event) {
        NeavkaSotrudniki item = dataManager.create(NeavkaSotrudniki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(sotrudnikiDc.getDisconnectedItems().size()));
        sotrudnikiDc.getMutableItems().add(item);
    }

    /*Nurs 19.06.2023*/
    @Subscribe(id = "sotrudnikiDc", target = Target.DATA_CONTAINER)
    public void onSotrudnikiDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<NeavkaSotrudniki> event) {
        NeavkaSotrudniki ns = event.getItem();
        if (ns.getSotrudnik() == null)
            event.getItem().setTabelNomer(null);
        else event.getItem().setTabelNomer(ns.getSotrudnik().getKod());
        if (getEditedEntity().getData() == null) {
            showNotifications("Заполните поле дата!", "", Notifications.NotificationType.WARNING);

        } else if (ns.getDataOtsutstvia() != null && ns.getDataOtsutstvia().getMonth() != getEditedEntity().getData().getMonth()) {
            event.getItem().setDataOtsutstvia(null);
            showNotifications("Выберите нужную дату в месяце!", "", Notifications.NotificationType.WARNING);
        }
    }

    private Boolean isOneTimeInMonth() {
        return dataManager.loadValue("select count(e) from Neavka e " +
                "where e.organizacia = :organ and e.data between :firstDayOfMonth and :lastDayOfMonth", Long.class)
            .parameter("organ", getEditedEntity().getOrganizacia())
            .parameter("firstDayOfMonth", getEditedEntity().getData().withDayOfMonth(1))
            .parameter("lastDayOfMonth", getEditedEntity().getData().withDayOfMonth(1).plusMonths(1).minusDays(1))
            .one() == 0;
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        int type = entityStates.isNew(getEditedEntity()) ? 0 : 1;
        Neavka current = getEditedEntity();
        if (!isOneTimeInMonth()) {
            showNotifications("За этот месяц уже добавлен документ!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else if (!checkDaysInRegister(type)) {
            notifications.create()
                .withCaption("Измените даты неавки работников")
                .withDescription("Не должно совподать с регистром!")
                .withType(Notifications.NotificationType.WARNING)
                .withPosition(Notifications.Position.MIDDLE_CENTER)
                .show();
            event.preventCommit();
        } else if (sotrudnikiDc.getItems().isEmpty()) {
            showNotifications("Заполните таблицу работники!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else {
            for (NeavkaSotrudniki sotrudnik : sotrudnikiDc.getItems()) {
                if (type == 0) {
                    Tabel1UcetaPoseshenia tup = dataManager.create(Tabel1UcetaPoseshenia.class);
                    tup.setAktivnost1(false);
                    tup.setVidyTabelyaUceta(dataManager.load(VidyTabelyaUceta.class).id(3).one());
                    getEditedEntity().setProveden(false);
                    setValuesToRegister(tup, sotrudnik);
                } else {
                    setValuesToRegister(dataManager.load(Tabel1UcetaPoseshenia.class)
                        .query("select e from Tabel1UcetaPoseshenia e " +
                            "where e.tabel = :tabelId and e.sotrudnik = :sotrudnik")
                        .parameter("tabelId", current.getId())
                        .parameter("sotrudnik", sotrudnik.getSotrudnik())
                        .one(), sotrudnik);
                }
            }
        }
    }

    private void showNotifications(String caption, String description, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(description)
            .withType(type)
            .withPosition(Notifications.Position.MIDDLE_CENTER)
            .show();
    }

    private void setValuesToRegister(Tabel1UcetaPoseshenia tup, NeavkaSotrudniki sotrudnik) {
        Neavka current = getEditedEntity();
        tup.setNomerStroki(sotrudnik.getNomerStroki());
        tup.setOrganizacia(current.getOrganizacia());
        tup.setSotrudnik(sotrudnik.getSotrudnik());
        tup.setDataNacala(sotrudnik.getDataOtsutstvia().atStartOfDay());
        tup.setDataOkoncania(sotrudnik.getDataOtsutstvia().atStartOfDay());
        tup.setPeriod(current.getData().atStartOfDay());
        tup.setTabel(current.getId());
        dataManager.save(tup);
    }

    private Boolean checkDaysInRegister(int type) {
        Neavka koman = getEditedEntity();
        for (NeavkaSotrudniki sotrudnik : sotrudnikiDc.getItems()) {
            long register = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                    "where e.aktivnost1 = true " +
                    "and e.sotrudnik = :sotrudnik " +
                    "and e.organizacia = :organizacia " +
                    "and e.dataNacala >= :date and e.dataNacala <= :date", Long.class)
                .parameter("sotrudnik", sotrudnik.getSotrudnik())
                .parameter("organizacia", koman.getOrganizacia())
                .parameter("date", sotrudnik.getDataOtsutstvia().atStartOfDay())
                .one();
            if (type != register) return false;
        }
        return true;
    }


}

