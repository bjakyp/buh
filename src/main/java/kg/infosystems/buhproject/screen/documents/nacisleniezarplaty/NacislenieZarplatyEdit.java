package kg.infosystems.buhproject.screen.documents.nacisleniezarplaty;

import io.jmix.core.DataManager;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceLoader;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;
import kg.infosystems.buhproject.entity.compensations.KategoriaRabotnikov;
import kg.infosystems.buhproject.entity.documents.DocumentStavki;
import kg.infosystems.buhproject.entity.documents.NacislenieZarplaty;
import kg.infosystems.buhproject.entity.documents.NacisleniyaIUderjaniya;
import kg.infosystems.buhproject.entity.documents.StavkiStrahovyhVznosov;
import kg.infosystems.buhproject.entity.parts.documents.NacisleniaNacisleniaIUderjania;
import kg.infosystems.buhproject.entity.parts.documents.RascetnyjPokazatel1;
import kg.infosystems.buhproject.entity.parts.documents.UderjaniaNacisleniaIUderjania;
import kg.infosystems.buhproject.entity.registers.informations.*;
import kg.infosystems.buhproject.screen.documents.NacisleniyaIUderjaniyaEdit;
import kg.infosystems.buhproject.screen.documents.UderjaniaNacisleniaIUderjaniaEdit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@UiController("NacislenieZarplaty.edit")
@UiDescriptor("nacislenie-zarplaty-edit.xml")
@EditedEntityContainer("nacislenieZarplatyDc")
public class NacislenieZarplatyEdit extends StandardEditor<NacislenieZarplaty> {
    private static final Logger log = LoggerFactory.getLogger(NacislenieZarplatyEdit.class);
    @Inject
    private DataContext dataContext;
    @Inject
    private DateField<LocalDateTime> dataField;
    @Inject
    private EntityPicker<Organizacii> organizaciaField;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;
    @Inject
    private InstanceLoader<NacislenieZarplaty> nacislenieZarplatyDl;
    @Inject
    private Dialogs dialogs;
    @Inject
    private CollectionPropertyContainer<NacisleniyaIUderjaniya> nacisleniaIUderjaniaDc;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Table<NacisleniyaIUderjaniya> nacisleniaIUderjaniasTable;
    @Inject
    private CollectionContainer<NacisleniaNacisleniaIUderjania> nacisleniaDc;
    @Inject
    private Table<NacisleniyaIUderjaniya> nacisleniaIUderjaniasTable2;

    @Subscribe("tabSheet")
    protected void onTabSheetSelectedTabChange(TabSheet.SelectedTabChangeEvent event) {
        if (event.getSelectedTab().getName().equals("tab2")) {
            List<NacisleniaNacisleniaIUderjania> nacisleniaNIUList = new ArrayList<>();
            for (NacisleniyaIUderjaniya nacisleniyaIUderjaniya : nacisleniaIUderjaniaDc.getMutableItems())
                nacisleniaNIUList.addAll(nacisleniyaIUderjaniya.getNacislenia());
            nacisleniaDc.setItems(nacisleniaNIUList);
        }
    }

