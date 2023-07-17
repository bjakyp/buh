package kg.infosystems.buhproject.screen.documents.otpusk;

import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TextField;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Otpusk;
import kg.infosystems.buhproject.entity.enumerations.VidyTabelyaUceta;
import kg.infosystems.buhproject.entity.parts.documents.OtpuskNacislenia;
import kg.infosystems.buhproject.entity.parts.documents.OtpuskSrednijZarabotok;
import kg.infosystems.buhproject.entity.registers.informations.RazovoeNacislenie;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@UiController("Otpusk.edit")
@UiDescriptor("otpusk-edit.xml")
@EditedEntityContainer("otpuskDc")
public class OtpuskEdit extends StandardEditor<Otpusk> {
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionPropertyContainer<OtpuskSrednijZarabotok> srednijZarabotokDc;
    @Inject
    private CollectionPropertyContainer<OtpuskNacislenia> nacisleniaDc;
    @Inject
    private Notifications notifications;
    @Inject
    private DateField<LocalDateTime> dataNacalaField;
    @Inject
    private DateField<LocalDateTime> dataOkoncaniaField;
    @Inject
    private TextField<String> totalField;

    @Inject
    private TextField<String> averageSalaryField;
    @Inject
    private TextField<String> monthsField;
    @Inject
    private TextField<BigDecimal> dnejField;

