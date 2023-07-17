package kg.infosystems.buhproject.screen.catalogs.sotrudniki;

import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.DialogOutcome;
import io.jmix.ui.app.inputdialog.InputParameter;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.Table;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.model.InstanceLoader;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.*;
import kg.infosystems.buhproject.entity.enumerations.VidyDvizenijPoProfsouzam;
import kg.infosystems.buhproject.entity.parts.catalogs.FiziceskieLicaKontaktnaaInformacia;
import kg.infosystems.buhproject.screen.catalogs.bankovskiesceta.BankovskieScetaEdit;
import kg.infosystems.buhproject.screen.catalogs.kartscetasotrudnikov.KartScetaSotrudnikovEdit;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Math.max;

@UiController("Sotrudniki.edit")
@UiDescriptor("sotrudniki-edit.xml")
@EditedEntityContainer("sotrudnikiDc")
public class SotrudnikiEdit extends StandardEditor<Sotrudniki> {
    @Inject
    private CollectionContainer<FiziceskieLicaKontaktnaaInformacia> kontaktnaaInformaciaDc;
    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionLoader<FiziceskieLicaKontaktnaaInformacia> kontaktnaaInformaciaDl;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private InstanceLoader<Sotrudniki> sotrudnikiDl;
    @Inject
    private CollectionPropertyContainer<Profsoyuz> profsoyuzDc;
    @Inject
    private Table<KartScetaSotrudnikov> kartScetaSotrudnikovsTable;
    @Inject
    private Button profsoyuzTableCreateBtn;
    @Inject
    private Button profsoyuzTableLeaveBtn;
    @Inject
    private Table<BankovskieSceta> bankovskieScetasTable;
    @Inject
    private Dialogs dialogs;
    @Inject
    private Notifications notifications;
    @Inject
    private EntityStates entityStates;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Long code = getEditedEntity().getKod();
        Organizacii org = getEditedEntity().getOrganizacia();
        if (code == null || org == null) {
            showNotification("Заполните обязательные поля!", "", Notifications.NotificationType.WARNING);
            event.preventCommit();
        }
        long codeItem = dataManager.loadValue("select count(e) from Sotrudniki e " +
                "where e.kod = :code and e.organizacia = :org", Long.class)
            .parameter("code", code)
            .parameter("org", org)
            .one();
        if ((entityStates.isNew(getEditedEntity()) && codeItem != 0)
            || (codeItem > 1 && !entityStates.isNew(getEditedEntity()))) {
            showNotification("Пользователь с таким табельным номером уже существует!", "Измените поле табельный номер", Notifications.NotificationType.WARNING);
            event.preventCommit();
        }
    }

    private void showNotification(String caption, String description, Notifications.NotificationType type) {
        notifications.create()
            .withCaption(caption)
            .withDescription(description)
            .withType(type)
            .withPosition(Notifications.Position.MIDDLE_CENTER).show();
    }

    @Subscribe("organizaciaField")
    public void onOrganizaciaFieldValueChange(HasValue.ValueChangeEvent<Organizacii> event) {
        Organizacii org = event.getValue();
        if (entityStates.isNew(getEditedEntity())) {
            Sotrudniki sot = dataManager.load(Sotrudniki.class).query("select s from Sotrudniki s " +
                    "where s.kod is not null and s.deletedBy is null and s.organizacia = :org order by s.kod desc")
                .parameter("org", org)
                .optional().orElse(null);
            getEditedEntity().setKod(sot == null ? 1 : sot.getKod() + 1);
        }
    }


