package kg.infosystems.buhproject.screen.catalogs.statnieraspisanieprikazy;

import io.jmix.core.DataManager;
import io.jmix.core.MetadataTools;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.InputDialog;
import io.jmix.ui.app.inputdialog.InputParameter;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Dolznosti;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;
import kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij;
import kg.infosystems.buhproject.entity.catalogs.StatnieRaspisaniePrikazy;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.registers.informations.StatnoeRaspisanie;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@UiController("StatnieRaspisaniePrikazy.edit")
@UiDescriptor("statnie-raspisanie-prikazy-edit.xml")
@EditedEntityContainer("statnieRaspisaniePrikazyDc")
public class StatnieRaspisaniePrikazyEdit extends StandardEditor<StatnieRaspisaniePrikazy> {
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionLoader<PodrazdeleniaOrganizacij> podrazdeleniaOrganizacijsDl;
    @Inject
    private DataManager dataManager;
    @Inject
    private TreeTable<PodrazdeleniaOrganizacij> podrazdeleniaOrganizacijsTable;
    @Inject
    private CollectionLoader<StatnoeRaspisanie> statnoeRaspisaniesDl;
    @Inject
    private DateField periodField;
    @Inject
    private EntityPicker<Organizacii> organizasiaField;
    @Inject
    private Dialogs dialogs;
    @Inject
    private MetadataTools metadataTools;
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionContainer<StatnoeRaspisanie> statnoeRaspisaniesDc;
    HashMap<PodrazdeleniaOrganizacij, List<StatnoeRaspisanie>> states = new HashMap<>();
    @Inject
    private CollectionContainer<PodrazdeleniaOrganizacij> podrazdeleniaOrganizacijsDc;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        podrazdeleniaOrganizacijsDl.setParameter("vladelec", dataManager.create(Organizacii.class));
    }

    //добавляет данные в штатное расписание
    @Subscribe("statnoeRaspisaniesTable.add")
    public void onDetail1TableAddClick(Action.ActionPerformedEvent event) {
        if (podrazdeleniaOrganizacijsTable.getSingleSelected() != null) {
            StatnoeRaspisanie item = dataContext.create(StatnoeRaspisanie.class);
            item.setPeriod(getEditedEntity().getPeriod());
            item.setPodrazdelenie(podrazdeleniaOrganizacijsTable.getSingleSelected());
            item.setOrganizacia(getEditedEntity().getOrganizasia());
            statnoeRaspisaniesDc.getMutableItems().add(item);
        }
    }

    //    Загружает данные в штатное расписание
    @Subscribe(id = "statnoeRaspisaniesDc", target = Target.DATA_CONTAINER)
    public void onStatnoeRaspisaniesDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<StatnoeRaspisanie> event) {
        StatnoeRaspisanie sr = event.getItem();
        //Выводит сумму призаполнении двух полей
        if (sr.getBazoviyOklad() != null && sr.getCoefficentKratnosti() != null)
            sr.setSumma(sr.getBazoviyOklad().getSumma().multiply(sr.getCoefficentKratnosti()));
    }

    //Выводит подразделения этой организации
    @Subscribe("organizasiaField")
    public void onOorganizasiaFieldValueChange(HasValue.ValueChangeEvent<Organizacii> event) {
        podrazdeleniaOrganizacijsDl.setParameter("vladelec", event.getValue());
        podrazdeleniaOrganizacijsDl.load();
    }

    //диалоговое окно которое добавляет дочернее подразделение
    @Subscribe("podrazdeleniaOrganizacijsTable.createSon")
    public void onCreateSon(Action.ActionPerformedEvent event) {
        dialogs.createInputDialog(this)
            .withCaption("Добавить подразделение")
            .withParameters(
                InputParameter.stringParameter("kod").withCaption("Код"),
                InputParameter.stringParameter("naimenovanie").withCaption("Наименование")
            )
            .withActions(DialogActions.OK_CANCEL)
            .withCloseListener(closeEvent -> {
                if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                    PodrazdeleniaOrganizacij podOrganizacij = dataContext.create(PodrazdeleniaOrganizacij.class);
                    setPodrazdeleniaOrganizacijVRoditele(podOrganizacij, closeEvent.getValue("kod"),
                        closeEvent.getValue("naimenovanie"));
                    podrazdeleniaOrganizacijsDc.getMutableItems().add(podOrganizacij);
                    notifications.create()
                        .withCaption("Подразделение добавлено")
                        .withDescription("<br/><strong>Наимнование</strong> " + metadataTools.format(closeEvent.getValue("naimenovanie")) +
                            "<br/><strong>Родитель:</strong> " + metadataTools.format(podOrganizacij.getRoditel1()))
                        .withContentMode(ContentMode.HTML)
                        .show();
                }
            })
            .show();
    }

    //добавляет дочернее подразделение
    private void setPodrazdeleniaOrganizacijVRoditele(PodrazdeleniaOrganizacij podOrganizacij, String kod, String naimenovanie) {
        podOrganizacij.setVladelec(getEditedEntity().getOrganizasia());
        podOrganizacij.setKod(kod);
        podOrganizacij.setNaimenovanie(naimenovanie);
        podOrganizacij.setRoditel1(podrazdeleniaOrganizacijsTable.getSingleSelected());
    }

