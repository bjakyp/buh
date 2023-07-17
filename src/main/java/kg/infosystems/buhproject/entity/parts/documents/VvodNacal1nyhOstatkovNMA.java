package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VvodNacal1nyhOstatkovNMA", schema = "parts_documents")
@Getter
@Setter
public class VvodNacal1nyhOstatkovNMA {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.VvodNacal1nyhOstatkov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEMATERIAL1NYJ_AKTIV_ID")
	private kg.infosystems.buhproject.entity.catalogs.Nematerial1nyeAktivy nematerial1nyjAktiv;

	@Column(name = "INVENTARNYJ_NOMER", length = 20)
	private String inventarnyjNomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOL_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica mOL;

	@Column(name = "DATA_PRINATIA_K_UCETU")
	private LocalDateTime dataPrinatiaKUcetu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOBYTIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytie;

	@Column(name = "VID_DOKUMENTA", length = 100)
	private String vidDokumenta;

	@Column(name = "NOMER_DOKUMENTA", precision = 10, scale = 0)
	private BigDecimal nomerDokumenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_POSTUPLENIA_ID")
	private kg.infosystems.buhproject.entity.enumerations.SposobyPostupleniaOS sposobPostuplenia;

	@Column(name = "PERVONACAL1NAA_STOIMOST1", precision = 15, scale = 2)
	private BigDecimal pervonacal1naaStoimost1;

	@Column(name = "STOIMOST1_DLA_RASCETA_AMORTIZACII", precision = 15, scale = 2)
	private BigDecimal stoimost1DlaRascetaAmortizacii;

	@Column(name = "NAKOPLENNAA_AMORTIZACIA", precision = 15, scale = 2)
	private BigDecimal nakoplennaaAmortizacia;

	@Column(name = "SROK_SLUZBY", precision = 10, scale = 0)
	private BigDecimal srokSluzby;

	@Column(name = "PROCENT_GODOVOJ_AMORTIZACII", precision = 5, scale = 2)
	private BigDecimal procentGodovojAmortizacii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_NACISLENIA_AMORTIZACII_ID")
	private kg.infosystems.buhproject.entity.enumerations.SposobyNacisleniaAmortizaciiOSINMA sposobNacisleniaAmortizacii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_OTRAZENIA_RASHODOV_PO_AMORTIZACII_ID")
	private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaRashodovPoAmortizacii sposobOtrazeniaRashodovPoAmortizacii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRAFIK_AMORTIZACII_ID")
	private kg.infosystems.buhproject.entity.catalogs.GrafikiAmortizacii grafikAmortizacii;

}
