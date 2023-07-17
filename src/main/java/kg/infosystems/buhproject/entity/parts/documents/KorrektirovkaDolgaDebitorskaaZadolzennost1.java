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
@Table(name = "KorrektirovkaDolgaDebitorskaaZadolzennost1", schema = "parts_documents")
@Getter
@Setter
public class KorrektirovkaDolgaDebitorskaaZadolzennost1 {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.KorrektirovkaDolga part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@NotNull
	@Column(name = "SUMMA", nullable = false, precision = 15, scale = 2)
	private BigDecimal summa;

	@NotNull
	@Column(name = "SUMMA_UCETNAA", nullable = false, precision = 15, scale = 2)
	private BigDecimal summaUcetnaa;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_UCETA_RASCETOV_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUcetaRascetov;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "KOR_SCET_UCETA_RASCETOV_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj korScetUcetaRascetov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

}
