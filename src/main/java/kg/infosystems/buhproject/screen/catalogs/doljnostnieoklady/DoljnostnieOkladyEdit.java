package kg.infosystems.buhproject.screen.catalogs.doljnostnieoklady;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.EntityComboBox;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Set;

@UiController("DoljnostnieOklady.edit")
@UiDescriptor("doljnostnie-oklady-edit.xml")
@EditedEntityContainer("doljnostnieOkladyDc")
public class DoljnostnieOkladyEdit extends StandardEditor<DoljnostnieOklady> {
    @Autowired
    private CollectionPropertyContainer<DoljnostnieOkladyDetail1> detail1Dc;
    @Autowired
    private DataContext dataContext;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private EntityComboBox<Organizacii> organizasia;
    @Autowired
    private DateField<Date> dateField;
    @Autowired
    private Notifications notifications;

    @Subscribe("detail1Table.add")
    public void onDetail1TableAddClick(Action.ActionPerformedEvent event) {
        DoljnostnieOkladyDetail1 item = dataContext.create(DoljnostnieOkladyDetail1.class);
        item.setDoljnostnieOklady(getEditedEntity());
        detail1Dc.getMutableItems().add(item);
    }

    @Subscribe(id = "detail1Dc", target = Target.DATA_CONTAINER)
    public void onDetail1DcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<DoljnostnieOkladyDetail1> event) {
        DoljnostnieOkladyDetail1 detail1 = event.getItem();
        if (detail1.getBazoviyOklad() != null && detail1.getCoefficentKratnosti() != null)
            detail1.setSumma(detail1.getBazoviyOklad().getSumma().multiply(detail1.getCoefficentKratnosti()));
        Set<DoljnostnieOkladyDetail1> doljnostnieOkladyList = getEditedEntity().getDetail1();
        int i = 0;
        for(DoljnostnieOkladyDetail1 doljnostnieOkladyDetail1 : doljnostnieOkladyList){
            if(doljnostnieOkladyDetail1.getDoljnost() != null && detail1.getDoljnost() != null
                && detail1.getDoljnost().equals(doljnostnieOkladyDetail1.getDoljnost())) i++;
        }
        if(i>1){
            notifications.create()
                .withCaption(" Базовый оклад на эту Должность уже создан!")
                .withDescription("Выберите другую дату")
                .withType(Notifications.NotificationType.ERROR)
                .show();
            detail1.setDoljnost(null);
        }
    }

    @Subscribe("organizasia")
    public void onOrganizasiaValueChange(HasValue.ValueChangeEvent<Organizacii> event) {
        checkFields();
    }

    @Subscribe("dateField")
    public void onDateFieldValueChange(HasValue.ValueChangeEvent<Date> event) {
        checkFields();
    }

    private void checkFields() {
        if(organizasia.getValue() != null && dateField.getValue() != null){
            DoljnostnieOklady doljnostnieOklady = dataManager.load(DoljnostnieOklady.class)
                .query("select e from DoljnostnieOklady e " +
                    "where e.organizasia = :organizacia and e.date = :date")
                .parameter("organizacia", organizasia.getValue())
                .parameter("date", dateField.getValue()).optional().orElse(dataManager.create(DoljnostnieOklady.class));
            DoljnostnieOklady doljnostnieOklady1 = dataManager.load(DoljnostnieOklady.class)
                .query("select e from DoljnostnieOklady e " +
                    "where e.id = :id")
                .parameter("id", getEditedEntity().getId())
                .optional().orElse(dataManager.create(DoljnostnieOklady.class));
            if(doljnostnieOklady.getName() != null && doljnostnieOklady1.getName() == null){
                notifications.create()
                    .withCaption("Должностные оклады для этой организации и даты уже созданы!")
                    .withDescription("Выберите другую дату")
                    .withType(Notifications.NotificationType.ERROR)
                    .show();
                dateField.setValue(null);
            }
        }
    }
    @Subscribe
    public void onAfterCommitChanges(AfterCommitChangesEvent event) {
        List<DoljnostnieOklady> doljnostnieOkladyList = dataManager.load(DoljnostnieOklady.class)
            .query("select e from DoljnostnieOklady e " +
                "where e.organizasia = :organizacia and e.date = :date")
            .parameter("organizacia", organizasia.getValue())
            .parameter("date", dateField.getValue()).list();

        if(doljnostnieOkladyList.size()>1){
            notifications.create()
                .withCaption("Должностные оклады для этой организации и даты уже созданы!")
                .withDescription("Выберите другую дату")
                .withType(Notifications.NotificationType.ERROR)
                .show();
            dateField.setValue(null);
            getEditedEntity().setDate(getEditedEntity().getDataDocumenta());
            dataManager.save(getEditedEntity());
        }
    }

}
