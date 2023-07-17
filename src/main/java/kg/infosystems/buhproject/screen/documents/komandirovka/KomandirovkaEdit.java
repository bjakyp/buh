package kg.infosystems.buhproject.screen.documents.komandirovka;

import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Goroda;
import kg.infosystems.buhproject.entity.catalogs.StranyMira;
import kg.infosystems.buhproject.entity.documents.Komandirovka;
import kg.infosystems.buhproject.entity.enumerations.VidyTabelyaUceta;
import kg.infosystems.buhproject.entity.parts.documents.KomandirovkaSotrudniki;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@UiController("Komandirovka.edit")
@UiDescriptor("komandirovka-edit.xml")
@EditedEntityContainer("komandirovkaDc")
public class KomandirovkaEdit extends StandardEditor<Komandirovka> {
    @Inject
    private DataManager dataManager;
    @Inject
    private EntityStates entityStates;
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionPropertyContainer<KomandirovkaSotrudniki> sotrudnikiDc;
    @Inject
    private CollectionLoader<Goroda> gorodaDl;

    @Subscribe("sotrudnikiTable.create")
    public void onSotrudnikiTableCreate(Action.ActionPerformedEvent event) {
        KomandirovkaSotrudniki item = dataManager.create(KomandirovkaSotrudniki.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(sotrudnikiDc.getDisconnectedItems().size()));
        sotrudnikiDc.getMutableItems().add(item);
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        int type = entityStates.isNew(getEditedEntity()) ? 0 : 1;
        Komandirovka current = getEditedEntity();
        if (!isOneTimeInMonth()) {
            showNotifications("За этот месяц уже добавлен документ!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else if (!checkDaysInRegister(type)) {
            showNotifications("Измените даты командировки работников", "Не должно совподать с регистром!", Notifications.NotificationType.WARNING);
        } else if (sotrudnikiDc.getItems().isEmpty() || checkSotrudnikiList()) {
            showNotifications("Заполните таблицу работники!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else {
            for (KomandirovkaSotrudniki sotrudnik : sotrudnikiDc.getItems()) {
                if (type == 0) {
                    Tabel1UcetaPoseshenia tup = dataManager.create(Tabel1UcetaPoseshenia.class);
                    tup.setAktivnost1(false);
                    tup.setVidyTabelyaUceta(dataManager.load(VidyTabelyaUceta.class).id(2).one());
                    getEditedEntity().setProveden(false);
                    setValuesToRegister(tup, sotrudnik);
                } else {
                    setValuesToRegister(dataManager.load(Tabel1UcetaPoseshenia.class).query("select e from Tabel1UcetaPoseshenia e " + "where e.tabel = :tabelId and e.sotrudnik = :sotrudnik").parameter("tabelId", current.getId()).parameter("sotrudnik", sotrudnik.getSotrudnik()).one(), sotrudnik);
                }
            }
        }
    }

    private Boolean isOneTimeInMonth() {
        return dataManager.loadValue("select count(e) from Komandirovka e " +
                "where e.organizacia = :organ and e.data between :firstDayOfMonth and :lastDayOfMonth", Long.class)
            .parameter("organ", getEditedEntity().getOrganizacia())
            .parameter("firstDayOfMonth", getEditedEntity().getData().withDayOfMonth(1))
            .parameter("lastDayOfMonth", getEditedEntity().getData().withDayOfMonth(1).plusMonths(1).minusDays(1))
            .one() == 0;
    }

    private void showNotifications(String caption, String description, Notifications.NotificationType type) {
        notifications.create().withCaption(caption).withDescription(description).withType(type).withPosition(Notifications.Position.MIDDLE_CENTER).show();
    }

    private void setValuesToRegister(Tabel1UcetaPoseshenia tup, KomandirovkaSotrudniki sotrudnik) {
        Komandirovka current = getEditedEntity();
        tup.setOrganizacia(current.getOrganizacia());
        tup.setSotrudnik(sotrudnik.getSotrudnik());
        tup.setDataNacala(current.getDataNacala());
        tup.setDataOkoncania(current.getDataOkoncania());
        tup.setPeriod(current.getData());
        tup.setTabel(current.getId());
        tup.setPodrazdelenie(sotrudnik.getPodrazdelenie());
        dataManager.save(tup);
    }

    private Boolean checkDaysInRegister(int type) {
        Komandirovka koman = getEditedEntity();
        for (KomandirovkaSotrudniki sotrudnik : sotrudnikiDc.getItems()) {
            long register = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                    "where e.aktivnost1 = true " +
                    "and e.sotrudnik = :sotrudnik " +
                    "and e.organizacia = :organizacia " +
                    "and ((e.dataNacala >= :startDate and e.dataNacala <= :endDate) " +
                    "or (e.dataOkoncania >= :startDate and e.dataOkoncania <= :endDate))", Long.class)
                .parameter("sotrudnik", sotrudnik.getSotrudnik())
                .parameter("organizacia", koman.getOrganizacia())
                .parameter("startDate", koman.getDataNacala())
                .parameter("endDate", koman.getDataOkoncania())
                .one();
            if (type != register) return false;
        }
        return true;
    }

    private Boolean checkSotrudnikiList() {
        for (KomandirovkaSotrudniki sotrudniki : sotrudnikiDc.getItems()) {
            if (sotrudniki.getSummaVsego() == null) return false;
        }
        return true;
    }

    @Subscribe("stranaField")
    public void onStranaFieldValueChange(HasValue.ValueChangeEvent<StranyMira> event) {
        if (event.getValue() != null) {
            gorodaDl.setParameter("strana", event.getValue());
        } else {
            gorodaDl.removeParameter("strana");
        }
        gorodaDl.load();
    }

    @Subscribe("gorodField")
    public void onGorodFieldValueChange(HasValue.ValueChangeEvent<Goroda> event) {
        if (event.getValue() != null && getEditedEntity().getStrana() == null) {
            getEditedEntity().setGorod(null);
            showNotifications("Сначало выберите страну!", "", Notifications.NotificationType.WARNING);
        }
    }

    @Subscribe("dataNacalaField")
    public void onDataNacalaFieldValueChange(HasValue.ValueChangeEvent<LocalDateTime> event) {
        setDaysBetween();
    }

    @Subscribe("dataOkoncaniaField")
    public void onDataOkoncaniaFieldValueChange(HasValue.ValueChangeEvent<LocalDateTime> event) {
        setDaysBetween();
    }

    @Subscribe(id = "sotrudnikiDc", target = Target.DATA_CONTAINER)
    public void onSotrudnikiDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<KomandirovkaSotrudniki> event) {
        KomandirovkaSotrudniki changedUser = event.getItem();
        if (changedUser.getSotrudnik() != null) {
            event.getItem().setNomerStroki(new BigDecimal(changedUser.getSotrudnik().getKod()));
        } else
            event.getItem().setNomerStroki(null);
        if (changedUser.getSutocnye() != null && changedUser.getProzivanie() != null && changedUser.getProezdnye() != null) {
            event.getItem().setSummaVsego(changedUser.getSutocnye().add(changedUser.getProzivanie().add(changedUser.getProezdnye())));
        } else
            event.getItem().setSummaVsego(null);
    }


    private void setDaysBetween() {
        LocalDateTime first = getEditedEntity().getDataNacala();
        LocalDateTime second = getEditedEntity().getDataOkoncania();
        if (first != null && second != null) {
            long daysBetween = ChronoUnit.DAYS.between(first, second);
            if (daysBetween < 0) {
                showNotifications("Выберите дату окончания после даты начала!", "", Notifications.NotificationType.WARNING);
                getEditedEntity().setDataNacala(null);
                getEditedEntity().setDataOkoncania(null);
                getEditedEntity().setKolicestvoDnej(null);
            } else getEditedEntity().setKolicestvoDnej(new BigDecimal(daysBetween + 1));
        }
    }
}