//    @Subscribe("fizLicoField")
//    public void onFizLicoFieldValueChange(HasValue.ValueChangeEvent<FiziceskieLica> event) {
//        String naimenovanie = event.getValue() == null ? "" : Objects.requireNonNull(event.getValue()).getNaimenovanie();
//        getEditedEntity().setNaimenovanie(naimenovanie);
//    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        Sotrudniki sotrudniki = getEditedEntity();
        if (sotrudniki.getFizLico() != null) kontaktnaaInformaciaDl.setParameter("fizLico", sotrudniki.getFizLico());
        kontaktnaaInformaciaDl.load();
    }

    @Subscribe("kontaktnaaInformaciaTable.create")
    public void onKontaktnaaInformaciaTableCreate(Action.ActionPerformedEvent event) {
        FiziceskieLicaKontaktnaaInformacia item = dataManager.create(FiziceskieLicaKontaktnaaInformacia.class);
        item.setPart(getEditedEntity().getFizLico());
        item.setNomerStroki(BigDecimal.valueOf(kontaktnaaInformaciaDc.getMutableItems().size()));
        kontaktnaaInformaciaDc.getMutableItems().add(item);
    }

    @Subscribe("kartScetaSotrudnikovsTable.create")
    public void onReadOnlyCustomersTableCreate(Action.ActionPerformedEvent event) {
        KartScetaSotrudnikov kartScetaSotrudnikov = dataManager.create(KartScetaSotrudnikov.class);
        kartScetaSotrudnikov.setSotrudniki(getEditedEntity());
        screenBuilders.editor(KartScetaSotrudnikov.class, this)
            .editEntity(kartScetaSotrudnikov)
            .withScreenClass(KartScetaSotrudnikovEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    sotrudnikiDl.load();
                }
            })
            .show();
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        int size = profsoyuzDc.getItems() != null ? profsoyuzDc.getItems().size() : 0;
        if (size % 2 == 0) {
            profsoyuzTableLeaveBtn.setVisible(false);
            profsoyuzTableCreateBtn.setVisible(true);
        } else {
            profsoyuzTableLeaveBtn.setVisible(true);
            profsoyuzTableCreateBtn.setVisible(false);
        }
    }


    @Subscribe("kartScetaSotrudnikovsTable.edit")
    public void onReadOnlyCustomersTableEdit(Action.ActionPerformedEvent event) {

        screenBuilders.editor(KartScetaSotrudnikov.class, this)
            .editEntity(kartScetaSotrudnikovsTable.getSingleSelected())
            .withScreenClass(KartScetaSotrudnikovEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    sotrudnikiDl.load();
                }
            })
            .show();
    }

    @Subscribe("bankovskieScetasTable.create")
    public void onBankovskieScetasTableCreate(Action.ActionPerformedEvent event) {
        BankovskieSceta bankovskieSceta = dataManager.create(BankovskieSceta.class);
        bankovskieSceta.setSotrudniki(getEditedEntity());
        screenBuilders.editor(BankovskieSceta.class, this)
            .editEntity(bankovskieSceta)
            .withScreenClass(BankovskieScetaEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    sotrudnikiDl.load();
                }
            })
            .show();
    }

    @Subscribe("bankovskieScetasTable.edit")
    public void onBankovskieScetasTableEdit(Action.ActionPerformedEvent event) {
        screenBuilders.editor(BankovskieSceta.class, this)
            .editEntity(bankovskieScetasTable.getSingleSelected())
            .withScreenClass(BankovskieScetaEdit.class)
            .withOpenMode(OpenMode.DIALOG)
            .withAfterCloseListener(afterCloseEvent -> {
                if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    sotrudnikiDl.load();
                }
            })
            .show();
    }

    @Subscribe("profsoyuzTable.create")
    public void onProfsoyuzTableCreate(Action.ActionPerformedEvent event) {
        changeProfsoyuzDialog(1);
    }

    @Subscribe("profsoyuzTableLeaveBtn")
    public void onProfsoyuzTableLeaveBtnClick(Button.ClickEvent event) {
        changeProfsoyuzDialog(2);
    }

    private void changeProfsoyuzDialog(int type) {
        dialogs.createInputDialog(this)
            .withCaption("Введите данные")
            .withParameters(
                InputParameter.localDateParameter("dataDvizenia")
                    .withCaption("Дата движение")
                    .withRequired(true)
            )
            .withActions(DialogActions.OK_CANCEL)
            .withCloseListener(closeEvent -> {
                if (closeEvent.closedWith(DialogOutcome.OK)) {
                    VidyDvizenijPoProfsouzam vidDvijenya = dataManager.load(VidyDvizenijPoProfsouzam.class)
                        .id(type)
                        .one();
                    LocalDate dataDvizenia = closeEvent.getValue("dataDvizenia");
                    LocalDateTime dateTime = dataDvizenia.atStartOfDay();
                    LocalDateTime localDate = LocalDate.now().atStartOfDay();
                    List<Profsoyuz> profsoyuzList = profsoyuzDc.getItems();
                    if (dateTime.isAfter(localDate)) {
                        showDateError();
                    } else if (profsoyuzList.size() != 0 && checkLastDateInProfsoyuz(profsoyuzList, dateTime)) {
                        showDateError();
                    } else {
                        Profsoyuz profsoyuz = dataManager.create(Profsoyuz.class);
                        profsoyuz.setSotrudniki(getEditedEntity());
                        profsoyuz.setVidDvizenia(vidDvijenya);
                        profsoyuz.setDataDvizenia(dataDvizenia.atStartOfDay());
                        profsoyuzDc.getMutableItems().add(profsoyuz);
                        if (type == 1) {
                            profsoyuzTableCreateBtn.setVisible(false);
                            profsoyuzTableLeaveBtn.setVisible(true);
                        } else {
                            profsoyuzTableLeaveBtn.setVisible(false);
                            profsoyuzTableCreateBtn.setVisible(true);
                        }
                    }
                }
            })
            .show();
    }

    private boolean checkLastDateInProfsoyuz(List<Profsoyuz> list, LocalDateTime dateTime) {
        LocalDateTime lastItemDate = list.get(max(list.size() - 1, 0)).getDataDvizenia();
        return dateTime.isBefore(lastItemDate) || dateTime.isEqual(lastItemDate);
    }

    private void showDateError() {
        showNotification("Выберите другую дату!", "", Notifications.NotificationType.WARNING);
    }


}
