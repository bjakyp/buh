package kg.infosystems.buhproject.screen.documents.upravleniestatnymraspisaniem;

import io.jmix.core.DataManager;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.UiComponents;
import io.jmix.ui.action.Action;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.DialogOutcome;
import io.jmix.ui.app.inputdialog.InputParameter;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceLoader;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.UpravlenieStatnymRaspisaniem;
import kg.infosystems.buhproject.entity.enumerations.StatnoeRaspisanieStatus;
import kg.infosystems.buhproject.entity.parts.documents.Employees;
import kg.infosystems.buhproject.screen.documents.employees.EmployeesEdit;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@UiController("UpravlenieStatnymRaspisaniem.edit")
@UiDescriptor("upravlenie-statnym-raspisaniem-edit.xml")
@EditedEntityContainer("upravlenieStatnymRaspisaniemDc")
public class UpravlenieStatnymRaspisaniemEdit extends StandardEditor<UpravlenieStatnymRaspisaniem> {
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionPropertyContainer<Employees> employeesDc;
    @Inject
    private ComboBox<Integer> periodField;

    @Inject
    private Table<Employees> employeesTable;
    @Inject
    private Dialogs dialogs;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private CssLayout cssLayout1;
    List<String> componentId = new ArrayList<>();
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private InstanceLoader<UpravlenieStatnymRaspisaniem> upravlenieStatnymRaspisaniemDl;


    @Subscribe
    public void onInit(InitEvent event) {
        List<Integer> years = new ArrayList<>();
        Year thisYear = Year.now();
        years.add(thisYear.getValue());
        periodField.setOptionsList(years);
//        setGridLayout();
    }

    @Subscribe("tabSheet")
    public void onTabSheetSelectedTabChange(TabSheet.SelectedTabChangeEvent event) {
        if (event.getSelectedTab().getName().equals("tab2")) {
            if( !this.componentId.isEmpty())
                for(String id : this.componentId)    cssLayout1.remove(Objects.requireNonNull(cssLayout1.getComponent(id)));
            this.componentId.clear();
            tablisaDc();
        }
    }

