package kg.infosystems.buhproject.screen.catalogs.sotrudniki;

import io.jmix.core.DataManager;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.app.inputdialog.InputDialog;
import io.jmix.ui.app.inputdialog.InputParameter;
import io.jmix.ui.component.TreeTable;
import io.jmix.ui.component.inputdialog.InputDialogAction;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.FiziceskieLica;
import kg.infosystems.buhproject.entity.catalogs.Sotrudniki;
import kg.infosystems.buhproject.entity.catalogs.StranyMira;
import kg.infosystems.buhproject.entity.documents.NacisleniyaIUderjaniya;
import kg.infosystems.buhproject.screen.catalogs.fiziceskielica.FiziceskieLicaEdit;
import kg.infosystems.buhproject.screen.documents.NacisleniyaIUderjaniyaEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@UiController("Sotrudniki.browse")
@UiDescriptor("sotrudniki-browse.xml")
@LookupComponent("sotrudnikisTable")
public class SotrudnikiBrowse extends StandardLookup<Sotrudniki> {

    @Inject
    private Dialogs dialogs;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private CollectionLoader<Sotrudniki> sotrudnikisDl;
    @Inject
    private TreeTable<Sotrudniki> sotrudnikisTable;

    private String dayOfMonth(LocalDateTime localDateTime){
        return localDateTime.getDayOfMonth() < 10 ? "0" + localDateTime.getDayOfMonth() : String.valueOf(localDateTime.getDayOfMonth());
    }
    private String monthOfYear(LocalDateTime localDateTime){
        return localDateTime.getMonthValue() < 10 ? "0" + localDateTime.getMonthValue() : String.valueOf(localDateTime.getMonthValue());
    }
    @Subscribe("sotrudnikisTable.create")
    public void onSotrudnikisTableTableCreate(Action.ActionPerformedEvent event) {
        dialogs.createInputDialog(this)
            .withCaption("Введите ИНН")
            .withParameters(
                InputParameter.stringParameter("iNN").withCaption("ПИН")
            )
            .withActions(
                InputDialogAction.action("confirm")
                    .withCaption("Поиск")
                    .withPrimary(true)
                    .withHandler(actionEvent -> {
                        InputDialog dialog = actionEvent.getInputDialog();
                        assert dialog != null;
                        String iNN = dialog.getValue("iNN");
                        if (!FiziceskieLicaEdit.checkPin(iNN)) {
                            showNotifications("ПИН 14 цифровое значение", "Не должен содержать знаки и буквы. Начинается с '1' или '2'", Notifications.NotificationType.WARNING);
                        }
                        // Поиск по сотрудникам в этой организации
                        Sotrudniki sotrudnik = dataManager.load(Sotrudniki.class)
                            .query("select c from Sotrudniki c where c.iNN = :iNN")
                            .parameter("iNN", iNN).optional().orElse(dataManager.create(Sotrudniki.class));
                        //Если сотрудник есть:
                        if (sotrudnik.getINN() != null) {
                            Sotrudniki sotrudniki = dataManager.create(Sotrudniki.class);
                            sotrudniki.setINN(iNN);
                            sotrudniki.setFizLico(sotrudnik.getFizLico());
                            sotrudniki.setNaimenovanie(sotrudnik.getFizLico().getNaimenovanie());
                            LocalDateTime localDateTime = sotrudnik.getFizLico().getDataRozdenia();
                            String day = dayOfMonth(localDateTime);
                            String month = monthOfYear(localDateTime);
                            String str5 = day + "." + month + "." + localDateTime.getYear();
                            dialog.closeWithDefaultAction();
                            dialogs.createOptionDialog()
                                .withCaption(" ")
                                .withMessage("Сотрудник: \"" + sotrudnik.getFizLico().getFirsName() + " "
                                    + sotrudnik.getFizLico().getName() + " " + sotrudnik.getFizLico().getLastName() + "\".\n"
                                    + "Год рождения: \"" + str5 + "\" "
                                    + "\nуже есть в списке.\n")
                                .withActions(
                                    new BaseAction("openZapis1")
                                        .withCaption("Открыть запись")
                                        .withHandler(e ->
                                            screenBuilders.editor(Sotrudniki.class, this)
                                                .editEntity(sotrudnik)
                                                .withScreenClass(SotrudnikiEdit.class)
                                                .withOpenMode(OpenMode.THIS_TAB)
                                                .withAfterCloseListener(afterCloseEvent -> {
                                                    if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                                                        sotrudnikisDl.load();
                                                    }
                                                })
                                                .show()
                                        ),
/*                                    new BaseAction("novayaZapis1")
                                        .withCaption("Новая запись")
                                        .withHandler(e ->
                                            screenBuilders.editor(Sotrudniki.class, this)
                                                .editEntity(sotrudniki)
                                                .withScreenClass(SotrudnikiEdit.class)
                                                .withOpenMode(OpenMode.NEW_TAB)
                                                .withAfterCloseListener(afterCloseEvent -> {
                                                    if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                                                        sotrudnikisDl.load();
                                                    }
                                                })
                                                .show()
                                        ),*/
                                    new DialogAction(DialogAction.Type.CANCEL))
                                .show();
                            //Если сотрудника нет:
                        } else {
                            // Поиск по физическим лицам в этой организации
                            FiziceskieLica fiziceskieLica = dataManager.load(FiziceskieLica.class)
                                .query("select c from FiziceskieLica c where c.iNN = :iNN")
                                .parameter("iNN", iNN).optional().orElse(dataManager.create(FiziceskieLica.class));
                            //Если физическое лицо есть
                            if (fiziceskieLica.getINN() != null) {
//                                dialog.closeWithDefaultAction();
                                Sotrudniki sotrudniki = dataManager.create(Sotrudniki.class);
                                sotrudniki.setINN(iNN);
                                sotrudniki.setFizLico(fiziceskieLica);
                                sotrudniki.setNaimenovanie(fiziceskieLica.getNaimenovanie());
                                LocalDateTime localDateTime = fiziceskieLica.getDataRozdenia();
                                String day = dayOfMonth(localDateTime);
                                String month = monthOfYear(localDateTime);
                                String str5 = day + "." + month + "." + localDateTime.getYear();
                                dialogs.createOptionDialog()
                                    .withCaption(" ")
                                    .withMessage("ФИО: \"" + fiziceskieLica.getFirsName() + " "
                                        + fiziceskieLica.getName() + " " + fiziceskieLica.getLastName() + "\".\n"
                                        + "Год рождения: \"" +str5 + "\".\nДобавить в сотрудники?")
                                    .withActions(
                                        new BaseAction("novayaZapis1")
                                            .withCaption("Да")
                                            .withHandler(e ->
                                                screenBuilders.editor(Sotrudniki.class, this)
                                                    .editEntity(sotrudniki)
                                                    .withScreenClass(SotrudnikiEdit.class)
                                                    .withOpenMode(OpenMode.THIS_TAB)
                                                    .withAfterCloseListener(afterCloseEvent -> {
                                                        if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                                                            dialog.closeWithDefaultAction();
                                                            sotrudnikisDl.load();
                                                        }
                                                    })
                                                    .show()
                                            ),
                                        new DialogAction(DialogAction.Type.CANCEL).withCaption("Нет"))
                                    .show();
                                //Если физическое лицо нет
                            } else {
                                // Поиск по Пин Сервису в этой организации
                                FiziceskieLica fiziceskieLica1 = postPinService(iNN);
                                //Если есть на Пин сервисе
                                if (fiziceskieLica1.getFirsName() != null) {
                                    StranyMira stranyMira = dataManager.load(StranyMira.class)
                                        .query("select c from StranyMira c where c.kodAl1fa3 = :kodAl1fa3")
                                        .parameter("kodAl1fa3", "KGZ").optional().orElse(dataManager.create(StranyMira.class));
                                    fiziceskieLica1.setGrazdanstvo(stranyMira);
                                    Sotrudniki sotrudniki1 = dataManager.create(Sotrudniki.class);
                                    sotrudniki1.setINN(iNN);
                                    sotrudniki1.setFizLico(fiziceskieLica1);
                                    sotrudniki1.setNaimenovanie(fiziceskieLica1.getNaimenovanie());
                                    LocalDateTime localDateTime = fiziceskieLica1.getDataRozdenia();
                                    String day = localDateTime.getDayOfMonth() < 10 ? "0" + localDateTime.getDayOfMonth() : String.valueOf(localDateTime.getDayOfMonth());
                                    String month = localDateTime.getMonthValue() < 10 ? "0" + localDateTime.getMonthValue() : String.valueOf(localDateTime.getMonthValue());
                                    String str5 = day + "." + month + "." + localDateTime.getYear();
                                    dialogs.createOptionDialog()
                                        .withWidth("500px")
                                        .withMessage("Физическое лицо: " + fiziceskieLica1.getFirsName() + " "
                                            + fiziceskieLica1.getName() + " " + fiziceskieLica1.getLastName() + ".\n"
                                            + "Год рождения " + str5 + ".\nДобавить физическое лицо?")
                                        .withActions(
                                            new BaseAction("novayaZapis1")
                                                .withCaption("Да")
                                                .withHandler(e ->{
                                                    dataManager.save(fiziceskieLica1);
                                                    dialogs.createOptionDialog()
                                                        .withWidth("500px")
                                                        .withMessage("Физическое лицо: " + fiziceskieLica1.getFirsName() + " "
                                                            + fiziceskieLica1.getName() + " " + fiziceskieLica1.getLastName() + ".\n"
                                                            + "Год рождения " + str5 + " добавлено.\nДобавить в сотрудники?")
                                                        .withActions(
                                                            new BaseAction("novayaZapis2")
                                                                .withCaption("Да")
                                                                .withHandler(r ->{
                                                                        screenBuilders.editor(Sotrudniki.class, this)
                                                                            .editEntity(sotrudniki1)
                                                                            .withScreenClass(SotrudnikiEdit.class)
                                                                            .withOpenMode(OpenMode.THIS_TAB)
                                                                            .withAfterCloseListener(afterCloseEvent -> {
                                                                                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
//                                                                                    dialog.closeWithDefaultAction();
                                                                                    sotrudnikisDl.load();
                                                                                }
                                                                            })
                                                                            .show();
                                                                    }
                                                                ),
                                                            new DialogAction(DialogAction.Type.CANCEL).withCaption("Нет"))
                                                        .show();
                                                    }
                                                ),
                                            new DialogAction(DialogAction.Type.CANCEL))
                                        .show();
                                    dialog.closeWithDefaultAction();
                                } else {
                                    notifications.create()
                                        .withCaption("Физическое лицо с данным ИНН не существует")
                                        .withType(Notifications.NotificationType.HUMANIZED)
                                        .show();
                                }
                            }
                        }
//                        dialog.closeWithDefaultAction();
//
//                        notifications.create()
//                            .withCaption("Entered Values")
//                            .withDescription("<strong>Name:</strong> " + iNN)
//                            .withContentMode(ContentMode.HTML)
//                            .show();
                    }),
                InputDialogAction.action("refuse")
                    .withCaption("Отмена")
                    .withValidationRequired(false)
                    .withHandler(actionEvent ->
                        Objects.requireNonNull(actionEvent.getInputDialog()).closeWithDefaultAction())
            )
            .show();
    }

    private void showNotifications(String caption, String desc, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(desc)
            .withType(type)
            .withPosition(Notifications.Position.MIDDLE_CENTER)
            .show();
    }

    private FiziceskieLica postPinService(String iNN) {
        FiziceskieLica fiziceskieLica = dataManager.create(FiziceskieLica.class);
        fiziceskieLica.setINN(iNN);
        String urlAdress = "http://192.168.14.13";
//        String urlAdress = "http://httpbin.org/post";
        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream os = null;
        InputStreamReader isr = null;
        BufferedReader bfr = null;
        StringBuilder stringBuilder = new StringBuilder();


        try {
            Map<String, String> postArgs = new HashMap<>();
            postArgs.put("user", "Bob");
            postArgs.put("password", "123");

            String pin = iNN;
            StringBuilder str = new StringBuilder("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"" +
                " xmlns:xro=\"http://x-road.eu/xsd/xroad.xsd\" xmlns:iden=\"http://x-road.eu/xsd/identifiers\" " +
                "xmlns:prod=\"http://tunduk-seccurity-infocom.x-road.fi/producer\">\n" +
                "   <soapenv:Header>\n" +
                "      <xro:protocolVersion>4.0</xro:protocolVersion>\n" +
                "      <xro:issue>?</xro:issue>\n" +
                "      <xro:id>?</xro:id>\n" +
                "      <xro:userId>?</xro:userId>\n" +
                "      <xro:service iden:objectType=\"SERVICE\">\n" +
                "         <iden:xRoadInstance>central-server</iden:xRoadInstance>\n" +
                "         <iden:memberClass>GOV</iden:memberClass>\n" +
                "         <iden:memberCode>70000005</iden:memberCode>\n" +
                "         <!--Optional:-->\n" +
                "         <iden:subsystemCode>passport-service</iden:subsystemCode>\n" +
                "         <iden:serviceCode>passportDataForInfosystema</iden:serviceCode>\n" +
                "         <!--Optional:-->\n" +
                "         <iden:serviceVersion>v1</iden:serviceVersion>\n" +
                "      </xro:service>\n" +
                "      <xro:client iden:objectType=\"SUBSYSTEM\">\n" +
                "         <iden:xRoadInstance>central-server</iden:xRoadInstance>\n" +
                "         <iden:memberClass>GOV</iden:memberClass>\n" +
                "         <iden:memberCode>70000004</iden:memberCode>\n" +
                "         <!--Optional:-->\n" +
                "         <iden:subsystemCode>kazna-service</iden:subsystemCode>\n" +
                "      </xro:client>\n" +
                "   </soapenv:Header>\n" +
                "   <soapenv:Body>\n" +
                "      <prod:passportDataForInfosystema>\n" +
                "         <prod:request>\n" +
                "            <prod:pin>" + pin + "</prod:pin>\n" +
                "         </prod:request>\n" +
                "      </prod:passportDataForInfosystema>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>");

//            byte[] out = postArgs.toString().getBytes();
            byte[] out = str.toString().getBytes();


            url = new URL(urlAdress);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.addRequestProperty("Content-Type", "text/xml; charset=utf-8");
//            httpURLConnection.addRequestProperty("User-Agent", "mozilla/5.0");
//            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

//            httpURLConnection.setConnectTimeout(200);
//            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();


            try {
                os = httpURLConnection.getOutputStream();
                os.write(out);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()) {
                isr = new InputStreamReader(httpURLConnection.getInputStream());
                bfr = new BufferedReader(isr);
                String line;
                while ((line = bfr.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }

            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            StringReader strRead = new StringReader(stringBuilder.toString());
            InputSource ins = new InputSource(strRead);
            Document document = documentBuilder.parse(ins);

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList nodeList = document.getElementsByTagName("SOAP-ENV:Body");
//            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                // Если нода не текст, то это книга - заходим внутрь
                if (node.getNodeType() != Node.TEXT_NODE) {
                    NodeList nodeListProps = node.getChildNodes();
                    for (int j = 0; j < nodeListProps.getLength(); j++) {
                        Node bookProp = nodeListProps.item(j);
                        // Если нода не текст, то это один из параметров книги - печатаем
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            NodeList nodeList1 = bookProp.getChildNodes();
                            for (int k = 0; k < nodeList1.getLength(); k++) {
                                Node node1 = nodeList1.item(k);
                                if (node1.getNodeType() != Node.TEXT_NODE) {
                                    NodeList nodeList2 = node1.getChildNodes();
                                    for (int l = 0; l < nodeList2.getLength(); l++) {
                                        Node node2 = nodeList2.item(l);
                                        if (node2.getNodeName().equals("ts1:faultcode")) {
                                            return dataManager.create(FiziceskieLica.class);
                                        }
                                        if (node2.getNodeName().equals("ts1:surname")) fiziceskieLica.setFirsName(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:name")) fiziceskieLica.setName(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:patronymic"))
                                            fiziceskieLica.setLastName(node2.getTextContent());
//                                        if (node2.getNodeName().equals("ts1:nationality"))
                                        if (node2.getNodeName().equals("ts1:dateOfBirth")) {
                                            String str2 = node2.getTextContent();
                                            String str3 = str2.substring(0, 10) + "T" + str2.substring(11, 19);
                                            LocalDateTime localDate = LocalDateTime.parse(str3);
                                            fiziceskieLica.setDataRozdenia(localDate);
                                        }
                                        if (node2.getNodeName().equals("ts1:passportSeries"))
                                            fiziceskieLica.setPassportSeries(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:passportNumber"))
                                            fiziceskieLica.setPassportNumber(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:issuedDate"))
                                            fiziceskieLica.setIssuedDate(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:expiredDate"))
                                            fiziceskieLica.setExpiredDate(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:passportAuthority"))
                                            fiziceskieLica.setPassportAuthority(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:address"))
                                            fiziceskieLica.setMestoRozdenia(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:addressLocalityCode"))
                                            fiziceskieLica.setAddressLocalityCode(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:passportNumberAC"))
                                            fiziceskieLica.setPassportNumberAC(node2.getTextContent());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            fiziceskieLica.setNaimenovanie(fiziceskieLica.getFirsName() + " " + fiziceskieLica.getName() + " " + fiziceskieLica.getLastName());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.err.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fiziceskieLica;
    }

    @Subscribe("sotrudnikisTable.edit")
    public void onReadOnlyCustomersTableEdit(Action.ActionPerformedEvent event) {
        screenBuilders.editor(Sotrudniki.class, this)
            .editEntity(sotrudnikisTable.getSingleSelected())
            .withScreenClass(SotrudnikiEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    sotrudnikisDl.load();
                }
            })
            .show();
    }

}
