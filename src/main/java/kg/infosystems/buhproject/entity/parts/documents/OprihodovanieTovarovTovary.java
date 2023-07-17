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
@Table(name = "OprihodovanieTovarovTovary", schema = "parts_documents")
@Getter
@Setter
public class OprihodovanieTovarovTovary {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.OprihodovanieTovarov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOMENKLATURA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Nomenklatura nomenklatura;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
	private BigDecimal kolicestvo;

	@Column(name = "CENA", precision = 15, scale = 2)
	private BigDecimal cena;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_UCETA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_OPRIHODOVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetOprihodovania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

}