    private void tablisaDc() {
        if(getEditedEntity().getEmployees() == null) return;
        for (Employees employee : getEditedEntity().getEmployees()) {
            Label<String> fullName = uiComponents.create(Label.NAME);
            fullName.setId(employee.getFullname() + "fullName");
            componentId.add(fullName.getId());
            fullName.setValue(employee.getFullname() == null ? "" : employee.getFullname());
            fullName.setStyleName("label-1");
            cssLayout1.add(fullName);


            Label<String> podrazdelenie = uiComponents.create(Label.NAME);
            podrazdelenie.setId(employee.getFullname() + "podrazdelenie");
            componentId.add(podrazdelenie.getId());
            podrazdelenie.setValue(employee.getPodrazdelenie() == null ? "" : employee.getPodrazdelenie().getNaimenovanie());
            podrazdelenie.setStyleName("label-1");
            cssLayout1.add(podrazdelenie);

            Label<String> stavka = uiComponents.create(Label.NAME);
            stavka.setId(employee.getFullname() + "stavka");
            componentId.add(stavka.getId());
            stavka.setValue(employee.getStavka() == null ? "" :  employee.getStavka().toString());
            stavka.setStyleName("");
            cssLayout1.add(stavka);

            Label<String> doljnostnoiOklad = uiComponents.create(Label.NAME);
            doljnostnoiOklad.setId(employee.getFullname() + "doljnostnoiOklad");
            componentId.add(doljnostnoiOklad.getId());
            doljnostnoiOklad.setValue(employee.getDoljnostnoyOklad() == null ? "" : employee.getDoljnostnoyOklad().toString());
            doljnostnoiOklad.setStyleName("");
            cssLayout1.add(doljnostnoiOklad);

            Label<String> vyslugaLet = uiComponents.create(Label.NAME);
            vyslugaLet.setId(employee.getFullname() + "vyslugaLet");
            componentId.add(vyslugaLet.getId());
            vyslugaLet.setValue(employee.getZaVyslugiLet() == null ? "" : employee.getZaVyslugiLet().toString());
            vyslugaLet.setStyleName("");
            cssLayout1.add(vyslugaLet);

            Label<String> premia = uiComponents.create(Label.NAME);
            premia.setId(employee.getFullname() + "premia");
            componentId.add(premia.getId());
            premia.setValue(employee.getPremia()== null ? "" : employee.getPremia().toString());
            premia.setStyleName("");
            cssLayout1.add(premia);

            Label<String> sekretnost1 = uiComponents.create(Label.NAME);
            sekretnost1.setId(employee.getFullname() + "sekretnost1");
            componentId.add(sekretnost1.getId());
            sekretnost1.setValue(employee.getSecretnost1() == null ? "" : employee.getSecretnost1().toString());
            sekretnost1.setStyleName("");
            cssLayout1.add(sekretnost1);

            Label<String> klassnyiCin = uiComponents.create(Label.NAME);
            klassnyiCin.setId(employee.getFullname() + "klassnyiCin");
            componentId.add(klassnyiCin.getId());
            klassnyiCin.setValue(employee.getKlasnyiChin() == null ? "" : employee.getKlasnyiChin().toString());
            klassnyiCin.setStyleName("");
            cssLayout1.add(klassnyiCin);

            Label<String> otpusknoi = uiComponents.create(Label.NAME);
            otpusknoi.setId(employee.getFullname() + "otpusknoi");
            componentId.add(otpusknoi.getId());
            otpusknoi.setValue(employee.getOtpusknoy() == null ? "" : employee.getOtpusknoy().toString());
            otpusknoi.setStyleName("");
            cssLayout1.add(otpusknoi);

            Label<String> fotZaGodBezSFKR = uiComponents.create(Label.NAME);
            fotZaGodBezSFKR.setId(employee.getFullname() + "fotZaGodBezSFKR");
            componentId.add(fotZaGodBezSFKR.getId());
            fotZaGodBezSFKR.setValue(employee.getGodovoyFOTzaVychetomSFKR() == null ? "" : employee.getGodovoyFOTzaVychetomSFKR().toString());
            fotZaGodBezSFKR.setStyleName("");
            cssLayout1.add(fotZaGodBezSFKR);

            Label<String> fotZaMesac = uiComponents.create(Label.NAME);
            fotZaMesac.setId(employee.getFullname() + "fotZaMesac");
            componentId.add(fotZaMesac.getId());
            fotZaMesac.setValue(employee.getVsegoZaFOTzaMesyac() == null ? "" : employee.getVsegoZaFOTzaMesyac().toString());
            fotZaMesac.setStyleName("");
            cssLayout1.add(fotZaMesac);

            Label<String> fotZaGod = uiComponents.create(Label.NAME);
            fotZaGod.setId(employee.getFullname() + "fotZaGod");
            componentId.add(fotZaGod.getId());
            fotZaGod.setValue(employee.getGodovoyFOT() == null ? "" : employee.getGodovoyFOT().toString());
            fotZaGod.setStyleName("");
            cssLayout1.add(fotZaGod);

            Label<String> primecania = uiComponents.create(Label.NAME);
            primecania.setId(employee.getFullname() + "primecania");
            componentId.add(primecania.getId());
            primecania.setValue(employee.getPrimechanie() == null ? "" : employee.getPrimechanie().toString());
            primecania.setStyleName("");
            cssLayout1.add(primecania);

            Label<String> pustaa = uiComponents.create(Label.NAME);
            pustaa.setId(employee.getFullname() + "pustaa");
            componentId.add(pustaa.getId());
            pustaa.setValue(" ");
            pustaa.setStyleName("");
            cssLayout1.add(pustaa);

            Label<String> doljnost1 = uiComponents.create(Label.NAME);
            doljnost1.setId(employee.getFullname() + "doljnost1");
            componentId.add(doljnost1.getId());
            doljnost1.setValue(employee.getDoljnost() == null ? "" : employee.getDoljnost().getNaimenovanie());
            doljnost1.setStyleName("");
            cssLayout1.add(doljnost1);

            Label<String> koefKratnosti = uiComponents.create(Label.NAME);
            koefKratnosti.setId(employee.getFullname() + "koefKratnosti");
            componentId.add(koefKratnosti.getId());
            koefKratnosti.setValue(employee.getKoefficentKratnosti() == null ? "" : employee.getKoefficentKratnosti().toString());
            koefKratnosti.setStyleName("");
            cssLayout1.add(koefKratnosti);

            Label<String> pustaya = uiComponents.create(Label.NAME);
            pustaya.setId(employee.getFullname() + "pustaya");
            componentId.add(pustaya.getId());
            pustaya.setValue(" ");
            pustaya.setStyleName("");
            cssLayout1.add(pustaya);

            Label<String> nadbavkaZaBysokogor1e = uiComponents.create(Label.NAME);
            nadbavkaZaBysokogor1e.setId(employee.getFullname() + "nadbavkaZaBysokogor1e");
            componentId.add(nadbavkaZaBysokogor1e.getId());
            nadbavkaZaBysokogor1e.setValue(employee.getNadbavkaZaVysokogorie() == null ? "" :employee.getNadbavkaZaVysokogorie().toString());
            nadbavkaZaBysokogor1e.setStyleName("");
            cssLayout1.add(nadbavkaZaBysokogor1e);

            Label<String> vrednost1 = uiComponents.create(Label.NAME);
            vrednost1.setId(employee.getFullname() + "vrednost1");
            componentId.add(vrednost1.getId());
            vrednost1.setValue(employee.getVrednost1() == null ? "" :employee.getVrednost1().toString());
            vrednost1.setStyleName("");
            cssLayout1.add(vrednost1);

            Label<String> rayonnyiKoef = uiComponents.create(Label.NAME);
            rayonnyiKoef.setId(employee.getFullname() + "rayonnyiKoef");
            componentId.add(rayonnyiKoef.getId());
            rayonnyiKoef.setValue(employee.getRayonniyKoefficent() == null ? "" :employee.getRayonniyKoefficent().toString());
            rayonnyiKoef.setStyleName("");
            cssLayout1.add(rayonnyiKoef);

            Label<String> ucenaaStepen1 = uiComponents.create(Label.NAME);
            ucenaaStepen1.setId(employee.getFullname() + "ucenaaStepen1");
            componentId.add(ucenaaStepen1.getId());
            ucenaaStepen1.setValue(employee.getUchenayaStepen() == null ? "" :employee.getUchenayaStepen().toString());
            ucenaaStepen1.setStyleName("");
            cssLayout1.add(ucenaaStepen1);

            Label<String> pustaya1 = uiComponents.create(Label.NAME);
            pustaya1.setId(employee.getFullname() + "pustaya1");
            componentId.add(pustaya1.getId());
            pustaya1.setValue(" ");
            pustaya1.setStyleName("");
            cssLayout1.add(pustaya1);

            Label<String> pustaya2 = uiComponents.create(Label.NAME);
            pustaya2.setId(employee.getFullname() + "pustaya2");
            componentId.add(pustaya2.getId());
            pustaya2.setValue(" ");
            pustaya2.setStyleName("");
            cssLayout1.add(pustaya2);

            Label<String> pustaya3 = uiComponents.create(Label.NAME);
            pustaya3.setId(employee.getFullname() + "pustaya3");
            componentId.add(pustaya3.getId());
            pustaya3.setValue(" ");
            pustaya3.setStyleName("");
            cssLayout1.add(pustaya3);

            Label<String> pustaya4 = uiComponents.create(Label.NAME);
            pustaya4.setId(employee.getFullname() + "pustaya4");
            componentId.add(pustaya4.getId());
            pustaya4.setValue(" ");
            pustaya4.setStyleName("");
            cssLayout1.add(pustaya4);

            Label<String> pustaya5 = uiComponents.create(Label.NAME);
            pustaya5.setId(employee.getFullname() + "pustaya5");
            componentId.add(pustaya5.getId());
            pustaya5.setValue(" ");
            pustaya5.setStyleName("");
            cssLayout1.add(pustaya5);
        }
    }


