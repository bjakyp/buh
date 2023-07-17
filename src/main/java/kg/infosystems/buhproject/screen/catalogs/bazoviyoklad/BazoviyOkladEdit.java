package kg.infosystems.buhproject.screen.catalogs.bazoviyoklad;

import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.ContentMode;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.BazoviyOklad;
import kg.infosystems.buhproject.entity.catalogs.StatnieRaspisaniePrikazy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@UiController("BazoviyOklad.edit")
@UiDescriptor("bazoviy-oklad-edit.xml")
@EditedEntityContainer("bazoviyOkladDc")
public class BazoviyOkladEdit extends StandardEditor<BazoviyOklad> {
    @Inject
    private DateField<Date> dateField;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private Notifications notifications;

    @Subscribe("dateField")
    public void onDateFieldValueChange(HasValue.ValueChangeEvent<Date> event) {
        if(controlkaPeriodField()) dateField.setValue(null);
    }
    private boolean controlkaPeriodField() {
        if (!dateField.isEmpty()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(Objects.requireNonNull(dateField.getValue()));
//            Если число даты не 1 то превращает его в 1
            if (calendar.get(Calendar.DAY_OF_MONTH) != 1) {
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                dateField.setValue(calendar.getTime());
            }
            BazoviyOklad srp = dataManager.load(BazoviyOklad.class)
                .query("select c from BazoviyOklad c order by c.date desc").optional().orElse(null);
            BazoviyOklad statnieRaspisaniePrikazy = dataManager.load(BazoviyOklad.class).id(getEditedEntity()).optional().orElse(null);
//            Проверка на последнюю дату документа
            if (statnieRaspisaniePrikazy == null && srp != null && (calendar.getTime().before(srp.getDate()) || calendar.getTime().equals(srp.getDate()))) {
                notifications.create()
                    .withCaption("")
                    .withDescription("Приказы можно добавлять только после последнего приказа!")
                    .withContentMode(ContentMode.HTML)
                    .show();
                return true;
            }
            //Если документ редактируется, то нельзя поменять дату
            if (statnieRaspisaniePrikazy != null) dateField.setEditable(false);
        }
        return false;
    }
}
