package kg.infosystems.buhproject.screen.catalogs.grafikiraboty;

import io.jmix.core.DataManager;
import io.jmix.core.MetadataTools;
import io.jmix.core.entity.KeyValueEntity;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.UiComponents;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.InputDialog;
import io.jmix.ui.app.inputdialog.InputParameter;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty;
import kg.infosystems.buhproject.entity.enumerations.VidyDnejProizvodstvennogoKalendara;
import kg.infosystems.buhproject.entity.registers.informations.KalendariGrafikovRabot;
import kg.infosystems.buhproject.entity.registers.informations.Periodicnost1Kalendara;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.*;

@UiController("GrafikiRaboty.edit")
@UiDescriptor("grafiki-raboty-edit.xml")
@EditedEntityContainer("grafikiRabotyDc")
public class GrafikiRabotyEdit extends StandardEditor<GrafikiRaboty> {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private TextField<BigDecimal> periodVDnjahField, normaCasovZapolneniaField;
    @Autowired
    private DataContext dataContext;
    @Autowired
    private CollectionContainer<Periodicnost1Kalendara> Periodicnost1KalendaraDC;
    @Autowired
    private CollectionContainer<KalendariGrafikovRabot> KalendariGrafikovRabotDc;
    @Autowired
    private UiComponents uiComponents;
    @Autowired
    private Notifications notifications;
    @Autowired
    private GridLayout gridLayout1, gridLayout2, gridLayout3, gridLayout4, gridLayout5, gridLayout6, gridLayout7, gridLayout8, gridLayout9,
        gridLayout10, gridLayout11, gridLayout12;
    @Autowired
    private Label<String> labelYear;
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private MetadataTools metadataTools;
    @Autowired
    private ComboBox<BigDecimal> zapolnennyeGody;
    @Autowired
    private CollectionLoader<Periodicnost1Kalendara> Periodicnost1KalendaraDl;
    @Autowired
    private CollectionLoader<KalendariGrafikovRabot> KalendariGrafikovRabotDl;


