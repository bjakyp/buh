package kg.infosystems.buhproject.screen.documents.bol1nicnyjlist;

import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.EntityComboBox;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TextField;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.Bol1nicnyjList;
import kg.infosystems.buhproject.entity.enumerations.Procenty;
import kg.infosystems.buhproject.entity.enumerations.VidyTabelyaUceta;
import kg.infosystems.buhproject.entity.parts.documents.Bol1nicnyjListNacislenia;
import kg.infosystems.buhproject.entity.parts.documents.Bol1nicnyjListSrednijZarabotok;
import kg.infosystems.buhproject.entity.registers.informations.RazovoeNacislenie;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@UiController("Bol1nicnyjList.edit")
@UiDescriptor("bol1nicnyj-list-edit.xml")
@EditedEntityContainer("bol1nicnyjListDc")
public class Bol1nicnyjListEdit extends StandardEditor<Bol1nicnyjList> {
    @Inject
    private CollectionPropertyContainer<Bol1nicnyjListSrednijZarabotok> sredniyZarabotokDc;
    @Inject
    private CollectionPropertyContainer<Bol1nicnyjListNacislenia> nacisleniaDc;
    @Inject
    private TextField<String> averageSampleField;
    @Inject
    private TextField<String> averageSalaryField;
    @Inject
    private TextField<String> totalField;
    @Inject
    private DateField<LocalDateTime> dataNacalaField;
    @Inject
    private DateField<LocalDateTime> dataOkoncaniaField;
    @Inject
    private TextField<BigDecimal> dnejField;
    @Inject
    private EntityComboBox<Procenty> procent11yComboBox;
    @Inject
    private TextField<BigDecimal> dnejOrganizaciiField;
    @Inject
    private EntityStates entityStates;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        if (!entityStates.isNew(getEditedEntity()))
            changeStaticValues();
    }

    @Subscribe("dataNacalaField")
    public void onDataNacalaFieldValueChange(HasValue.ValueChangeEvent<LocalDate> event) {
        setDates(daysBetween(dataNacalaField.getValue(), dataOkoncaniaField.getValue()));
    }

    @Subscribe("dataOkoncaniaField")
    public void onDataOkoncaniaFieldValueChange(HasValue.ValueChangeEvent<LocalDate> event) {
        setDates(daysBetween(dataNacalaField.getValue(), dataOkoncaniaField.getValue()));
    }

    @Subscribe("dnejField")
    public void onDnejFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        setDates(dnejField.getValue().longValue());
    }


    private void setDates(long daysBetween) {
        getEditedEntity().setDnej(new BigDecimal(daysBetween));
        getEditedEntity().setDnejZaScetSF(daysBetween > 10 ? new BigDecimal(daysBetween - 10) : BigDecimal.ZERO);
        getEditedEntity().setDnejOrganizacii(daysBetween > 10 ? new BigDecimal(10) : new BigDecimal(daysBetween));
    }


    @Subscribe("sredniyZarabotokTable.create")
    public void onSredniyZarabotokTableCreate(Action.ActionPerformedEvent event) {
        if (dataNacalaField.getValue() == null || dataOkoncaniaField.getValue() == null || procent11yComboBox.getValue() == null) {
            showNotifications("Заполните поля с датами и процент!", "", Notifications.NotificationType.WARNING);
        } else if (sredniyZarabotokDc.getItems().size() > 2) {
            showNotifications("Максимальное допустимое число 3", "", Notifications.NotificationType.ERROR);
        } else {
            Bol1nicnyjListSrednijZarabotok item = dataManager.create(Bol1nicnyjListSrednijZarabotok.class);
            item.setPart(getEditedEntity());
            sredniyZarabotokDc.getMutableItems().add(item);
        }
    }

    @Subscribe("nacisleniaTable.create")
    public void onNacisleniaTableCreate(Action.ActionPerformedEvent event) {
        if (nacisleniaDc.getItems().size() > 1) {
            showNotifications("Максимальное допустимое число 2!", "", Notifications.NotificationType.ERROR);
        } else {
            Bol1nicnyjListNacislenia item = dataManager.create(Bol1nicnyjListNacislenia.class);
            item.setPart(getEditedEntity());
            nacisleniaDc.getMutableItems().add(item);
        }
    }

    @Subscribe(id = "sredniyZarabotokDc", target = Target.DATA_CONTAINER)
    public void onSredniyZarabotokDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Bol1nicnyjListSrednijZarabotok> event) {
        LocalDateTime time = event.getItem().getPeriodRegistracii();
        if (time == null) {

        } else if (!checkMonth(time) || (time.isAfter(dataNacalaField.getValue()) || time.isEqual(dataNacalaField.getValue()))) {
            showNotifications("Выберите дату до даты начало!", "Месяца не должны совподать!", Notifications.NotificationType.ERROR);
            event.getItem().setPeriodRegistracii(null);
        } else {
            if (time.getDayOfMonth() != 1)
                event.getItem().setPeriodRegistracii(getFirstDayOfMonth(event.getItem().getPeriodRegistracii()));
            changeStaticValues();
            if (sredniyZarabotokDc.getItems().size() != 0 && event.getItem().getNormaDnej() != null && event.getItem().getRezul1tat() != null && listDifference()) {
                addNacisleniaColumn();
            }

        }
    }

    @Subscribe("procent11yComboBox")
    public void onProcent11yComboBoxValueChange(HasValue.ValueChangeEvent<Procenty> event) {
        if (sredniyZarabotokDc.getItems().size() != 0 && listDifference()) {
            addNacisleniaColumn();
        }
    }


    @Subscribe("dnejOrganizaciiField")
    public void onDnejOrganizaciiFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        if (sredniyZarabotokDc.getItems().size() != 0 && listDifference()) {
            addNacisleniaColumn();
        }
    }


    private void addNacisleniaColumn() {
        changeStaticValues();
        List<Bol1nicnyjListNacislenia> nacislenias = nacisleniaDc.getItems();
        if (procent11yComboBox.getValue() == null) {
            showNotifications("Заполните поле проценты!", "", Notifications.NotificationType.WARNING);
        } else if (new BigDecimal(averageSalaryField.getValue()).equals(BigDecimal.ZERO) || dnejOrganizaciiField.getValue() == null) {
            showNotifications("Заполните таблицу 'Средний зароботок'", "Поля с датами тоже обезятельные!", Notifications.NotificationType.WARNING);
        } else {
            for (Bol1nicnyjListNacislenia bol1nicnyjListNacislenia : nacislenias) {
                dataManager.remove(bol1nicnyjListNacislenia);
            }
            BigDecimal averageValue = new BigDecimal(averageSalaryField.getValue());
            BigDecimal percent = new BigDecimal(procent11yComboBox.getValue().getProcent());
            Bol1nicnyjListNacislenia nacislenia = dataManager.create(Bol1nicnyjListNacislenia.class);
            nacislenia.setPart(getEditedEntity());
            nacislenia.setOtrabotanoDnej(dnejOrganizaciiField.getValue());
            nacislenia.setRazmer(averageValue);
            nacislenia.setPromejutocniy(nacislenia.getOtrabotanoDnej().multiply(averageValue));
            nacislenia.setRezul1tat(nacislenia.getPromejutocniy().multiply(percent).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
            nacisleniaDc.getMutableItems().add(nacislenia);
        }
    }

    private Boolean listDifference() {
        List<Bol1nicnyjListNacislenia> first = getEditedEntity().getNacislenia();
        List<Bol1nicnyjListNacislenia> second = nacisleniaDc.getItems();
        if (first == null || first.size() != second.size()) return true;
        for (int i = 0; i < first.size(); i++) {
            if (!first.get(i).equals(second.get(i))) return true;
        }
        return false;
    }


    private long daysBetween(LocalDateTime first, LocalDateTime second) {
        if (first == null || second == null) return 0;
        long daysBetween = ChronoUnit.DAYS.between(first, second);
        if (daysBetween < 0) {
            showNotifications("Выберите дату окончания после даты начала!", "", Notifications.NotificationType.WARNING);
            dataNacalaField.setValue(null);
            dataOkoncaniaField.setValue(null);
            return 0;
        }
        return daysBetween + 1;
    }

    private boolean checkMonth(LocalDateTime time) {
        int count = 0;
        for (Bol1nicnyjListSrednijZarabotok b : sredniyZarabotokDc.getItems()) {
            count += (b.getPeriodRegistracii() != null
                && b.getPeriodRegistracii().getMonth() == time.getMonth()
                && b.getPeriodRegistracii().getYear() == time.getYear() ? 1 : 0);
        }
        return count == 1;
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        /*Сохраняет записи в Регистр разовых начислений*/
        Bol1nicnyjList bl = getEditedEntity();
        Long registerSize = dataManager.loadValue("select count(e) from Tabel1UcetaPoseshenia e " +
                "where e.aktivnost1 = true " +
                "and e.sotrudnik = :sotrudnik " +
                "and e.organizacia = :organizacia " +
                "and ((e.dataNacala >= :dateFrom and e.dataNacala <= :dateTo) " +
                "or (e.dataOkoncania >= :dateFrom and e.dataOkoncania <= :dateTo))", Long.class)
            .parameter("sotrudnik", bl.getSotrudnik())
            .parameter("organizacia", bl.getOrganizacia())
            .parameter("dateFrom", bl.getDataNacala())
            .parameter("dateTo", bl.getDataOkoncania())
            .one();
        if (!isOneTimeInMonth()) {
            showNotifications("За этот месяц уже добавлен документ!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        } else if ((entityStates.isNew(getEditedEntity()) && registerSize != 0) || (registerSize != 1)) {
            showNotifications("Вы не можете добавить, измените даты!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        }
        if (entityStates.isNew(getEditedEntity())) {
            Tabel1UcetaPoseshenia tup = dataManager.create(Tabel1UcetaPoseshenia.class);
            tup.setVidyTabelyaUceta(dataManager.load(VidyTabelyaUceta.class).id(1).one());
            tup.setAktivnost1(false);
            getEditedEntity().setProveden(false);
            setValuesToRegister(tup);
            getEditedEntity().setRegisterPosobia(tup);
        } else {
            setValuesToRegister(getEditedEntity().getRegisterPosobia());
        }

        List<Bol1nicnyjList> otpuskList = dataManager.load(Bol1nicnyjList.class)
            .query("select s from Bol1nicnyjList s where s.id = :id")
            .parameter("id", getEditedEntity().getId()).list();
        if (!otpuskList.isEmpty()) {
            List<RazovoeNacislenie> razovoeNacislenieList = dataManager.load(RazovoeNacislenie.class)
                .query("select s from RazovoeNacislenie s where s.bol1nicnyjList = :bol1nicnyjList")
                .parameter("bol1nicnyjList", getEditedEntity()).list();
            if (!razovoeNacislenieList.isEmpty())
                for (RazovoeNacislenie razovoeNacislenie : razovoeNacislenieList)
                    dataManager.remove(razovoeNacislenie);
        }

        List<RazovoeNacislenie> razovoeNacislenieList = new ArrayList<>();
        for (Bol1nicnyjListNacislenia bol1nicnyjListNacislenia : getEditedEntity().getNacislenia()) {
            RazovoeNacislenie razovoeNacislenie = dataManager.create(RazovoeNacislenie.class);
            razovoeNacislenie.setBol1nicnyjList(getEditedEntity());
//            razovoeNacislenie.setStatus();
            razovoeNacislenie.setDataNacislenia(getEditedEntity().getDataNacala());
            razovoeNacislenie.setDataOkoncania(getEditedEntity().getDataOkoncania());
            razovoeNacislenie.setDolznost1(getEditedEntity().getDolznost1());
            razovoeNacislenie.setOrganizacia(getEditedEntity().getOrganizacia());
            razovoeNacislenie.setSotrudnik(getEditedEntity().getSotrudnik());
            razovoeNacislenie.setPodrazdelenie(getEditedEntity().getPodrazdelenie());
            razovoeNacislenie.setGrafikRaboty(getEditedEntity().getGrafikRaboty());
            razovoeNacislenie.setVidRasceta(bol1nicnyjListNacislenia.getVidRasceta());
            razovoeNacislenie.setDnej(bol1nicnyjListNacislenia.getOtrabotanoDnej());
//            razovoeNacislenie.setCasov();
            razovoeNacislenie.setRazmer(bol1nicnyjListNacislenia.getRazmer());
            razovoeNacislenie.setRezul1tat(bol1nicnyjListNacislenia.getRezul1tat());
            razovoeNacislenie.setSposobOtrajenia(bol1nicnyjListNacislenia.getSposobOtrazenia());
            razovoeNacislenieList.add(razovoeNacislenie);
        }
        getEditedEntity().setRegRazovoeNacislenie(razovoeNacislenieList);
    }

    private Boolean isOneTimeInMonth() {
        return dataManager.loadValue("select count(e) from Bol1nicnyjList e " +
                "where e.organizacia = :organ and e.data between :firstDayOfMonth and :lastDayOfMonth", Long.class)
            .parameter("organ", getEditedEntity().getOrganizacia())
            .parameter("firstDayOfMonth", getEditedEntity().getData().withDayOfMonth(1))
            .parameter("lastDayOfMonth", getEditedEntity().getData().withDayOfMonth(1).plusMonths(1).minusDays(1))
            .one() == 0;
    }

    private void setValuesToRegister(Tabel1UcetaPoseshenia tup) {
        Bol1nicnyjList bl = getEditedEntity();
        tup.setNomerStroki(BigDecimal.valueOf(bl.getSotrudnik().getKod()));
        tup.setPodrazdelenie(bl.getPodrazdelenie());
        tup.setOrganizacia(bl.getOrganizacia());
        tup.setDataNacala(bl.getDataNacala());
        tup.setDataOkoncania(bl.getDataOkoncania());
        tup.setSotrudnik(bl.getSotrudnik());
        tup.setPeriod(bl.getData());
        tup.setTabel(bl.getId());
        dataManager.save(tup);
    }

    private void changeStaticValues() {
        List<Bol1nicnyjListSrednijZarabotok> list = sredniyZarabotokDc.getItems();
        averageSalaryField.setValue(averageSalary(list).toString());
        totalField.setValue(sumList(list, 1).toString());
        averageSampleField.setValue(sumList(list, 2).toString());
    }

    private BigDecimal averageSalary(List<Bol1nicnyjListSrednijZarabotok> list) {
        BigDecimal totalS = new BigDecimal(0);
        BigDecimal totalD = new BigDecimal(0);
        if (list.size() == 0) return totalS;
        for (Bol1nicnyjListSrednijZarabotok blsz : list) {
            if (blsz.getRezul1tat() == null || blsz.getNormaDnej() == null) return BigDecimal.ZERO;
            totalS = totalS.add(blsz.getRezul1tat());
            totalD = totalD.add(blsz.getNormaDnej());
        }
        return totalD.equals(BigDecimal.ZERO) ? new BigDecimal(0) : totalS.divide(totalD, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal sumList(List<Bol1nicnyjListSrednijZarabotok> list, int type) {
        BigDecimal total = new BigDecimal(0);
        for (Bol1nicnyjListSrednijZarabotok b : list) {
            if (type == 1)
                total = total.add(b.getRezul1tat() != null ? b.getRezul1tat() : BigDecimal.ZERO);
            else if (type == 2)
                total = total.add(b.getNormaDnej() != null ? b.getNormaDnej() : BigDecimal.ZERO);
        }
        return total;
    }

    private LocalDateTime getFirstDayOfMonth(LocalDateTime date) {
        return date.withDayOfMonth(1);
    }

    private void showNotifications(String caption, String description, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(description)
            .withType(type)
            .withPosition(Notifications.Position.MIDDLE_CENTER)
            .show();
    }

    /*    @Subscribe("sredniyZarabotokTable")
    public void onSredniyZarabotokTableSelection(Table.SelectionEvent<Bol1nicnyjListSrednijZarabotok> event) {
        if(sredniyZarabotokTable.getSingleSelected().getPeriodRegistracii() != null){
            Bol1nicnyjListSrednijZarabotok bLSZ = sredniyZarabotokTable.getSingleSelected();
            System.out.println(bLSZ.getPeriodRegistracii());
            LocalDateTime local = bLSZ.getPeriodRegistracii();
//            Если число даты не 1 то превращает его в 1
            if (local.getDayOfMonth() != 1) {
                String sss = local.getMonthValue() < 10? "0" + local.getMonthValue() : "" + local.getMonthValue();
                String str = "01/" + local.getMonthValue() + "/" + local.getYear();
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
                    System.out.println(str);
                    System.out.println(date);
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDateTime dateTime = LocalDateTime.parse(str, format);
                    bLSZ.setPeriodRegistracii(dateTime);
                    System.out.println(bLSZ.getPeriodRegistracii());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }*/

}