//    @Subscribe("periodField")
//    public void onPeriodFieldValueChange(HasValue.ValueChangeEvent event) {
//        if (controlkaPeriodField()) statnoeRaspisanieValue();
//    }


    //Если выбирает поле в списке Подразделений
    @Subscribe("podrazdeleniaOrganizacijsTable")
    public void onPodrazdeleniaOrganizacijsTableSelection(Table.SelectionEvent<PodrazdeleniaOrganizacij> event) {
        if (proverkaPoley()) return;
        if (controlkaPeriodField()) statnoeRaspisanieValue();
    }

    // Перед сохранением проверяет
    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (proverkaPoley()) event.preventCommit();
        if (!controlkaPeriodField()) event.preventCommit();
    }

    private boolean proverkaPoley() {
        // Проверка на дупликат
        if (statnoeRaspisaniesDc.getMutableItems().size() != statnoeRaspisaniesDc.getMutableItems().stream().map(StatnoeRaspisanie::getDolznost1).distinct().count()) {
            notifications.create()
                .withCaption("Имеется дупликат, поменяйте должность!")
                .withType(Notifications.NotificationType.HUMANIZED)
                .show();
            return true;
        }
        // Проверка на пустоту
        if (statnoeRaspisaniesDc.getMutableItems().stream().anyMatch(e -> e.getDolznost1() == null || e.getKolicestvoStavok() == null)) {
            notifications.create()
                .withCaption("Поля не могут быть пустыми!")
                .withType(Notifications.NotificationType.HUMANIZED)
                .show();
            return true;
        }
        // Проверка на дробное число
        if (statnoeRaspisaniesDc.getMutableItems().stream().anyMatch(e -> Double.parseDouble(e.getKolicestvoStavok().toString()) % 1 != 0)) {
            notifications.create()
                .withCaption("Поле \"Количество единиц\" не может быть дробным числом")
                .withType(Notifications.NotificationType.HUMANIZED)
                .show();
            return true;
        }
        // Проверка на 0
        if (statnoeRaspisaniesDc.getMutableItems().stream().anyMatch(e -> e.getKolicestvoStavok().toBigInteger().equals(new BigInteger(String.valueOf(0))))) {
            notifications.create()
                .withCaption("Поле \"Количество единиц\" не может быть равен 0")
                .withType(Notifications.NotificationType.HUMANIZED)
                .show();
            return true;
        }
        return false;
    }

    //Проверяет данные перед тем как выводить штатное расписание
    private boolean controlkaPeriodField() {
        if (!periodField.isEmpty()) {
            LocalDateTime localDateTime = (LocalDateTime) periodField.getValue();
//            Если число даты не 1 то превращает его в 1
            if (localDateTime.getDayOfMonth() != 1) {
                String str = String.valueOf(localDateTime.getMonthValue());
                if (localDateTime.getMonthValue() < 10) str = "0" + localDateTime.getMonthValue();
                LocalDateTime ldt = LocalDateTime.parse(localDateTime.getYear() + "-" + str + "-01T00:00:00");
                periodField.setValue(ldt);
            }
            StatnieRaspisaniePrikazy srp = dataManager.load(StatnieRaspisaniePrikazy.class)
                .query("select c from StatnieRaspisaniePrikazy c order by c.period desc").optional().orElse(null);
            StatnieRaspisaniePrikazy statnieRaspisaniePrikazy = dataManager.load(StatnieRaspisaniePrikazy.class).id(getEditedEntity()).optional().orElse(null);
//            Проверка на последнюю дату документа
            if (statnieRaspisaniePrikazy == null && srp != null && (localDateTime.isBefore(srp.getPeriod()) || localDateTime.equals(srp.getPeriod()))) {
                notifications.create()
                    .withCaption("")
                    .withDescription("Приказы можно добавлять только после последнего приказа!")
                    .withContentMode(ContentMode.HTML)
                    .show();
                return false;
            }
            //Если документ редактируется, то нельзя поменять дату
            if (statnieRaspisaniePrikazy != null) periodField.setEditable(false);
        }
        return true;
    }

    private void statnoeRaspisanieValue() {
        if (!organizasiaField.isEmpty() && !periodField.isEmpty() && podrazdeleniaOrganizacijsTable.getSingleSelected() != null) {
            PodrazdeleniaOrganizacij podrazdeleniaOrganizacij = podrazdeleniaOrganizacijsTable.getSingleSelected();
            Organizacii organizacii = organizasiaField.getValue();
            LocalDateTime localDateTime = (LocalDateTime) periodField.getValue();
            //        Загруженные данные сохраняются в словаре.
            if (!statnoeRaspisaniesDc.getMutableItems().isEmpty()) {
                PodrazdeleniaOrganizacij po = statnoeRaspisaniesDc.getMutableItems().get(0).getPodrazdelenie();
                List<StatnoeRaspisanie> statnoeRaspisanies = new ArrayList<>(statnoeRaspisaniesDc.getItems());
                states.put(po, statnoeRaspisanies);
            }
            if (states.get(podrazdeleniaOrganizacij) != null) {
                statnoeRaspisaniesDc.setItems(this.states.get(podrazdeleniaOrganizacij));
            } else {
                statnoeRaspisaniesDl.setParameter("organizacia", organizacii);
                statnoeRaspisaniesDl.setParameter("podrazdelenie", podrazdeleniaOrganizacij);
                statnoeRaspisaniesDl.setParameter("period", localDateTime);
                statnoeRaspisaniesDl.load();
            }
        }
    }

    @Subscribe("createBtn1")
    public void onCreateBtnClick(Button.ClickEvent event) {
        dialogs.createInputDialog(this)
            .withCaption("Добавить подразделение")
            .withParameters(
                InputParameter.stringParameter("kod").withCaption("Код"),
                InputParameter.stringParameter("naimenovanie").withCaption("Наименование"),
                InputParameter.bigDecimalParameter("poradok").withCaption("Порядок")
            )
            .withActions(DialogActions.OK_CANCEL)
            .withCloseListener(closeEvent -> {
                if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                    PodrazdeleniaOrganizacij podOrganizacij = dataContext.create(PodrazdeleniaOrganizacij.class);
                    setPodrazdeleniaOrganizacij(podOrganizacij, closeEvent.getValue("kod"),
                        closeEvent.getValue("naimenovanie"), closeEvent.getValue("poradok"));
                    podrazdeleniaOrganizacijsDc.getMutableItems().add(podOrganizacij);
                    notifications.create()
                        .withCaption("Подразделение добавлено")
                        .withDescription("<br/><strong>Наимнование</strong> " + metadataTools.format(closeEvent.getValue("naimenovanie")))
                        .withContentMode(ContentMode.HTML)
                        .show();
                }
            })
            .show();
    }

    private void setPodrazdeleniaOrganizacij(PodrazdeleniaOrganizacij podOrganizacij, String kod, String naimenovanie, BigDecimal poradok) {
        podOrganizacij.setVladelec(getEditedEntity().getOrganizasia());
        podOrganizacij.setKod(kod);
        podOrganizacij.setNaimenovanie(naimenovanie);
        podOrganizacij.setPoradok(poradok);
    }

