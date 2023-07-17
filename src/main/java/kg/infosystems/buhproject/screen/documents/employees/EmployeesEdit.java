package kg.infosystems.buhproject.screen.documents.employees;

import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.Dolznosti;
import kg.infosystems.buhproject.entity.parts.documents.Employees;

import java.math.BigDecimal;
import java.math.RoundingMode;

@UiController("Employees.edit")
@UiDescriptor("employees-edit.xml")
@EditedEntityContainer("employeesDc")
public class EmployeesEdit extends StandardEditor<Employees> {

    @Subscribe("doljnostField")
    public void onDoljnostFieldValueChange(HasValue.ValueChangeEvent<Dolznosti> event) {
        Dolznosti dolznosti = event.getValue();
        Employees employee = getEditedEntity();
        employee.setStavka( new BigDecimal(1000));
        employee.setKoefficentKratnosti( new BigDecimal(2));
        employee.setDoljnostnoyOklad( employee.getStavka().multiply(employee.getKoefficentKratnosti()));
    }

    @Subscribe("zaVyslugiLetPercentField")
    public void onZaVyslugiLetPercentFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        getEditedEntity().setZaVyslugiLet(getEditedEntity().getDoljnostnoyOklad().multiply(
            getEditedEntity().getZaVyslugiLetPercent().divide(new BigDecimal(100), 3, RoundingMode.HALF_UP)));
        zapolnit1DrugiePola();
    }

    @Subscribe("nadbavkaZaVysokogoriePercentField")
    public void onNadbavkaZaVysokogoriePercentFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        getEditedEntity().setNadbavkaZaVysokogorie(getEditedEntity().getDoljnostnoyOklad().multiply(
            getEditedEntity().getNadbavkaZaVysokogoriePercent().divide(new BigDecimal(100), 3, RoundingMode.HALF_UP)));
        zapolnit1DrugiePola();
    }

    @Subscribe("nadbavkaZaSlojnost1PercentField")
    public void onNadbavkaZaSlojnost1PercentFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        getEditedEntity().setNadbavkaZaSlojnost1(getEditedEntity().getDoljnostnoyOklad().multiply(
            getEditedEntity().getNadbavkaZaSlojnost1Percent().divide(new BigDecimal(100), 3, RoundingMode.HALF_UP)));
        zapolnit1DrugiePola();
    }

    @Subscribe("secretnost1PercentField")
    public void onSecretnost1PercentFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        getEditedEntity().setSecretnost1(getEditedEntity().getDoljnostnoyOklad().multiply(
            getEditedEntity().getSecretnost1Percent().divide(new BigDecimal(100), 3, RoundingMode.HALF_UP)));
        zapolnit1DrugiePola();
    }

    @Subscribe("vrednost1PercentField")
    public void onVrednost1PercentFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        getEditedEntity().setVrednost1(getEditedEntity().getDoljnostnoyOklad().multiply(
            getEditedEntity().getVrednost1Percent().divide(new BigDecimal(100), 3, RoundingMode.HALF_UP)));
        zapolnit1DrugiePola();
    }

    @Subscribe("uchenayaStepenField")
    public void onUchenayaStepenFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        zapolnit1DrugiePola();
    }

    @Subscribe("rayonniyKoefficentPercentField")
    public void onRayonniyKoefficentPercentFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        zapolnit1DrugiePola();
    }



    @Subscribe("kompensacionnyeZaPervyiMesacField")
    public void onKompensacionnyeZaPervyiMesacFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        getEditedEntity().setKompensacionnyeZaOdinnadcatyiMesac( getEditedEntity().getKompensacionnyeZaPervyiMesac().multiply(new BigDecimal(11)));
        zapolnit1DrugiePola();
    }

    @Subscribe("stavkaSocFotPercentField")
    public void onStavkaSocFotPercentFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        zapolnit1DrugiePola();
    }

    private void zapolnit1DrugiePola() {
        Employees employee = getEditedEntity();
        if(employee.getDoljnostnoyOklad() != null && employee.getZaVyslugiLet() != null && employee.getNadbavkaZaVysokogorie() != null
            && employee.getKlasnyiChin() != null && employee.getNadbavkaZaSlojnost1() != null && employee.getSecretnost1() != null
            && employee.getVrednost1() != null && employee.getUchenayaStepen() != null
            && employee.getRayonniyKoefficentPercent() != null
            && employee.getKompensacionnyeZaPervyiMesac() != null && employee.getStavkaSocFotPercent() != null){

            employee.setMesacnayaZarplataNaRabotnika(employee.getDoljnostnoyOklad().add(employee.getZaVyslugiLet()
                .add(employee.getNadbavkaZaVysokogorie().add(employee.getKlasnyiChin()).add(employee.getNadbavkaZaSlojnost1())
                    .add(employee.getSecretnost1()).add(employee.getVrednost1()).add(employee.getUchenayaStepen()))));

            employee.setRayonniyKoefficent(employee.getDoljnostnoyOklad().multiply(employee.getRayonniyKoefficentPercent()
                .divide(new BigDecimal(100), 3, RoundingMode.HALF_UP)));

            employee.setItogoNadbavkiIDoplaty(employee.getZaVyslugiLet().add(employee.getNadbavkaZaVysokogorie().add(employee.getKlasnyiChin()
                .add(employee.getNadbavkaZaSlojnost1().add(employee.getSecretnost1().add(employee.getVrednost1()
                    .add(employee.getUchenayaStepen().add(employee.getRayonniyKoefficent()))))))));

            employee.setVsegoZaFOTzaMesyac(employee.getMesacnayaZarplataNaRabotnika().add(employee.getRayonniyKoefficent()));

            employee.setOtpusknoy( employee.getVsegoZaFOTzaMesyac().divide(new BigDecimal("29.6"),  3, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(30)));

            employee.setLechebnoePosobieKOtpusku( employee.getVsegoZaFOTzaMesyac().multiply(new BigDecimal(2)));

            employee.setZarplata13( employee.getVsegoZaFOTzaMesyac().multiply(new BigDecimal(11)).add(employee.getOtpusknoy())
                .add(employee.getOtpusknoy()).divide(new BigDecimal(12), 3, RoundingMode.HALF_UP));

            employee.setGodovoyFOT(employee.getVsegoZaFOTzaMesyac().multiply(new BigDecimal(11))
                .add(employee.getOtpusknoy()).add(employee.getLechebnoePosobieKOtpusku())
                .add(employee.getZarplata13()).add(employee.getKompensacionnyeZaOdinnadcatyiMesac()));

            employee.setOtchislenieVSocFond(employee.getGodovoyFOT().subtract(employee.getLechebnoePosobieKOtpusku())
                .subtract(employee.getKompensacionnyeZaOdinnadcatyiMesac())
                .multiply(employee.getStavkaSocFotPercent().divide(new BigDecimal(100), 3, RoundingMode.HALF_UP)));

            employee.setGodovoyFOTzaVychetomSFKR(employee.getGodovoyFOT().add(employee.getOtchislenieVSocFond()));

            employee.setSrednemesacnayaZP(employee.getGodovoyFOT().divide(new BigDecimal(12), 3, RoundingMode.HALF_UP));
        }
    }
}