    @Subscribe("nacisleniaIUderjaniasTable.create")
    public void onReadOnlyCustomersTableCreate(Action.ActionPerformedEvent event) {
        NacisleniyaIUderjaniya nacisleniaIUderjania = dataManager.create(NacisleniyaIUderjaniya.class);
        nacisleniaIUderjania.setNacislenieZarplaty(getEditedEntity());
        screenBuilders.editor(NacisleniyaIUderjaniya.class, this)
            .editEntity(nacisleniaIUderjania)
            .withScreenClass(NacisleniyaIUderjaniyaEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    nacislenieZarplatyDl.load();
                }
            })
            .show();
    }

    @Subscribe("nacisleniaIUderjaniasTable.edit")
    public void onReadOnlyCustomersTableEdit(Action.ActionPerformedEvent event) {
        screenBuilders.editor(NacisleniyaIUderjaniya.class, this)
            .editEntity(nacisleniaIUderjaniasTable.getSingleSelected())
            .withScreenClass(NacisleniyaIUderjaniyaEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT))
                    nacislenieZarplatyDl.load();
            })
            .show();
    }


    @Subscribe("dataField")
    public void onDataFieldValueChange(HasValue.ValueChangeEvent<LocalDateTime> event) {
        if (Objects.requireNonNull(event.getValue()).getDayOfMonth() != 1)
            dataField.setValue(getData(event.getValue(), true));
    }

    private LocalDateTime getData(LocalDateTime localDateTime, boolean b) {
        assert localDateTime != null;
        int year = localDateTime.getYear();
        int month = b ? localDateTime.getMonthValue() : localDateTime.getMonthValue() + 1;
        String stringDate = "1/" + month + "/" + year;
        LocalDateTime ldt = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
            ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        } catch (ParseException e) {
            log.info(String.valueOf(e));
        }
        return ldt;
    }

    @Subscribe("zapolnit1")
    public void onZapolnit1Click(Button.ClickEvent event) {
        if (dataField.getValue() != null && organizaciaField.getValue() != null)
            if (nacisleniaIUderjaniaDc.getMutableItems().size() != 0)
                dialogs.createOptionDialog()
                    .withCaption("")
                    .withMessage("Список для данной организации перезаполнится! Продолжить?")
                    .withActions(
                        new DialogAction(DialogAction.Type.OK)
                            .withHandler(e -> zapolnit1()),
                        new DialogAction(DialogAction.Type.CANCEL))
                    .show();
            else
                zapolnit1();
        else
            notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption("Заполните поля!")
                .withDescription("Заполните поля Организцаия и Период")
                .show();
    }

    private void zapolnit1() {
        if (!nacisleniaIUderjaniaDc.getMutableItems().isEmpty())
            for (NacisleniyaIUderjaniya nacisleniyaIUderjaniya : nacisleniaIUderjaniaDc.getMutableItems())
                dataManager.remove(nacisleniyaIUderjaniya);

        LocalDateTime ldt1Mesyas = Objects.requireNonNull(dataField.getValue());
        LocalDateTime ldt2Mesyas = getData(dataField.getValue(), false);
        Organizacii organizacia = organizaciaField.getValue();


        List<Sotrudniki> regSotrudnikiList = dataManager.load(Sotrudniki.class)
            .query("select s from informations_Sotrudniki s where " +
                "s.organizacia = :organizacia and s.period <:period1 and s.aktivnost1 = true")
            .parameter("organizacia", organizacia)
            .parameter("period1", ldt1Mesyas)
            .fetchPlan("sotrudniki-fetch-plan").list();

        Set<kg.infosystems.buhproject.entity.catalogs.Sotrudniki> vseRabotniki = new HashSet<>();

        for (Sotrudniki sotrudniki : regSotrudnikiList)
            vseRabotniki.add(sotrudniki.getSotrudnik());
        Set<kg.infosystems.buhproject.entity.catalogs.Sotrudniki> vseRabotniki1 = new HashSet<>(vseRabotniki);
        for (kg.infosystems.buhproject.entity.catalogs.Sotrudniki rabotnik : vseRabotniki) {
            List<Sotrudniki> registerSotrudnikiList = dataManager.load(Sotrudniki.class)
                .query("select s from informations_Sotrudniki s where " +
                    "s.organizacia = :organizacia and s.period < :period1 and " +
                    "s.sotrudnik = :sotrudnik and s.aktivnost1 = true order by s.period desc")
                .parameter("organizacia", organizacia)
                .parameter("period1", ldt1Mesyas)
                .parameter("sotrudnik", rabotnik)
                .fetchPlan("sotrudniki-fetch-plan").list();
            if (!registerSotrudnikiList.isEmpty() && registerSotrudnikiList.get(0).getVidSobytia().getId() == 3)
                vseRabotniki1.remove(rabotnik);
        }

        regSotrudnikiList.clear();
        regSotrudnikiList = dataManager.load(Sotrudniki.class)
            .query("select s from informations_Sotrudniki s where " +
                "s.organizacia = :organizacia and s.period >= :period1 and s.period < :period2 and s.aktivnost1 = true")
            .parameter("organizacia", organizacia)
            .parameter("period1", ldt1Mesyas)
            .parameter("period2", ldt2Mesyas)
            .fetchPlan("sotrudniki-fetch-plan").list();

        for (Sotrudniki sotrudniki : regSotrudnikiList)
            vseRabotniki1.add(sotrudniki.getSotrudnik());


        List<NacisleniyaIUderjaniya> niuList = new ArrayList<>();
        for (kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik : vseRabotniki1) {

            NacisleniyaIUderjaniya niu = dataContext.create(NacisleniyaIUderjaniya.class);
            niu.setNomer(sotrudnik.getKod().toString());
            niu.setNacislenieZarplaty(getEditedEntity());
            niu.setSotrudnik(sotrudnik);

            List<PlanovyeNacisleniaOkoncanie> planovyeNacisleniaOkoncanieList =
                dataManager.load(PlanovyeNacisleniaOkoncanie.class)
                    .query("select s from informations_PlanovyeNacisleniaOkoncanie s where s.organizacia " +
                        "= :organizacia and s.period >= :period1 and s.period < :period2 and s.sotrudnik = :sotrudnik")
                    .parameter("organizacia", organizacia)
                    .parameter("period1", ldt1Mesyas)
                    .parameter("period2", ldt2Mesyas)
                    .parameter("sotrudnik", sotrudnik).list();

            List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacaloList =
                dataManager.load(PlanovyeNacisleniaNacalo.class)
                    .query("select s from informations_PlanovyeNacisleniaNacalo s where s.organizacia " +
                        "= :organizacia and s.sotrudnik = :sotrudnik")
                    .parameter("organizacia", organizacia)
                    .parameter("sotrudnik", sotrudnik).list();

            List<RazovoeNacislenie> razovoeNacislenieList = dataManager.load(RazovoeNacislenie.class)
                .query("select s from RazovoeNacislenie s where s.organizacia = :organizacia " +
                    "and s.sotrudnik = :sotrudnik " +
                    "and (s.dataNacislenia >= :data1 and s.dataNacislenia < :data2) " +
                    "or (s.dataOkoncania >= :data3 and s.dataOkoncania < :data4)")
                .parameter("organizacia", organizacia)
                .parameter("sotrudnik", sotrudnik)
                .parameter("data1", ldt1Mesyas)
                .parameter("data2", ldt2Mesyas)
                .parameter("data3", ldt1Mesyas)
                .parameter("data4", ldt2Mesyas)
                .list();

            List<NacisleniaNacisleniaIUderjania> nacisleniaNacisleniaIUderjanias =
                getNacisleniaSecond(planovyeNacisleniaOkoncanieList, niu, ldt1Mesyas, ldt2Mesyas);
            nacisleniaNacisleniaIUderjanias.addAll(getNacislenia(planovyeNacisleniaNacaloList, niu, ldt1Mesyas, ldt2Mesyas));
            nacisleniaNacisleniaIUderjanias.addAll(getRazovyeNacislenia(razovoeNacislenieList, niu, ldt1Mesyas, ldt2Mesyas));

            BigDecimal rezultat = BigDecimal.valueOf(0);
            BigDecimal oblagaetsaSV = BigDecimal.valueOf(0);
            BigDecimal oblagaetsaPN = BigDecimal.valueOf(0);
            LocalDateTime dataNacaloooo = ldt1Mesyas;
            LocalDateTime dataOkoncanie = ldt2Mesyas;
            BigDecimal normaDnej = new BigDecimal(0);
            BigDecimal otrabotanoDnej = new BigDecimal(0);

            if (nacisleniaNacisleniaIUderjanias.size() > 0) {
                dataNacaloooo = nacisleniaNacisleniaIUderjanias.get(0).getDataNacala();
                dataOkoncanie = nacisleniaNacisleniaIUderjanias.get(0).getDataOkoncania();
            }
            for (NacisleniaNacisleniaIUderjania nacislenia : nacisleniaNacisleniaIUderjanias) {
                if (nacislenia.getVidRasceta() != null) {
                    if (nacislenia.getRazmer() != null && !nacislenia.getRazmer().equals(new BigDecimal(0))) {
                        if (nacislenia.getVidRasceta().getSposobRasceta().getId() == 1)
                            nacislenia.setRezul1tat(nacislenia.getRazmer()
                                .divide(nacislenia.getNormaDnej(), 2, RoundingMode.CEILING)
                                .multiply(nacislenia.getOtrabotanoDnej()));
                        if (nacislenia.getVidRasceta().getSposobRasceta().getId() == 4)
                            nacislenia.setRezul1tat(nacislenia.getRazmer()
                                .divide(nacislenia.getNormaCasov(), 2, RoundingMode.CEILING)
                                .multiply(nacislenia.getOtrabotanoCasov()));
                        if (nacislenia.getVidRasceta().getSposobRasceta().getId() == 3)
                            nacislenia.setRezul1tat(nacislenia.getRazmer());
                        if (nacislenia.getVidRasceta().getSposobRasceta().getId() == 6)
                            nacislenia.setRezul1tat(nacislenia.getRazmer().multiply(new BigDecimal("0.5")));
                    }
                    if (nacislenia.getVidRasceta().getOblagaetsaSF() != null && nacislenia.getVidRasceta().getOblagaetsaSF())
                        oblagaetsaSV = oblagaetsaSV.add(nacislenia.getRezul1tat());
                    if (nacislenia.getVidRasceta().getOblagaetsaPN() != null && nacislenia.getVidRasceta().getOblagaetsaPN())
                        oblagaetsaPN = oblagaetsaPN.add(nacislenia.getRezul1tat());
                }
                if (nacislenia.getRezul1tat() != null)
                    rezultat = rezultat.add(nacislenia.getRezul1tat());
                if (nacislenia.getOtrabotanoDnej() != null)
                    otrabotanoDnej = otrabotanoDnej.add(nacislenia.getOtrabotanoDnej());
                if (nacislenia.getDataNacala() != null && nacislenia.getDataNacala().isBefore(dataNacaloooo))
                    dataNacaloooo = nacislenia.getDataNacala();
                if (nacislenia.getDataOkoncania() != null && nacislenia.getDataOkoncania().isAfter(dataOkoncanie))
                    dataOkoncanie = nacislenia.getDataOkoncania();
                if (nacislenia.getNormaDnej().compareTo(normaDnej) > 0) normaDnej = nacislenia.getNormaDnej();
            }
            niu.setNacisleno(rezultat);
            niu.setNeOblagaemajaCastSV(rezultat.subtract(oblagaetsaSV));
            niu.setNeOblagaemajaCastPN(rezultat.subtract(oblagaetsaPN));

            UderjaniaNacisleniaIUderjania uderjaniaNiU = dataManager.create(UderjaniaNacisleniaIUderjania.class);

            uderjaniaNiU.setNacisleniyaIUderjaniya(niu);

            uderjaniaNiU.setNacisleno(rezultat); //2
            uderjaniaNiU.setNacislenieNeOblSV(niu.getNeOblagaemajaCastSV()); //3
            uderjaniaNiU.setNacislenieOblPN(niu.getNeOblagaemajaCastPN()); //4

            KategoriaRabotnikov kategoriaRabotnikov = dataManager.load(KategoriaRabotnikov.class)
                    .query("select s from KategoriaRabotnikov  s where s.kod = :kod")
                .parameter("kod", "001").optional().orElseThrow();

            uderjaniaNiU.setKategoriaRabotnika(kategoriaRabotnikov); //5
            uderjaniaNiU.setDataNacala(dataNacaloooo); //6
            uderjaniaNiU.setDataOkoncania(dataOkoncanie); //7

            uderjaniaNiU.setNormaDnej(Integer.valueOf(normaDnej.toString())); //8
            uderjaniaNiU.setOtrabotanoDnej(Integer.valueOf(otrabotanoDnej.toString())); //9

            uderjaniaNiU.setNacislenieOblSV(uderjaniaNiU.getNacisleno().subtract(uderjaniaNiU.getNacislenieNeOblSV())); //10
            uderjaniaNiU.setDopFot(new BigDecimal(0)); //11


            DocumentStavki documentStavkis = dataManager.load(DocumentStavki.class)
                .query("select s from DocumentStavki s where s.dataVstuplenieDeistvia <= :data order by s.dataVstuplenieDeistvia desc")
                .maxResults(1)
                .parameter("data", ldt1Mesyas.toLocalDate())
                .one();

            for(StavkiStrahovyhVznosov stavkiStrahovyhVznosov : documentStavkis.getStavkiStrahovyhVznosov_()){  //12
                if(uderjaniaNiU.getKategoriaRabotnika().equals(stavkiStrahovyhVznosov.getKategoriaRabotnikov_())){
                    uderjaniaNiU.setPfSRabotodatela(uderjaniaNiU.getNacislenieOblSV().multiply(stavkiStrahovyhVznosov.getPfRabotodatel())
                        .divide(new BigDecimal("100"), 2, RoundingMode.CEILING));
                    uderjaniaNiU.setPfSRabotnika(uderjaniaNiU.getNacislenieOblSV().multiply(stavkiStrahovyhVznosov.getPfRabotnik())
                        .divide(new BigDecimal("100"), 2, RoundingMode.CEILING));

                    uderjaniaNiU.setFomsSRabotodatela(uderjaniaNiU.getNacislenieOblSV().multiply(stavkiStrahovyhVznosov.getFomsRabotadatel())
                        .divide(new BigDecimal("100"), 2, RoundingMode.CEILING));
                    uderjaniaNiU.setFomsSRabotnika(uderjaniaNiU.getNacislenieOblSV().multiply(stavkiStrahovyhVznosov.getFomsRabotnik())
                        .divide(new BigDecimal("100"), 2, RoundingMode.CEILING));

                    uderjaniaNiU.setFotSRabotodatela(uderjaniaNiU.getNacislenieOblSV().multiply(stavkiStrahovyhVznosov.getFotRabotodatel())
                        .divide(new BigDecimal("100"), 2, RoundingMode.CEILING));
                    uderjaniaNiU.setFotSRabotnika(uderjaniaNiU.getNacislenieOblSV().multiply(stavkiStrahovyhVznosov.getFotRabotnik())
                        .divide(new BigDecimal("100"), 2, RoundingMode.CEILING));

                    uderjaniaNiU.setGnpfSRabotnika(uderjaniaNiU.getNacislenieOblSV().multiply(stavkiStrahovyhVznosov.getGnpfRabotnik())
                        .divide(new BigDecimal("100"), 2, RoundingMode.CEILING));

                    uderjaniaNiU.setItogoSRabotnika(uderjaniaNiU.getPfSRabotnika().add(uderjaniaNiU.getFomsSRabotnika())
                        .add(uderjaniaNiU.getFotSRabotnika()).add(uderjaniaNiU.getGnpfSRabotnika())); // 19
                    uderjaniaNiU.setItogoSRabotodatela(uderjaniaNiU.getPfSRabotodatela().add(uderjaniaNiU.getFomsSRabotodatela())
                        .add(uderjaniaNiU.getFotSRabotodatela())); // 20
                }
            }

            uderjaniaNiU.setIzVycetaPoGosSV(uderjaniaNiU.getItogoSRabotodatela().add(uderjaniaNiU.getItogoSRabotnika())
                .subtract(uderjaniaNiU.getGnpfSRabotnika()));//21
            uderjaniaNiU.setKoefPersVuceta(new BigDecimal("6.5"));//23

            RascetnyjPokazatel1 rascetnyjPokazatel1 = dataManager.load(RascetnyjPokazatel1.class)
                .query("select s from RascetnyjPokazatel1 s where s.dataNacala <= :data order by s.dataNacala desc")
                .maxResults(1)
                .parameter("data", ldt1Mesyas)
                .optional().orElse(dataManager.create(RascetnyjPokazatel1.class));
            if(rascetnyjPokazatel1.getRazmer() == null) rascetnyjPokazatel1.setRazmer(new BigDecimal("1"));

            uderjaniaNiU.setPersonalnyjVycet(uderjaniaNiU.getKoefPersVuceta().multiply(rascetnyjPokazatel1.getRazmer()));//24

            uderjaniaNiU.setKolicestvoIjdevensev(new BigDecimal("0"));//25

            uderjaniaNiU.setVycetyNaIjdivensev(uderjaniaNiU.getKolicestvoIjdevensev().multiply(rascetnyjPokazatel1.getRazmer()));//26

            uderjaniaNiU.setIzVycetaNegosPF(new BigDecimal("0"));//27

            uderjaniaNiU.setSummaStandartnihVycetov(uderjaniaNiU.getPersonalnyjVycet().add(uderjaniaNiU.getVycetyNaIjdivensev())
                .add(uderjaniaNiU.getIzVycetaNegosPF()).add(uderjaniaNiU.getItogoSRabotnika()));//28

            if(uderjaniaNiU.getNacislenieNeOblPN() == null) uderjaniaNiU.setNacislenieNeOblPN(new BigDecimal("0"));
            uderjaniaNiU.setNacislenieOblPN(uderjaniaNiU.getNacisleno().subtract(uderjaniaNiU.getNacislenieNeOblPN()).
                subtract(uderjaniaNiU.getSummaStandartnihVycetov()));//29

            uderjaniaNiU.setDopMRD(new BigDecimal("0"));//30

            if(getEditedEntity().getOrganizacia().getPodohodnyiNalog_() != null && !getEditedEntity().getOrganizacia().getPodohodnyiNalog_().isEmpty()){
                uderjaniaNiU.setPn(uderjaniaNiU.getNacislenieOblPN().multiply(new BigDecimal(getEditedEntity().getOrganizacia()//31
                    .getPodohodnyiNalog_().get(getEditedEntity().getOrganizacia().getPodohodnyiNalog_() .size()-1).getStavkiPodohodnogoNaloga_().getStavka())));
                uderjaniaNiU.setPnOtMrd(uderjaniaNiU.getDopMRD().multiply(new BigDecimal(getEditedEntity().getOrganizacia()//32
                    .getPodohodnyiNalog_().get(getEditedEntity().getOrganizacia().getPodohodnyiNalog_() .size()-1).getStavkiPodohodnogoNaloga_().getStavka())));
            }
            else{
                uderjaniaNiU.setPn(new BigDecimal("0"));
                uderjaniaNiU.setPnOtMrd(new BigDecimal("0"));
            }

            uderjaniaNiU.setItogoPN(uderjaniaNiU.getPn().add(uderjaniaNiU.getPnOtMrd()));//33

            niu.setNacislenia(nacisleniaNacisleniaIUderjanias);
            niu.setUderjania(uderjaniaNiU);

            niuList.add(niu);
        }
        nacisleniaIUderjaniaDc.setItems(niuList);
    }

    private List<NacisleniaNacisleniaIUderjania> getRazovyeNacislenia(List<RazovoeNacislenie> razovoeNacislenieList,
                                                                      NacisleniyaIUderjaniya niu, LocalDateTime ldt1Mesyas, LocalDateTime ldt2Mesyas) {
        List<NacisleniaNacisleniaIUderjania> nacisleniaNIUList = new ArrayList<>();
        for (RazovoeNacislenie razovoeNacislenie : razovoeNacislenieList) {
            NacisleniaNacisleniaIUderjania nacisleniaNIU = dataContext.create(NacisleniaNacisleniaIUderjania.class);

            if (razovoeNacislenie.getDataNacislenia() != null && razovoeNacislenie.getDataNacislenia().isBefore(ldt1Mesyas))
                nacisleniaNIU.setDataNacala(ldt1Mesyas);
            else
                nacisleniaNIU.setDataNacala(razovoeNacislenie.getDataNacislenia());
            nacisleniaNIU.setDolznost1(razovoeNacislenie.getDolznost1());
            nacisleniaNIU.setVidRasceta(razovoeNacislenie.getVidRasceta());
            nacisleniaNIU.setPodrazdelenie(razovoeNacislenie.getPodrazdelenie());
            nacisleniaNIU.setRazmer(razovoeNacislenie.getRazmer());
            nacisleniaNIU.setDataOkoncania(ldt2Mesyas);
            nacisleniaNIU.setGrafikRaboty(razovoeNacislenie.getGrafikRaboty());
            nacisleniaNIU.setSotrudnik(razovoeNacislenie.getSotrudnik());
            nacisleniaNIUList.add(setNormaDneyICasov(nacisleniaNIU, razovoeNacislenie.getGrafikRaboty(), ldt1Mesyas, ldt2Mesyas, niu));
        }
        return nacisleniaNIUList;
    }

    private List<NacisleniaNacisleniaIUderjania> getNacislenia(List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacaloList,
                                                               NacisleniyaIUderjaniya niu, LocalDateTime ldt1Mesyas, LocalDateTime ldt2Mesyas) {
        List<NacisleniaNacisleniaIUderjania> nacisleniaNIUList = new ArrayList<>();

        for (PlanovyeNacisleniaNacalo planovyeNacisleniaNacalo : planovyeNacisleniaNacaloList) {
            NacisleniaNacisleniaIUderjania nacisleniaNIU = dataContext.create(NacisleniaNacisleniaIUderjania.class);

            if (planovyeNacisleniaNacalo.getPeriod() != null && planovyeNacisleniaNacalo.getPeriod().isBefore(ldt1Mesyas))
                nacisleniaNIU.setDataNacala(ldt1Mesyas);
            else
                nacisleniaNIU.setDataNacala(planovyeNacisleniaNacalo.getPeriod());

            nacisleniaNIU.setRazmer(planovyeNacisleniaNacalo.getRazmer());
            nacisleniaNIU.setDataOkoncania(ldt2Mesyas);
            nacisleniaNIU.setDolznost1(planovyeNacisleniaNacalo.getDolznost1());
            nacisleniaNIU.setVidRasceta(planovyeNacisleniaNacalo.getVidRasceta());
            nacisleniaNIU.setPodrazdelenie(planovyeNacisleniaNacalo.getPodrazdelenie());
            nacisleniaNIU.setGrafikRaboty(planovyeNacisleniaNacalo.getGrafikRaboty());
            nacisleniaNIU.setSotrudnik(planovyeNacisleniaNacalo.getSotrudnik());
            nacisleniaNIUList.add(setNormaDneyICasov(nacisleniaNIU, planovyeNacisleniaNacalo.getGrafikRaboty(), ldt1Mesyas, ldt2Mesyas, niu));
        }
        return nacisleniaNIUList;
    }

    private List<NacisleniaNacisleniaIUderjania> getNacisleniaSecond(List<PlanovyeNacisleniaOkoncanie> planovyeNacisleniaOkoncanieList,
                                                                     NacisleniyaIUderjaniya niu, LocalDateTime ldt1Mesyas, LocalDateTime ldt2Mesyas) {
        List<NacisleniaNacisleniaIUderjania> nacisleniaNIUList = new ArrayList<>();

        for (PlanovyeNacisleniaOkoncanie planovyeNacisleniaOkoncanie : planovyeNacisleniaOkoncanieList) {
            NacisleniaNacisleniaIUderjania nacisleniaNIU = dataContext.create(NacisleniaNacisleniaIUderjania.class);
            if (planovyeNacisleniaOkoncanie.getDataNacalo() != null && planovyeNacisleniaOkoncanie.getDataNacalo().isBefore(ldt1Mesyas))
                nacisleniaNIU.setDataNacala(ldt1Mesyas);
            else
                nacisleniaNIU.setDataNacala(planovyeNacisleniaOkoncanie.getDataNacalo());
            nacisleniaNIU.setVidRasceta(planovyeNacisleniaOkoncanie.getVidRasceta());
            nacisleniaNIU.setPodrazdelenie(planovyeNacisleniaOkoncanie.getPodrazdelenie());
            nacisleniaNIU.setGrafikRaboty(planovyeNacisleniaOkoncanie.getGrafikRaboty());
            nacisleniaNIU.setSotrudnik(planovyeNacisleniaOkoncanie.getSotrudnik());
            nacisleniaNIU.setDolznost1(planovyeNacisleniaOkoncanie.getDolznost1());
            nacisleniaNIU.setRazmer(planovyeNacisleniaOkoncanie.getRazmer());
            nacisleniaNIU.setDataOkoncania(planovyeNacisleniaOkoncanie.getPeriod());
            nacisleniaNIUList.add(setNormaDneyICasov(nacisleniaNIU, planovyeNacisleniaOkoncanie.getGrafikRaboty(), ldt1Mesyas, ldt2Mesyas, niu));
        }
        return nacisleniaNIUList;
    }

    private NacisleniaNacisleniaIUderjania setNormaDneyICasov(NacisleniaNacisleniaIUderjania nacisleniaNIU, GrafikiRaboty grafikRaboty,
                                                              LocalDateTime ldt1Mesyas, LocalDateTime ldt2Mesyas, NacisleniyaIUderjaniya niu) {
        List<KalendariGrafikovRabot> kalendariGrafikovRabotList = dataManager.load(KalendariGrafikovRabot.class)
            .query("select s from informations_KalendariGrafikovRabot s where s.grafikRaboty = :grafikRaboty " +
                "and s.data >= :data1 and s.data < :data2")
            .parameter("grafikRaboty", grafikRaboty)
            .parameter("data1", ldt1Mesyas)
            .parameter("data2", ldt2Mesyas)
            .list();

        int normaDney = 0;
        BigDecimal normaCasov = BigDecimal.valueOf(0.0);
        for (KalendariGrafikovRabot kalendariGrafikovRabot : kalendariGrafikovRabotList)
            if (kalendariGrafikovRabot.getVidDna().getId() == 1 || kalendariGrafikovRabot.getVidDna().getId() == 4) {
                normaDney = normaDney + 1;
                normaCasov = normaCasov.add(kalendariGrafikovRabot.getZnacenieCasov());
            }

        nacisleniaNIU.setNormaDnej(BigDecimal.valueOf(normaDney));
        nacisleniaNIU.setNormaCasov(normaCasov);
        nacisleniaNIU.setOtrabotanoDnej(BigDecimal.valueOf(normaDney));
        nacisleniaNIU.setOtrabotanoCasov(normaCasov);
        nacisleniaNIU.setNacisleniaIUderjania(niu);
        return nacisleniaNIU;
    }

    @Install(to = "nacisleniaIUderjaniasTable.fullName", subject = "columnGenerator")
    private Component tableGeneratedColumnFullNameColumnGenerator(NacisleniyaIUderjaniya nacisleniyaIUderjaniya) {
        return new Table.PlainTextCell(nacisleniyaIUderjaniya.getSotrudnik().getFizLico().getFirsName() +
            " " + nacisleniyaIUderjaniya.getSotrudnik().getFizLico().getName().charAt(0) +
            ". " + nacisleniyaIUderjaniya.getSotrudnik().getFizLico().getLastName().charAt(0) + ".");
    }

    @Install(to = "nacisleniaIUderjaniasTable2.fullName", subject = "columnGenerator")
    private Component table2GeneratedColumnFullNameColumnGenerator(NacisleniyaIUderjaniya nacisleniyaIUderjaniya) {
        return new Table.PlainTextCell(nacisleniyaIUderjaniya.getSotrudnik().getFizLico().getFirsName() +
            " " + nacisleniyaIUderjaniya.getSotrudnik().getFizLico().getName().charAt(0) +
            ". " + nacisleniyaIUderjaniya.getSotrudnik().getFizLico().getLastName().charAt(0) + ".");
    }

    @Subscribe("nacisleniaIUderjaniasTable2.edit")
    public void onReadCustomersTable2Edit(Action.ActionPerformedEvent event) {
        screenBuilders.editor(UderjaniaNacisleniaIUderjania.class, this)
            .editEntity(Objects.requireNonNull(nacisleniaIUderjaniasTable2.getSingleSelected()).getUderjania())
            .withScreenClass(UderjaniaNacisleniaIUderjaniaEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT))
                    nacislenieZarplatyDl.load();
            })
            .show();
    }
}
