package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "PrinatieKUcetuOSINMAOS", schema = "parts_documents")
@Getter
@Setter
public class PrinatieKUcetuOSINMAOS {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.PrinatieKUcetuOSINMA part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OSNOVNOE_SREDSTVO_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.OsnovnyeSredstva osnovnoeSredstvo;

	@NotNull
	@Column(name = "INVENTARNYJ_NOMER", nullable = false, length = 20)
	private String inventarnyjNomer;

	@NotNull
	@Column(name = "PERVONACAL1NAA_STOIMOST1", nullable = false, precision = 15, scale = 2)
	private BigDecimal pervonacal1naaStoimost1;

	@NotNull
	@Column(name = "STOIMOST1_DLA_RASCETA_AMORTIZACII", nullable = false, precision = 15, scale = 2)
	private BigDecimal stoimost1DlaRascetaAmortizacii;

	@NotNull
	@Column(name = "SROK_SLUZBY", nullable = false, precision = 10, scale = 0)
	private BigDecimal srokSluzby;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_UCETA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MOL_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica mOL;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PODRAZDELENIE_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SPOSOB_NACISLENIA_AMORTIZACII_ID", nullable = false)
	private kg.infosystems.buhproject.entity.enumerations.SposobyNacisleniaAmortizaciiOSINMA sposobNacisleniaAmortizacii;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SPOSOB_OTRAZENIA_RASHODOV_PO_AMORTIZACII_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaRashodovPoAmortizacii sposobOtrazeniaRashodovPoAmortizacii;

	@NotNull
	@Column(name = "PROCENT_GODOVOJ_AMORTIZACII", nullable = false, precision = 5, scale = 2)
	private BigDecimal procentGodovojAmortizacii;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRAFIK_AMORTIZACII_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.GrafikiAmortizacii grafikAmortizacii;

}
