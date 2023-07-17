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
@Table(name = "PeredacaOSINMAOS", schema = "parts_documents")
@Getter
@Setter
public class PeredacaOSINMAOS {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.PeredacaOSINMA part;

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

	@Column(name = "INVENTARNYJ_NOMER", length = 20)
	private String inventarnyjNomer;

	@Column(name = "STOIMOST1", precision = 15, scale = 2)
	private BigDecimal stoimost1;

	@Column(name = "NAKOPLENNAA_AMORTIZACIA", precision = 15, scale = 2)
	private BigDecimal nakoplennaaAmortizacia;

	@Column(name = "OSTATOCNAA_STOIMOST1", precision = 15, scale = 2)
	private BigDecimal ostatocnaaStoimost1;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_DOHODA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDohoda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_DOHODA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1aDohoda;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_RASHODA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRashoda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_RASHODA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1aRashoda;

}
