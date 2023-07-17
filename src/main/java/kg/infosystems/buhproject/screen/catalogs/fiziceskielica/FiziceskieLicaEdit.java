package kg.infosystems.buhproject.screen.catalogs.fiziceskielica;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.FiziceskieLica;
import kg.infosystems.buhproject.entity.enumerations.PolFiziceskogoLica;
import kg.infosystems.buhproject.entity.parts.catalogs.FiziceskieLicaKontaktnaaInformacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@UiController("FiziceskieLica.edit")
@UiDescriptor("fiziceskie-lica-edit.xml")
@EditedEntityContainer("fiziceskieLicaDc")
public class FiziceskieLicaEdit extends StandardEditor<FiziceskieLica> {
    @Autowired
    private Notifications notifications;
    @Autowired
    private TextField<String> iNNField;
    @Autowired
    private EntityPicker<PolFiziceskogoLica> polField;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private CollectionPropertyContainer<FiziceskieLicaKontaktnaaInformacia> kontaktnaaInformaciaDc;
    @Autowired
    private TextField<String> nacionalnost1Label;

    @Subscribe("kontaktnaaInformaciaTable.create")
    public void onKontaktnaaInformaciaTableCreate(Action.ActionPerformedEvent event) {
        FiziceskieLicaKontaktnaaInformacia item = dataManager.create(FiziceskieLicaKontaktnaaInformacia.class);
        item.setPart(getEditedEntity());
        item.setNomerStroki(BigDecimal.valueOf(kontaktnaaInformaciaDc.getDisconnectedItems().size()));
        kontaktnaaInformaciaDc.getMutableItems().add(item);
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (!checkPin(iNNField.getValue())) {
            showNotifications("Исправьте поле ПИН", "", Notifications.NotificationType.ERROR);
            event.preventCommit();
        }
    }


    @Subscribe("iNNField")
    public void onINNFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        if (event.getValue() == null) return;
        String value = event.getValue();
        char gender = value.charAt(0);
        if (!checkPin(value)) {
            showNotifications("ПИН 14 цифровое значение", "Не должен содержать знаки и буквы. Начинается с '1' или '2'", Notifications.NotificationType.WARNING);
            polField.setValue(null);
        } else if (gender == '1') {
            polField.setValue(getGender(2));
        } else if (gender == '2') {
            polField.setValue(getGender(1));
        }
        iNNField.setValue(value);
    }

    public static Boolean checkPin(String value) {
        if (!Pattern.matches("[0-9]+", value)) return false;
        long currValue = Long.parseLong(value);
        char gender = value.charAt(0);
        if (gender == '1' || gender == '2')
            return Pattern.matches("[0-9]+", value) && value.length() == 14 && currValue > 0;
        else return false;
    }

    private PolFiziceskogoLica getGender(int genderOrder) {
        return dataManager.loadValue("select e from PolFiziceskogoLica e " +
                "where e.order = :genderOrder", PolFiziceskogoLica.class)
            .parameter("genderOrder", genderOrder)
            .one();
    }

    private void showNotifications(String caption, String desc, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(desc)
            .withType(type)
            .withPosition(Notifications.Position.MIDDLE_CENTER)
            .show();
    }

    private void postPinService(){
        String urlAdress = "http://192.168.14.13";
//        String urlAdress = "http://httpbin.org/post";
        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream os = null;
        InputStreamReader isr = null;
        BufferedReader bfr = null;
        StringBuilder stringBuilder = new StringBuilder();


        try{
            Map <String, String> postArgs = new HashMap<>();
            postArgs.put("user", "Bob");
            postArgs.put("password", "123");

            String pin = iNNField.getRawValue();
            StringBuilder str = new StringBuilder("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xro=\"http://x-road.eu/xsd/xroad.xsd\" xmlns:iden=\"http://x-road.eu/xsd/identifiers\" xmlns:prod=\"http://tunduk-seccurity-infocom.x-road.fi/producer\">\n" +
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



            try{
                os = httpURLConnection.getOutputStream();
                os.write(out);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
            if(HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()){
                isr = new InputStreamReader(httpURLConnection.getInputStream());
                bfr = new BufferedReader(isr);
                String line;
                while ((line = bfr.readLine()) != null){
                    stringBuilder.append(line);
                }
            }
            System.out.println(stringBuilder);

            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            StringReader strRead = new StringReader(stringBuilder.toString());
            InputSource ins = new InputSource(strRead);
            Document document = documentBuilder.parse(ins);

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("List of books:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList nodeList = document.getElementsByTagName("SOAP-ENV:Body");
//            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("1111111111111111:" + node.getNodeName());
                // Если нода не текст, то это книга - заходим внутрь
                if (node.getNodeType() != Node.TEXT_NODE) {
                    NodeList nodeListProps = node.getChildNodes();
                    for(int j = 0; j < nodeListProps.getLength(); j++) {
                        Node bookProp = nodeListProps.item(j);
                        // Если нода не текст, то это один из параметров книги - печатаем
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            NodeList nodeList1 = bookProp.getChildNodes();
                            for(int k = 0; k<nodeList1.getLength(); k++){
                                Node node1 = nodeList1.item(k);
                                if (node1.getNodeType() != Node.TEXT_NODE) {
                                    NodeList nodeList2 = node1.getChildNodes();
                                    for(int l = 0; l<nodeList2.getLength(); l++){
                                        Node node2 = nodeList2.item(l);
                                        System.out.println(node2.getNodeName() + ":" + node2.getTextContent());
//                                        if (node2.getNodeName().equals("ts1:faultcode")) {
//                                            return dataManager.create(FiziceskieLica.class);
//                                        }
                                        if (node2.getNodeName().equals("ts1:surname")) {
                                            getEditedEntity().setFirsName(node2.getTextContent());
                                        }
                                        if (node2.getNodeName().equals("ts1:name")) getEditedEntity().setName(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:patronymic")) getEditedEntity().setLastName(node2.getTextContent());
//                                        if (node2.getNodeName().equals("ts1:gender")) polLabel.setValue(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:nationality")) nacionalnost1Label.setValue(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:dateOfBirth")) {
                                            String str2 = node2.getTextContent();
                                            String str3 = str2.substring(0, 10) + "T" + str2.substring(11, 19);
                                            LocalDateTime localDate = LocalDateTime.parse(str3);
                                            getEditedEntity().setDataRozdenia(localDate);
                                        }
                                        if (node2.getNodeName().equals("ts1:passportSeries")) getEditedEntity().setPassportSeries(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:passportNumber")) getEditedEntity().setPassportNumber(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:issuedDate")) getEditedEntity().setIssuedDate(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:expiredDate")) getEditedEntity().setExpiredDate(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:passportAuthority")) getEditedEntity().setPassportAuthority(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:address")) getEditedEntity().setMestoRozdenia(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:addressLocalityCode")) getEditedEntity().setAddressLocalityCode(node2.getTextContent());
                                        if (node2.getNodeName().equals("ts1:passportNumberAC")) getEditedEntity().setPassportNumberAC(node2.getTextContent());
                                    }

                                }
                            }
                        }
                    }
                    System.out.println("===========>>>>");
                }
            }
            getEditedEntity().setNaimenovanie(getEditedEntity().getFirsName() + " " + getEditedEntity().getName() + " " + getEditedEntity().getLastName());

        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.err.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Subscribe("searchBtn")
    public void onSearchBtnClick(Button.ClickEvent event) {
        postPinService();
    }
}
