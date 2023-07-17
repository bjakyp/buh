package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_ParametryUcetaOS")
@Table(name = "ParametryUcetaOSIr", schema = "informations")
@Getter
@Setter
public class ParametryUcetaOS extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGISTRATOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registrator;

	@Column(name = "PERIOD")
    private LocalDateTime period;

	@Column(name = "NOMER_STROKI", precision = 9, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "AKTIVNOST1")
    private Boolean aktivnost1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OSNOVNOE_SREDSTVO_ID")
    private kg.infosystems.buhproject.entity.catalogs.OsnovnyeSredstva osnovnoeSredstvo;

	@Column(name = "INVENTARNYJ_NOMER", length = 20)
    private String inventarnyjNomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@Column(name = "LIKVIDACIONNAA_STOIMOST1", precision = 15, scale = 2)
    private BigDecimal likvidacionnaaStoimost1;

	@Column(name = "SROK_SLUZBY", precision = 10, scale = 0)
    private BigDecimal srokSluzby;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_NACISLENIA_AMORTIZACII_ID")
    private kg.infosystems.buhproject.entity.enumerations.SposobyNacisleniaAmortizaciiOSINMA sposobNacisleniaAmortizacii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_OTRAZENIA_RASHODOV_PO_AMORTIZACII_ID")
    private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaRashodovPoAmortizacii sposobOtrazeniaRashodovPoAmortizacii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARAMETR_VYRABOTKI_ID")
    private kg.infosystems.buhproject.entity.catalogs.ParametryVyrabotkiOS parametrVyrabotki;

	@Column(name = "OB2EM_PRODUKCII", precision = 10, scale = 0)
    private BigDecimal ob2emProdukcii;

	@Column(name = "KOEFFICIENT_AMORTIZACII", precision = 5, scale = 2)
    private BigDecimal koefficientAmortizacii;

	@Column(name = "KOEFFICIENT_USKORENIA", precision = 4, scale = 2)
    private BigDecimal koefficientUskorenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_POSTUPLENIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.SposobyPostupleniaOS sposobPostuplenia;

	@Column(name = "DATA_VVODA_V_EKSPLUATACIU")
    private LocalDateTime dataVvodaVEkspluataciu;

	@Column(name = "PERVONACAL1NAA_STOIMOST1", precision = 15, scale = 2)
    private BigDecimal pervonacal1naaStoimost1;

	@Column(name = "STOIMOST1_DLA_RASCETA_AMORTIZACII", precision = 15, scale = 2)
    private BigDecimal stoimost1DlaRascetaAmortizacii;

	@Column(name = "KONSERVACIA")
    private Boolean konservacia;

	@Column(name = "PROCENT_GODOVOJ_AMORTIZACII", precision = 5, scale = 2)
    private BigDecimal procentGodovojAmortizacii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRAFIK_AMORTIZACII_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiAmortizacii grafikAmortizacii;

}