    // Обновление таблицы "Периодичность" в зависимости от значения на поле zapolnennyeGody
    @Subscribe("zapolnennyeGody")
    public void onZapolnennyeGodyValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        if (event.getValue() != null) {
            BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(event.getValue()));
            Periodicnost1KalendaraDl.setParameter("god", bigDecimal1);
            Periodicnost1KalendaraDl.load();
            KalendariGrafikovRabotDl.setParameter("god", bigDecimal1);
            KalendariGrafikovRabotDl.load();
        } else {
            cistkaLoaderov();
            Calendar calendar = Calendar.getInstance();
            List<BigDecimal> bigDecimals = Objects.requireNonNull(zapolnennyeGody.getOptions()).getOptions().toList();

            int year = calendar.getWeekYear();
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(year));
            if (bigDecimals.contains(bigDecimal)) {
                bigDecimal = new BigDecimal(String.valueOf(year + 1));
                if (!bigDecimals.contains(bigDecimal)) {
                    notificationZapolnennyeGoda("Вы можете создать календарь на следующий год");
                } else {
                    notificationZapolnennyeGoda("Календарь за текущий и следующий год уже создан");
                }
            }
        }
    }

    private void notificationZapolnennyeGoda(String s) {
        notifications.create()
            .withCaption("")
            .withDescription(s)
            .withContentMode(ContentMode.HTML)
            .show();
    }

    private void cistkaLoaderov() {
        Periodicnost1KalendaraDl.setParameter("god", -1);
        Periodicnost1KalendaraDl.load();
        KalendariGrafikovRabotDl.setParameter("god", -1);
        KalendariGrafikovRabotDl.load();
    }

    // Действия до открытия экрана
    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        // Вывод заполненных годов в календаре пользователю
        List<KeyValueEntity> kvEntities = dataManager.loadValues("select c.god from informations_Periodicnost1Kalendara " +
                "c where c.grafikRaboty = :grafikiRaboty group by c.god order by c.god")
            .properties("gody")
            .parameter("grafikiRaboty", getEditedEntity())
            .list();
        List<BigDecimal> godyzapolnenia = new ArrayList<>();
        for (KeyValueEntity kvEntity : kvEntities) {
            godyzapolnenia.add(kvEntity.getValue("gody"));
        }
        zapolnennyeGody.setOptionsList(godyzapolnenia);
        cistkaLoaderov();
    }

    // Действия при нажатии кнопки Заполнить "Периодичность"
    @Subscribe("zapolnit1")
    public void onZapolnit1Click(Button.ClickEvent event) {

        periodicnost1();
    }

    // Действия при нажатии кнопки Заполнить "Данные производственного календаря"
    @Subscribe("zapolnit2")
    public void onZapolnit2Click(Button.ClickEvent event) {
        dannyeProizvedstvennogoKalendara();
    }

    private void periodicnost1() {
        if (periodVDnjahField.getValue() != null && normaCasovZapolneniaField.getValue() != null) {

            int rows = Integer.parseInt(String.valueOf(periodVDnjahField.getValue()));
            int year;
            if (zapolnennyeGody.getValue() != null) year = Integer.parseInt(String.valueOf(zapolnennyeGody.getValue()));
            else {
                Calendar calendar = Calendar.getInstance();
                List<BigDecimal> bigDecimals = Objects.requireNonNull(zapolnennyeGody.getOptions()).getOptions().toList();

                year = calendar.getWeekYear();
                BigDecimal bigDecimal = new BigDecimal(String.valueOf(year));
                if (bigDecimals.contains(bigDecimal)) {
                    bigDecimal = new BigDecimal(String.valueOf(year + 1));
                    if (!bigDecimals.contains(bigDecimal)) {
                        year += 1;
                    } else {
                        notificationZapolnennyeGoda("Вы можете заполнить только за текущий и следующий год");
                        return;
                    }
                }
            }

            Calendar calendar = new GregorianCalendar(year, Calendar.JANUARY, 1);

            List<Periodicnost1Kalendara> periodicnost1KalendaraList = new ArrayList<>(Periodicnost1KalendaraDC.getMutableItems());

            // Если периодичность по этой дате свободно
            if (periodicnost1KalendaraList.isEmpty()) {
                for (int i = 1; i <= rows; i++) {
                    Periodicnost1Kalendara periodicnost1Kalendara = dataContext.create(Periodicnost1Kalendara.class);
                    setPeriodKalendara(periodicnost1Kalendara, calendar, year);
                    calendar.add(Calendar.DAY_OF_WEEK, 1);
                    Periodicnost1KalendaraDC.getMutableItems().add(periodicnost1Kalendara);
                }
            } else {
                int size = periodicnost1KalendaraList.size();
                // Если размер следующей периодичности меньше, то удаляет ненужные
                if (rows < size) {
                    for (int i = 0; i < size - rows; i++) {
                        dataContext.remove(periodicnost1KalendaraList.get(periodicnost1KalendaraList.size() - 1));
                        Periodicnost1KalendaraDC.getMutableItems().remove(periodicnost1KalendaraList.get(periodicnost1KalendaraList.size() - 1));
                        periodicnost1KalendaraList.remove(periodicnost1KalendaraList.size() - 1);
                    }
                }
                //Изменяет существующие данные
                for (Periodicnost1Kalendara periodicnost1Kalendara : Periodicnost1KalendaraDC.getMutableItems()) {
                    setPeriodKalendara(periodicnost1Kalendara, calendar, year);
                    calendar.add(Calendar.DAY_OF_WEEK, 1);
                }
                // Если размер следующей периодичности больше, то добавляет новые
                for (int i = 1; i <= rows - size; i++) {
                    Periodicnost1Kalendara periodicnost1Kalendara = dataContext.create(Periodicnost1Kalendara.class);
                    setPeriodKalendara(periodicnost1Kalendara, calendar, year);
                    calendar.add(Calendar.DAY_OF_WEEK, 1);
                    Periodicnost1KalendaraDC.getMutableItems().add(periodicnost1Kalendara);
                }
            }
        }
    }

    private void dannyeProizvedstvennogoKalendara() {
        List<Periodicnost1Kalendara> periodicnost1Kalendaras = new ArrayList<>(Periodicnost1KalendaraDC.getMutableItems());
        if (!periodicnost1Kalendaras.isEmpty()) {

            int periodicnost1Size = periodicnost1Kalendaras.size();
            int year = periodicnost1Kalendaras.get(0).getGod().intValue();

            Calendar calendarFirst = new GregorianCalendar(year, Calendar.JANUARY, 1);
            Calendar calendarLast = new GregorianCalendar(year + 1, Calendar.JANUARY, 1);
            List<KalendariGrafikovRabot> kalendariGrafikovRabots = new ArrayList<>(KalendariGrafikovRabotDc.getMutableItems());

            // Если на этот год еще не заполнен календарь
            int indexElement = 0;
            if (kalendariGrafikovRabots.isEmpty()) {
                while (!calendarFirst.equals(calendarLast)) {
                    if (indexElement == periodicnost1Size) indexElement = 0;
                    KalendariGrafikovRabot kalendariGrafikovRabot = dataContext.create(KalendariGrafikovRabot.class);
                    setKalendariGrafikovRabot(kalendariGrafikovRabot, periodicnost1Kalendaras.get(indexElement), calendarFirst);
                    calendarFirst.add(Calendar.DAY_OF_WEEK, 1);
                    indexElement++;
                    KalendariGrafikovRabotDc.getMutableItems().add(kalendariGrafikovRabot);
                }
            } else {
                for (KalendariGrafikovRabot kalendariGrafikovRabot : kalendariGrafikovRabots) {
                    if (indexElement == periodicnost1Size) indexElement = 0;
                    setKalendariGrafikovRabot(kalendariGrafikovRabot, periodicnost1Kalendaras.get(indexElement), calendarFirst);
                    calendarFirst.add(Calendar.DAY_OF_WEEK, 1);
                    indexElement++;
                }
            }
        }
    }

    private void setPeriodKalendara(Periodicnost1Kalendara periodicnost1Kalendara, Calendar calendar, int year) {
        GrafikiRaboty grafikiRaboty = getEditedEntity();
        LocalDateTime localDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        periodicnost1Kalendara.setData(localDate);
        periodicnost1Kalendara.setCasy(normaCasovZapolneniaField.getValue());
        periodicnost1Kalendara.setGod(BigDecimal.valueOf(year));
        periodicnost1Kalendara.setGrafikRaboty(grafikiRaboty);

        switch (String.valueOf(calendar.get(Calendar.DAY_OF_WEEK))) {
            case "1" -> {
                VidyDnejProizvodstvennogoKalendara vidyDnejProizvodstvennogoKalendara = dataManager.load(VidyDnejProizvodstvennogoKalendara.class).id(3).one();
                periodicnost1Kalendara.setVidDna(vidyDnejProizvodstvennogoKalendara);
            }
            case "7" -> {
                VidyDnejProizvodstvennogoKalendara vidyDnejProizvodstvennogoKalendara1 = dataManager.load(VidyDnejProizvodstvennogoKalendara.class).id(2).one();
                periodicnost1Kalendara.setVidDna(vidyDnejProizvodstvennogoKalendara1);
            }
            default -> {
                VidyDnejProizvodstvennogoKalendara vidyDnejProizvodstvennogoKalendara2 = dataManager.load(VidyDnejProizvodstvennogoKalendara.class).id(1).one();
                periodicnost1Kalendara.setVidDna(vidyDnejProizvodstvennogoKalendara2);
            }
        }
    }

    private void setKalendariGrafikovRabot(KalendariGrafikovRabot kalendariGrafikovRabot,
                                           Periodicnost1Kalendara periodicnost1Kalendara, Calendar calendar) {
        LocalDateTime localDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        kalendariGrafikovRabot.setData(localDate);
        kalendariGrafikovRabot.setZnacenieCasov(periodicnost1Kalendara.getCasy());
        kalendariGrafikovRabot.setGod(periodicnost1Kalendara.getGod());
        kalendariGrafikovRabot.setVidDna(periodicnost1Kalendara.getVidDna());
        kalendariGrafikovRabot.setGrafikRaboty(periodicnost1Kalendara.getGrafikRaboty());

        if (periodicnost1Kalendara.getVidDna().getId() == 1) kalendariGrafikovRabot.setZnacenieDnej(BigDecimal.valueOf(1));
    }

    @Subscribe("tabSheet")
    public void onTabSheetSelectedTabChange(TabSheet.SelectedTabChangeEvent event) {
        if (event.getSelectedTab().getName().equals("tab2")) {
            checkComponents();
        }
    }

    private void checkComponents() {
        List<KalendariGrafikovRabot> kalendariGrafikovRabots = new ArrayList<>(KalendariGrafikovRabotDc.getMutableItems());
        if (!kalendariGrafikovRabots.isEmpty()) {


            int year = kalendariGrafikovRabots.get(0).getGod().intValue();
            labelYear.setValue(String.valueOf(year));

            Calendar calendar = new GregorianCalendar(year, Calendar.JANUARY, 1);
            Calendar calendarLast = new GregorianCalendar(year + 1, Calendar.JANUARY, 1);

            GridLayout gridLayout = gridLayout1;
            if (!kalendariGrafikovRabots.isEmpty()) {
                int row = 1;
                int column = 0;
                switch (String.valueOf(calendar.get(Calendar.DAY_OF_WEEK))) {
                    case "3" -> column = 1;
                    case "4" -> column = 2;
                    case "5" -> column = 3;
                    case "6" -> column = 4;
                    case "7" -> column = 5;
                    case "1" -> column = 6;
                }
                do {
                    LocalDateTime localDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    KalendariGrafikovRabot kalendariGrafikovRabot = kalendariGrafikovRabots.stream().filter(p -> p.getData().equals(localDate)).findFirst().get();
                    if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
                        switch (String.valueOf(calendar.get(Calendar.MONTH))) {
                            case "0" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout1);
                            }
                            case "1" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout2);
                            }
                            case "2" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout3);
                            }
                            case "3" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout4);
                            }
                            case "4" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout5);
                            }
                            case "5" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout6);
                            }
                            case "6" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout7);
                            }
                            case "7" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout8);
                            }
                            case "8" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout9);
                            }
                            case "9" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout10);
                            }
                            case "10" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout11);
                            }
                            case "11" -> {
                                row = 1;
                                gridLayout = newMonth(gridLayout12);
                            }
                        }
                    }

                    Button button = uiComponents.create(Button.NAME);
                    button.setAlignment(Component.Alignment.MIDDLE_CENTER);
                    button.setHeight("25px");
                    button.setStyleName("button-green");
                    button.setWidth("15px");
                    button.setAction(new BaseAction("theAction")
                        .withCaption(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)))
                        .withHandler(actionPerformedEvent ->
                            dialogs.createInputDialog(this)
                                .withCaption(String.valueOf(kalendariGrafikovRabot.getData()))
                                .withParameters(
                                    InputParameter.bigDecimalParameter("znacenieDnej").withCaption("Ставка")
                                        .withDefaultValue(kalendariGrafikovRabot.getZnacenieDnej()),
                                    InputParameter.bigDecimalParameter("znacenieCasov").withCaption("Значение часов")
                                        .withDefaultValue(kalendariGrafikovRabot.getZnacenieCasov()),
                                    InputParameter.parameter("vidDna")
                                        .withField(() -> {
                                            ComboBox<VidyDnejProizvodstvennogoKalendara> field = uiComponents
                                                .create(ComboBox.of(VidyDnejProizvodstvennogoKalendara.class));
                                            field.setOptionsList(dataManager.load(VidyDnejProizvodstvennogoKalendara.class).all().list());
                                            field.setCaption("Вид дня");
                                            field.setWidthFull();
                                            return field;
                                        })
                                )
                                .withActions(DialogActions.OK_CANCEL)
                                .withCloseListener(closeEvent -> {
                                    if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                                        kalendariGrafikovRabot.setZnacenieDnej(closeEvent.getValue("znacenieDnej"));
                                        kalendariGrafikovRabot.setZnacenieCasov(closeEvent.getValue("znacenieCasov"));
                                        kalendariGrafikovRabot.setVidDna(closeEvent.getValue("vidDna"));
                                        if (kalendariGrafikovRabot.getVidDna().getId() == 4) button.setStyleName("button-BeforeRedd");
                                        else if (kalendariGrafikovRabot.getVidDna().getId() == 5) button.setStyleName("button-redd");
                                        else if (kalendariGrafikovRabot.getVidDna().getId() == 6) button.setStyleName("button-deepskyblue");
                                        else if (kalendariGrafikovRabot.getVidDna().getId() == 7) button.setStyleName("button-royalblue");

                                        notifications.create()
                                            .withCaption("Данные сохранены")
                                            .withDescription("<strong>Дата:</strong> " + calendar.get(Calendar.DAY_OF_MONTH) +
                                                "<br/><strong>Значение дней:</strong> " + metadataTools.format(closeEvent.getValue("znacenieDnej")) +
                                                "<br/><strong>Значение часов:</strong> " + metadataTools.format(closeEvent.getValue("znacenieCasov")) +
                                                "<br/><strong>Вид дня:</strong> " + metadataTools.format(closeEvent.getValue("vidDna")))
                                            .withContentMode(ContentMode.HTML)
                                            .show();
                                    }
                                })
                                .show()));
                    if (kalendariGrafikovRabot.getVidDna().getId() == 2) button.setStyleName("button-redik");
                    else if (kalendariGrafikovRabot.getVidDna().getId() == 3) button.setStyleName("button-red");
                    else if (kalendariGrafikovRabot.getVidDna().getId() == 4) button.setStyleName("button-BeforeRedd");
                    else if (kalendariGrafikovRabot.getVidDna().getId() == 5) button.setStyleName("button-redd");
                    else if (kalendariGrafikovRabot.getVidDna().getId() == 6) button.setStyleName("button-deepskyblue");
                    else if (kalendariGrafikovRabot.getVidDna().getId() == 7) button.setStyleName("button-royalblue");
                    gridLayout.add(button, column, row);
                    if (column == 6) {
                        row++;
                        column = -1;
                    }
                    column++;
                    calendar.add(Calendar.DAY_OF_WEEK, 1);
                } while (!calendar.equals(calendarLast));
            }
        } else {
            labelYear.setValue("        ");
            gridLayout1.removeAll();
            gridLayout2.removeAll();
            gridLayout3.removeAll();
            gridLayout4.removeAll();
            gridLayout5.removeAll();
            gridLayout6.removeAll();
            gridLayout7.removeAll();
            gridLayout8.removeAll();
            gridLayout9.removeAll();
            gridLayout10.removeAll();
            gridLayout11.removeAll();
            gridLayout12.removeAll();
        }
    }


    public GridLayout newMonth(GridLayout gridLayout) {
        gridLayout.removeAll();
        gridLayout.setRows(7);
        bazovyeDannyeKalendara(gridLayout);
        return gridLayout;
    }

    private void bazovyeDannyeKalendara(GridLayout gridLayout1) {
        Label<String> label = uiComponents.create(Label.NAME);
        label.setValue("Пн");
        label.setAlignment(Component.Alignment.MIDDLE_CENTER);
        label.setHeight("10px");
        label.setWidth("20px");
        gridLayout1.add(label, 0, 0);

        Label<String> label0 = uiComponents.create(Label.NAME);
        label0.setValue("Вт");
        label0.setAlignment(Component.Alignment.MIDDLE_CENTER);
        label0.setHeight("10px");
        label0.setWidth("20px");
        gridLayout1.add(label0, 1, 0);

        Label<String> label1 = uiComponents.create(Label.NAME);
        label1.setValue("Ср");
        label1.setAlignment(Component.Alignment.MIDDLE_CENTER);
        label1.setHeight("10px");
        label1.setWidth("20px");
        gridLayout1.add(label1, 2, 0);

        Label<String> label2 = uiComponents.create(Label.NAME);
        label2.setValue("Чт");
        label2.setAlignment(Component.Alignment.MIDDLE_CENTER);
        label2.setHeight("10px");
        label2.setWidth("20px");
        gridLayout1.add(label2, 3, 0);

        Label<String> label3 = uiComponents.create(Label.NAME);
        label3.setValue("Пт");
        label3.setAlignment(Component.Alignment.MIDDLE_CENTER);
        label3.setHeight("10px");
        label3.setWidth("20px");
        gridLayout1.add(label3, 4, 0);

        Label<String> label4 = uiComponents.create(Label.NAME);
        label4.setValue("Сб");
        label4.setStyleName("sb");
        label4.setAlignment(Component.Alignment.MIDDLE_CENTER);
        label4.setHeight("10px");
        label4.setWidth("20px");
        gridLayout1.add(label4, 5, 0);

        Label<String> label5 = uiComponents.create(Label.NAME);
        label5.setValue("Вс");
        label5.setStyleName("vs");
        label5.setAlignment(Component.Alignment.MIDDLE_CENTER);
        label5.setHeight("10px");
        label5.setWidth("20px");
        gridLayout1.add(label5, 6, 0);

    }
}