    @Inject
    private EntityStates entityStates;
    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        if (!entityStates.isNew(getEditedEntity())) changeStaticValues();
    }


    @Subscribe("srednijZarabotokTable.create")
    public void onSrednijZarabotokTableCreate(Action.ActionPerformedEvent event) {
        if (dataNacalaField.getValue() == null || dataOkoncaniaField.getValue() == null) {
            showNotifications("Заполните поля с датами!", "", Notifications.NotificationType.WARNING);
            return;
        } else if (srednijZarabotokDc.getItems().size() > 2) {
            showNotifications("Максимальное допустимое число 3!", "", Notifications.NotificationType.ERROR);
            return;
        }
        OtpuskSrednijZarabotok item = dataContext.create(OtpuskSrednijZarabotok.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(srednijZarabotokDc.getDisconnectedItems().size() + 1));
        srednijZarabotokDc.getMutableItems().add(item);
    }

    @Subscribe(id = "srednijZarabotokDc", target = Target.DATA_CONTAINER)
    public void onSrednijZarabotokDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<OtpuskSrednijZarabotok> event) {
        LocalDateTime time = event.getItem().getPeriodRegistracii();
        if (time == null) return;
        else if (!checkDay(time)) {
            showNotifications("Месяца не должны совподать!", "", Notifications.NotificationType.WARNING);
            event.getItem().setPeriodRegistracii(null);
        } else if (time.isAfter(dataNacalaField.getValue()) || time.isEqual(dataNacalaField.getValue())) {
            showNotifications("Выберите дату до даты начало отпуска!", "", Notifications.NotificationType.ERROR);
            event.getItem().setPeriodRegistracii(null);
        } else {
            if (time.getDayOfMonth() != 1) event.getItem().setPeriodRegistracii(getFirstDayOfMonth(event.getItem().getPeriodRegistracii()));
            changeStaticValues();
            if (event.getItem().getRezul1tat() != null) {
                addNacisleniaColumn();
            }
        }
    }

    @Subscribe(id = "nacisleniaDc", target = Target.DATA_CONTAINER)
    public void onNacisleniaDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<OtpuskNacislenia> event) {
        OtpuskNacislenia on = event.getItem();
        if (on.getRazmer() != null && on.getOtrabotanoDnej() != null)
            event.getItem().setRezul1tat(on.getRazmer().multiply(on.getOtrabotanoDnej()));
    }

    @Subscribe("nacisleniaTable.create")
    public void onNacisleniaTableCreate(Action.ActionPerformedEvent event) {
        if (nacisleniaDc.getItems().size() > 1) {
            showNotifications("Максимальное допустимое число 2!", "", Notifications.NotificationType.ERROR);
            return;
        }
        OtpuskNacislenia item = dataContext.create(OtpuskNacislenia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(nacisleniaDc.getDisconnectedItems().size() + 1));
        nacisleniaDc.getMutableItems().add(item);
    }

    @Subscribe("calculateBtn")
    public void onCalculateBtnClick(Button.ClickEvent event) {
        addNacisleniaColumn();
    }

    @Subscribe("dataNacalaField")
    public void onDataNacalaFieldValueChange(HasValue.ValueChangeEvent<LocalDateTime> event) {
        getEditedEntity().setDnej(daysBetween(dataNacalaField.getValue(), dataOkoncaniaField.getValue()));
    }

    @Subscribe("dataOkoncaniaField")
    public void onDataOkoncaniaFieldValueChange(HasValue.ValueChangeEvent<LocalDateTime> event) {
        getEditedEntity().setDnej(daysBetween(dataNacalaField.getValue(), dataOkoncaniaField.getValue()));
    }

    private void changeStaticValues() {
        averageSalaryField.setValue(averageSalary(srednijZarabotokDc.getItems()).toString());
        totalField.setValue(sumList(srednijZarabotokDc.getItems()).toString());
        monthsField.setValue(String.valueOf(srednijZarabotokDc.getItems().size()));
    }

    private void addNacisleniaColumn() {
        nacisleniaDc.getMutableItems().clear();
        int size = nacisleniaDc.getMutableItems().size() + 1;
        if (new BigDecimal(Objects.requireNonNull(averageSalaryField.getValue())).equals(BigDecimal.ZERO) || dnejField.getValue() == null) {
            showNotifications("Заполните таблицу 'Средний зароботок'", "Поля с датами тоже обезятельные!", Notifications.NotificationType.WARNING);
        } else {
            BigDecimal averageValue = new BigDecimal(averageSalaryField.getValue());
            OtpuskNacislenia otpusk = dataContext.create(OtpuskNacislenia.class);
            otpusk.setPart(getEditedEntity());
            otpusk.setNomerStroki(BigDecimal.valueOf(size));
            otpusk.setOtrabotanoDnej(dnejField.getValue());
            otpusk.setRazmer(averageValue);
            otpusk.setRezul1tat(otpusk.getOtrabotanoDnej().multiply(averageValue));
            nacisleniaDc.getMutableItems().add(otpusk);
        }
    }

    private boolean checkDay(LocalDateTime time) {
        int count = 0;
        for (OtpuskSrednijZarabotok o : srednijZarabotokDc.getItems()) {
            count += (o.getPeriodRegistracii() != null && o.getPeriodRegistracii().getMonth() == time.getMonth() && o.getPeriodRegistracii().getYear() == time.getYear() ? 1 : 0);
        }
        return count == 1;
    }

    private BigDecimal daysBetween(LocalDateTime first, LocalDateTime second) {
        if (first == null || second == null) return null;
        long daysBetween = ChronoUnit.DAYS.between(first, second);
        if (daysBetween < 0) {
            showNotifications("Выберите дату окончания после даты начала!", "", Notifications.NotificationType.WARNING);
            dataNacalaField.setValue(null);
            dataOkoncaniaField.setValue(null);
            return null;
        }
        return new BigDecimal(daysBetween);
    }

    private BigDecimal sumList(List<OtpuskSrednijZarabotok> list) {
        BigDecimal total = new BigDecimal(0);
        for (OtpuskSrednijZarabotok t : list) {
            total = total.add(t.getRezul1tat() != null ? t.getRezul1tat() : BigDecimal.ZERO);
        }
        return total;
    }

    private LocalDateTime getFirstDayOfMonth(LocalDateTime date) {
        return date.withDayOfMonth(1);
    }

    private BigDecimal averageSalary(List<OtpuskSrednijZarabotok> list) {
        BigDecimal total = new BigDecimal(0);
        if (list.size() == 0) return total;
        for (OtpuskSrednijZarabotok osz : list) {
            total = total.add(osz.getRezul1tat() != null ? osz.getRezul1tat() : BigDecimal.ZERO);
        }
        return total.divide(BigDecimal.valueOf(list.size()).multiply(BigDecimal.valueOf(29.6)), 2, RoundingMode.HALF_UP);
    }

    private void showNotifications(String caption, String description, Notifications.NotificationType type) {
        notifications.create().withCaption(caption).withDescription(description).withType(type).withPosition(Notifications.Position.MIDDLE_CENTER).show();
    }

    private Boolean isOneTimeInMonth() {
        return dataManager.loadValue("select count(e) from Otpusk e " +
                "where e.organizacia = :organ and e.data between :firstDayOfMonth and :lastDayOfMonth", Long.class)
            .parameter("organ", getEditedEntity().getOrganizacia())
            .parameter("firstDayOfMonth", getEditedEntity().getData().withDayOfMonth(1))
            .parameter("lastDayOfMonth", getEditedEntity().getData().withDayOfMonth(1).plusMonths(1).minusDays(1))
            .one() == 0;
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        /*Сохраняет записи в Регистр разовых начислений*/
        Otpusk otpusk = getEditedEntity();
        long register = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                "where e.aktivnost1 = true " +
                "and e.sotrudnik = :sotrudnik " +
                "and e.organizacia = :organizacia " +
                "and ((e.dataNacala >= :dateFrom and e.dataNacala <= :dateTo) " +
                "or (e.dataOkoncania >= :dateFrom and e.dataOkoncania <= :dateTo))", Long.class)
            .parameter("sotrudnik", otpusk.getSotrudnik())
            .parameter("organizacia", otpusk.getOrganizacia())
            .parameter("dateFrom", otpusk.getDataNacala())
            .parameter("dateTo", otpusk.getDataOkoncania())
            .one();
        if (!isOneTimeInMonth()) {
            showNotifications("За этот месяц уже добавлен документ!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else if ((entityStates.isNew(getEditedEntity()) && register != 0) || register != 1) {
            showNotifications("Измените дату начало и дату окончания!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        }
        if (entityStates.isNew(getEditedEntity())) {
            Tabel1UcetaPoseshenia tup = dataManager.create(Tabel1UcetaPoseshenia.class);
            tup.setAktivnost1(false);
            getEditedEntity().setProveden(false);
            tup.setVidyTabelyaUceta(dataManager.load(VidyTabelyaUceta.class)
                .id(4).one());
            setValuesToRegister(tup);
            getEditedEntity().setRegisterTabelya(tup);
        } else {
            setValuesToRegister(getEditedEntity().getRegisterTabelya());
        }
        List<Otpusk> otpuskList = dataManager.load(Otpusk.class).query("select s from Otpusk s " +
            "where s.id = :id").parameter("id", getEditedEntity().getId()).list();
        if (!otpuskList.isEmpty()) {
            List<RazovoeNacislenie> razovoeNacislenieList = dataManager.load(RazovoeNacislenie.class).query("select s from RazovoeNacislenie s where s.otpusk = :otpusk").parameter("otpusk", getEditedEntity()).list();
            if (!razovoeNacislenieList.isEmpty()) for (RazovoeNacislenie razovoeNacislenie : razovoeNacislenieList)
                dataManager.remove(razovoeNacislenie);
        }

        List<RazovoeNacislenie> razovoeNacislenieList = new ArrayList<>();
        for (OtpuskNacislenia otpuskNacislenia : getEditedEntity().getNacislenia()) {
            RazovoeNacislenie razovoeNacislenie = dataContext.create(RazovoeNacislenie.class);
            razovoeNacislenie.setOtpusk(getEditedEntity());
//            razovoeNacislenie.setStatus();
            razovoeNacislenie.setDataNacislenia(getEditedEntity().getDataNacala());
            razovoeNacislenie.setOrganizacia(getEditedEntity().getOrganizacia());
            razovoeNacislenie.setDataOkoncania(getEditedEntity().getDataOkoncania());
            razovoeNacislenie.setDolznost1(getEditedEntity().getDolznost1());
            razovoeNacislenie.setSotrudnik(getEditedEntity().getSotrudnik());
            razovoeNacislenie.setPodrazdelenie(getEditedEntity().getPodrazdelenie());
            razovoeNacislenie.setGrafikRaboty(getEditedEntity().getGrafikRaboty());
            razovoeNacislenie.setVidRasceta(otpuskNacislenia.getVidRasceta());
            razovoeNacislenie.setDnej(otpuskNacislenia.getOtrabotanoDnej());
//            razovoeNacislenie.setCasov();
            razovoeNacislenie.setRazmer(otpuskNacislenia.getRazmer());
            razovoeNacislenie.setRezul1tat(otpuskNacislenia.getRezul1tat());
            razovoeNacislenie.setSposobOtrajenia(otpuskNacislenia.getSposobOtrazenia());
            razovoeNacislenieList.add(razovoeNacislenie);
        }
        getEditedEntity().setRegRazovoeNacislenie(razovoeNacislenieList);
    }

    private void setValuesToRegister(Tabel1UcetaPoseshenia tup) {
        Otpusk currE = getEditedEntity();
        tup.setNomerStroki(BigDecimal.valueOf(currE.getSotrudnik().getKod()));
        tup.setSotrudnik(currE.getSotrudnik());
        tup.setOrganizacia(currE.getOrganizacia());
        tup.setTabel(currE.getId());
        tup.setDataNacala(currE.getDataNacala());
        tup.setDataOkoncania(currE.getDataOkoncania());
        tup.setPodrazdelenie(currE.getPodrazdelenie());
        dataManager.save(tup);
    }

}
