package kg.infosystems.buhproject.screen.documentstavki;

import io.jmix.ui.component.DateField;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.DocumentStavki;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@UiController("DocumentStavki.edit")
@UiDescriptor("document-stavki-edit.xml")
@EditedEntityContainer("documentStavkiDc")
public class DocumentStavkiEdit extends StandardEditor<DocumentStavki> {
    @Inject
    private DateField<LocalDate> dataVstuplenieDeistviaField;

    /*Nurs 19.06.23*/
    @Subscribe("dataVstuplenieDeistviaField")
    public void onDataVstuplenieDeistviaFieldValueChange(HasValue.ValueChangeEvent<LocalDate> event) {
        dataVstuplenieDeistviaField.setValue(getFirstDayOfMonth(event.getValue()));
    }

    /*Nurs 19.06.23*/
    private LocalDate getFirstDayOfMonth(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfMonth());
    }

}