    @Subscribe
    protected void onInitEntity(InitEntityEvent<UpravlenieStatnymRaspisaniem> event) {
        UpravlenieStatnymRaspisaniem usr = event.getEntity();
        if (usr.getStatus() == null) {
            usr.setStatus(dataManager.loadValue("select srs from StatnoeRaspisanieStatus srs " +
                "where srs.id = 1", StatnoeRaspisanieStatus.class).one());
        }
    }

    @Subscribe("employeesTable.edit")
    public void onReadOnlyCustomersTableEdit(Action.ActionPerformedEvent event) {
        screenBuilders.editor(Employees.class, this)
            .editEntity(employeesTable.getSingleSelected())
            .withScreenClass(EmployeesEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    upravlenieStatnymRaspisaniemDl.load();
                }
            })
            .show();
    }

    @Subscribe("employeesTable.create")
    public void onReadOnlyCustomersTableCreate(Action.ActionPerformedEvent event) {
        Employees currEmployee = dataManager.create(Employees.class);
        currEmployee.setUpravlenieStatnymRaspisaniem(getEditedEntity());
        screenBuilders.editor(Employees.class, this)
            .editEntity(currEmployee)
            .withScreenClass(EmployeesEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    upravlenieStatnymRaspisaniemDl.load();
                }
            })
            .show();
    }

    @Subscribe("employeesTable.bulkEdit")
    public void onEmployeesTableBulkEdit(Action.ActionPerformedEvent event) {
        Employees currEmployee = employeesTable.getSingleSelected();
        BigDecimal doljnosnoyOklad = currEmployee.getDoljnostnoyOklad();
        if (doljnosnoyOklad == null) {
            notifications.create().withType(Notifications.NotificationType.ERROR).withCaption("Заполните поле должностной оклад").show();
            return;
        }
        dialogs.createInputDialog(this)
            .withCaption("Множественное редактирование")
            .withParameters(
                InputParameter.bigDecimalParameter("stavka")
                    .withDefaultValue(currEmployee.getStavka())
                    .withCaption("Ставка"),
                InputParameter.bigDecimalParameter("zaVyslugiLet")
                    .withDefaultValue(currEmployee.getZaVyslugiLetPercent())
                    .withCaption("За выслугу лет (%)"),
                InputParameter.bigDecimalParameter("nadbavkaZaVysokogorie")
                    .withDefaultValue(currEmployee.getNadbavkaZaVysokogoriePercent())
                    .withCaption("Надбавка за высокогорье и отдаленных зона (%)"),
                InputParameter.bigDecimalParameter("nadbavkaZaSlojnost1")
                    .withCaption("Надбавка за сложность")
                    .withDefaultValue(currEmployee.getNadbavkaZaSlojnost1()),
                InputParameter.bigDecimalParameter("klasnyiChin")
                    .withDefaultValue(currEmployee.getKlasnyiChin())
                    .withCaption("Классный чин"),
                InputParameter.bigDecimalParameter("uchenayaStepen1")
                    .withDefaultValue(currEmployee.getUchenayaStepen())
                    .withCaption("Ученая степень"),
                InputParameter.bigDecimalParameter("sekretnost1")
                    .withDefaultValue(currEmployee.getSecretnost1())
                    .withCaption("Секретность"),
                InputParameter.bigDecimalParameter("inyeNadbavki")
                    .withDefaultValue(currEmployee.getInyeNadbavki())
                    .withCaption("Иные надбавки"),
                InputParameter.bigDecimalParameter("rayonniyKoefficent")
                    .withCaption("Районный коэффицент")
                    .withDefaultValue(currEmployee.getRayonniyKoefficent()),
                InputParameter.bigDecimalParameter("vrednost1")
                    .withCaption("Вредность")
                    .withDefaultValue(currEmployee.getVrednost1()),
                InputParameter.bigDecimalParameter("pitanie")
                    .withCaption("Питание")
                    .withDefaultValue(currEmployee.getPitanie()),
                InputParameter.bigDecimalParameter("proezd")
                    .withCaption("Проезд")
                    .withDefaultValue(currEmployee.getProezd()),
                InputParameter.bigDecimalParameter("zarplata13")
                    .withCaption("13-заработная плата")
                    .withDefaultValue(currEmployee.getZarplata13()),
                InputParameter.bigDecimalParameter("otpusknoy")
                    .withDefaultValue(currEmployee.getOtpusknoy())
                    .withCaption("Отпускной"),
                InputParameter.bigDecimalParameter("lechebnoePosobieKotpusku")
                    .withDefaultValue(currEmployee.getLechebnoePosobieKOtpusku())
                    .withCaption("Лечебное пособия к отпуску"),
                InputParameter.bigDecimalParameter("premia")
                    .withDefaultValue(currEmployee.getPremia())
                    .withCaption("Премия"),
                InputParameter.bigDecimalParameter("otchislenieSFKR")
                    .withDefaultValue(currEmployee.getOtchislenieSFKR())
                    .withCaption("Отчисление в СФКР"),
                InputParameter.bigDecimalParameter("godovoyFOTzaVychetomSFKR")
                    .withDefaultValue(currEmployee.getGodovoyFOTzaVychetomSFKR())
                    .withCaption("Годовой ФОТ за вычетом СФКР"),
                InputParameter.bigDecimalParameter("primechanie")
                    .withDefaultValue(currEmployee.getPrimechanie())
                    .withCaption("Примечание"),
                InputParameter.bigDecimalParameter("otchislenieVSocFond")
                    .withCaption("Отчисления в соцфонд")
                    .withDefaultValue(currEmployee.getOtchislenieVSocFond())
            )
            .withCaption("Должностной оклад - " + doljnosnoyOklad)
            .withActions(DialogActions.OK_CANCEL)
            .withCloseListener(closeEvent -> {
                BigDecimal zaVyslugiLet = closeEvent.getValue("zaVyslugiLet");
                BigDecimal nadbavkaZaVysokogorie = closeEvent.getValue("nadbavkaZaVysokogorie");
                nadbavkaZaVysokogorie = nadbavkaZaVysokogorie == null ? BigDecimal.ZERO : nadbavkaZaVysokogorie;
                zaVyslugiLet = zaVyslugiLet == null ? BigDecimal.ZERO : zaVyslugiLet;
                if (check(zaVyslugiLet, new BigDecimal(100), new BigDecimal(50)))
                    notifications.create()
                        .withCaption("% не совпадает").withType(Notifications.NotificationType.ERROR).show();
                else if (check(nadbavkaZaVysokogorie, new BigDecimal(100), new BigDecimal(25)))
                    notifications.create()
                        .withCaption("% не совпадает").withType(Notifications.NotificationType.ERROR).show();
                else if (closeEvent.closedWith(DialogOutcome.OK)) {
                    currEmployee.setStavka(closeEvent.getValue("stavka"));
                    currEmployee.setZaVyslugiLet(percentage(doljnosnoyOklad, zaVyslugiLet));
                    currEmployee.setZaVyslugiLetPercent(zaVyslugiLet);
                    currEmployee.setNadbavkaZaSlojnost1(closeEvent.getValue("nadbavkaZaSlojnost1"));
                    currEmployee.setKlasnyiChin(closeEvent.getValue("klasnyiChin"));
                    currEmployee.setNadbavkaZaVysokogorie(percentage(doljnosnoyOklad, nadbavkaZaVysokogorie));
                    currEmployee.setNadbavkaZaVysokogoriePercent(nadbavkaZaVysokogorie);
                    currEmployee.setRayonniyKoefficent(closeEvent.getValue("rayonniyKoefficent"));
                    currEmployee.setVrednost1(closeEvent.getValue("vrednost1"));
                    currEmployee.setPitanie(closeEvent.getValue("pitanie"));
                    currEmployee.setProezd(closeEvent.getValue("proezd"));
                    currEmployee.setZarplata13(closeEvent.getValue("zarplata13"));
                    currEmployee.setUchenayaStepen(closeEvent.getValue("uchenayaStepen1"));
                    currEmployee.setSecretnost1(closeEvent.getValue("sekretnost1"));
                    currEmployee.setInyeNadbavki(closeEvent.getValue("inyeNadbavki"));
                    currEmployee.setOtpusknoy(closeEvent.getValue("otpusknoy"));
                    currEmployee.setLechebnoePosobieKOtpusku(closeEvent.getValue("lechebnoePosobieKotpusku"));
                    currEmployee.setPremia(closeEvent.getValue("premia"));
                    currEmployee.setOtchislenieSFKR(closeEvent.getValue("otchislenieSFKR"));
                    currEmployee.setGodovoyFOTzaVychetomSFKR(closeEvent.getValue("godovoyFOTzaVychetomSFKR"));
                    currEmployee.setPrimechanie(closeEvent.getValue("primechanie"));
                    currEmployee.setOtchislenieVSocFond(closeEvent.getValue("otchislenieVSocFond"));

                    BigDecimal fondOplatyTruda = BigDecimal.ZERO;
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getDoljnostnoyOklad()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getZaVyslugiLet()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getKlasnyiChin()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getNadbavkaZaVysokogorie()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getUchenayaStepen()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getSecretnost1()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getInyeNadbavki()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getRayonniyKoefficent()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getVrednost1()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getPitanie()));
                    fondOplatyTruda = fondOplatyTruda.add(checkAndAdd(currEmployee.getProezd()));
                    currEmployee.setVsegoZaFOTzaMesyac(fondOplatyTruda);
                    BigDecimal fondOplatyTrudaZaGod = fondOplatyTruda.multiply(new BigDecimal(12));
                    fondOplatyTrudaZaGod = fondOplatyTrudaZaGod.add(checkAndAdd(currEmployee.getOtpusknoy()));
                    fondOplatyTrudaZaGod = fondOplatyTrudaZaGod.add(checkAndAdd(currEmployee.getLechebnoePosobieKOtpusku()));
                    fondOplatyTrudaZaGod = fondOplatyTrudaZaGod.add(checkAndAdd(currEmployee.getZarplata13()));
                    currEmployee.setGodovoyFOT(fondOplatyTrudaZaGod);

                    dataManager.save(currEmployee);
                    notifications.create()
                        .withCaption("Успешно добавлен!").withType(Notifications.NotificationType.TRAY).show();
                }
            })
            .show();

    }

    private BigDecimal checkAndAdd(BigDecimal curr) {
        return curr == null ? BigDecimal.ZERO : curr;
    }

    private BigDecimal percentage(BigDecimal summa, BigDecimal percent) {
        summa = summa.multiply(percent);
        return summa.divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
    }

    private boolean check(BigDecimal curr, BigDecimal limit, BigDecimal min) {
        return curr.compareTo(min) < 0 || curr.compareTo(limit) > 0;
    }

}
