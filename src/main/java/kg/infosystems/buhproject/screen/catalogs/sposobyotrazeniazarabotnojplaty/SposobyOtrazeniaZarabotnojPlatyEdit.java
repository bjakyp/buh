package kg.infosystems.buhproject.screen.catalogs.sposobyotrazeniazarabotnojplaty;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty;
import kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov;
import kg.infosystems.buhproject.entity.globals.EconomClassifier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("SposobyOtrazeniaZarabotnojPlaty.edit")
@UiDescriptor("sposoby-otrazenia-zarabotnoj-platy-edit.xml")
@EditedEntityContainer("sposobyOtrazeniaZarabotnojPlatyDc")
public class SposobyOtrazeniaZarabotnojPlatyEdit extends StandardEditor<SposobyOtrazeniaZarabotnojPlaty> {
    @Autowired
    private TextField scetDtNaimenovanieField;
    @Autowired
    private EntityPicker<EconomClassifier> scetDtField;
    @Autowired
    private TextField scetKtNaimenovanieField;
    @Autowired
    private EntityPicker<EconomClassifier> scetKtField;
    @Autowired
    private EntityPicker<Stat1iDohodovIRashodov> stat1aZatratField;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private Notifications notifications;

    @Subscribe
    public void onInit(InitEvent event) {
//        if(scetDtField.getValue() != null){
//            scetDtNaimenovanieField.setValue(scetDtField.getValue().getName());
//        }
//        if(scetKtField.getValue() != null){
//            scetKtNaimenovanieField.setValue(scetKtField.getValue().getName());
//        }

    }


    @Install(to = "scetDtField", subject = "formatter")
    protected String scetDtFieldFormatter(EconomClassifier value) {
        return value != null ? value.getCode() : null;
    }

    @Install(to = "scetKtField", subject = "formatter")
    protected String scetKtFieldFormatter(EconomClassifier value) {
        return value != null ? value.getCode() : null;
    }

    @Subscribe("scetDtField")
    public void onScetDtFieldValueChange(HasValue.ValueChangeEvent<EconomClassifier> event) {
        scetDtNaimenovanieField.setValue(scetDtField.getValue().getName());
    }

    @Subscribe("scetKtField")
    public void onScetKtFieldValueChange(HasValue.ValueChangeEvent<EconomClassifier> event) {
        scetKtNaimenovanieField.setValue(scetKtField.getValue().getName());
    }

    @Subscribe("stat1aZatratField")
    public void onStat1aZatratFieldValueChange(HasValue.ValueChangeEvent<Stat1iDohodovIRashodov> event) {
        valueCheck();
    }

    private void valueCheck() {
        SposobyOtrazeniaZarabotnojPlaty sOZP = dataManager.load(SposobyOtrazeniaZarabotnojPlaty.class).id(getEditedEntity()
            .getId()).optional().orElse(dataManager.create(SposobyOtrazeniaZarabotnojPlaty.class));
        if(sOZP.getStat1aZatrat() == null && stat1aZatratField.getValue() != null && scetDtField.getValue() != null && scetKtField.getValue() != null){
            List<SposobyOtrazeniaZarabotnojPlaty> sOZPList = dataManager.load(SposobyOtrazeniaZarabotnojPlaty.class)
                .query("select o from SposobyOtrazeniaZarabotnojPlaty o where o.stat1aZatrat = :stat1aZatrat and " +
                    "o.scetDt = :scetDt and o.scetKt = :scetKt ")
                .parameter("stat1aZatrat", stat1aZatratField.getValue())
                .parameter("scetDt", scetDtField.getValue())
                .parameter("scetKt", scetKtField.getValue())
                .list();
            if(sOZPList.size() > 0){
                notifications.create()
                    .withCaption("Предупреждение!")
                    .withDescription("Способ отражения с такими данными уже существует!")
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .show();
                stat1aZatratField.setValue(null);
            }
        }
    }

    @Subscribe("scetDtField")
    public void onScetDtFieldValueChange1(HasValue.ValueChangeEvent<EconomClassifier> event) {
        valueCheck();
    }

    @Subscribe("scetKtField")
    public void onScetKtFieldValueChange1(HasValue.ValueChangeEvent<EconomClassifier> event) {
        valueCheck();
    }

}