/*    @Subscribe("createBtn")
    public void onCreateBtnClick(Button.ClickEvent event) {
        dialogs.createInputDialog(this)
            .withCaption("Добавить расписание")
            .withParameters(
                InputParameter.parameter("dolznosti")
                    .withField(() -> {
                        ComboBox<Dolznosti> field = uiComponents
                            .create(ComboBox.of(Dolznosti.class));
                        field.setOptionsList(dataManager.load(Dolznosti.class).all().list());
                        field.setCaption("Должность");
                        field.setWidthFull();
                        return field;
                    }),
                InputParameter.parameter("vidyNacislenij")
                    .withField(() -> {
                        ComboBox<VidyNacislenij> field = uiComponents
                            .create(ComboBox.of(VidyNacislenij.class));
                        field.setOptionsList(dataManager.load(VidyNacislenij.class).all().list());
                        field.setCaption("Вид начисления");
                        field.setWidthFull();
                        return field;
                    }),
                InputParameter.bigDecimalParameter("stavka").withCaption("Ставка")
            )
            .withActions(DialogActions.OK_CANCEL)
            .withCloseListener(closeEvent -> {
                if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                    StatnoeRaspisanie statnoeRaspisanie = dataContext.create(StatnoeRaspisanie.class);
                    setStatnoeRaspisanie(statnoeRaspisanie, closeEvent.getValue("dolznosti"), closeEvent.getValue("vidyNacislenij"), closeEvent.getValue("stavka"));
                    notifications.create()
                        .withCaption("Данные сохранены")
                        .withDescription("<strong>Дата:</strong> " + " 123456 " +
                            "<br/><strong>Значение дней:</strong> " + metadataTools.format(closeEvent.getValue("znacenieDnej")) +
                            "<br/><strong>Значение часов:</strong> " + metadataTools.format(closeEvent.getValue("znacenieCasov")) +
                            "<br/><strong>Вид дня:</strong> " + metadataTools.format(closeEvent.getValue("vidDna")))
                        .withContentMode(ContentMode.HTML)
                        .show();
                }
            })
            .show();
    }*/

    private void setStatnoeRaspisanie(StatnoeRaspisanie statnoeRaspisanie, Dolznosti dolznosti, VidyNacislenij vidyNacislenij, BigDecimal stavka) {
//        List<DoljnostnieOklady> doljnostnieOkladyList = dataManager.load(DoljnostnieOklady.class)
//            .query("select c from DoljnostnieOklady c order by c.date").list();
//        StatnieRaspisaniePrikazy srp = getEditedEntity();
//        statnoeRaspisanie.setPeriod(srp.getPeriod());
//        statnoeRaspisanie.setOrganizacia(srp.getOrganizasia());
//        statnoeRaspisanie.setPodrazdelenie(podrazdeleniaOrganizacijsTable.getSingleSelected());
//        statnoeRaspisanie.setDolznost1(dolznosti);
//        statnoeRaspisanie.setVidNacislenia(vidyNacislenij);
//        statnoeRaspisanie.setKolicestvoStavok(stavka);
//        for (DoljnostnieOklady doljnostnieOklady: doljnostnieOkladyList ){
//
//            int ret = java.sql.Date.valueOf(String.valueOf(srp.getPeriod())).compareTo(doljnostnieOklady.getDate());
//            if(ret <= 0){
//                DoljnostnieOkladyDetail1 detail1 =
//            }
//        }
    }
}
