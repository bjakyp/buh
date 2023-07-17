package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "SmetaRashodovGruppyStatej", schema = "parts_documents")
@Getter
@Setter
public class SmetaRashodovGruppyStatej {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.SmetaRashodov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

	@Column(name = "ANVAR1", precision = 15, scale = 2)
	private BigDecimal anvar1;

	@Column(name = "FEVRAL1", precision = 15, scale = 2)
	private BigDecimal fevral1;

	@Column(name = "MART", precision = 15, scale = 2)
	private BigDecimal mart;

	@Column(name = "KVARTAL1", precision = 15, scale = 2)
	private BigDecimal kvartal1;

	@Column(name = "APREL1", precision = 15, scale = 2)
	private BigDecimal aprel1;

	@Column(name = "MAJ", precision = 15, scale = 2)
	private BigDecimal maj;

	@Column(name = "IUN1", precision = 15, scale = 2)
	private BigDecimal iun1;

	@Column(name = "KVARTAL2", precision = 15, scale = 2)
	private BigDecimal kvartal2;

	@Column(name = "IUL1", precision = 15, scale = 2)
	private BigDecimal iul1;

	@Column(name = "AVGUST", precision = 15, scale = 2)
	private BigDecimal avgust;

	@Column(name = "SENTABR1", precision = 15, scale = 2)
	private BigDecimal sentabr1;

	@Column(name = "KVARTAL3", precision = 15, scale = 2)
	private BigDecimal kvartal3;

	@Column(name = "OKTABR1", precision = 15, scale = 2)
	private BigDecimal oktabr1;

	@Column(name = "NOABR1", precision = 15, scale = 2)
	private BigDecimal noabr1;

	@Column(name = "DEKABR1", precision = 15, scale = 2)
	private BigDecimal dekabr1;

	@Column(name = "KVARTAL4", precision = 15, scale = 2)
	private BigDecimal kvartal4;

	@Column(name = "SUMMA_ZA_GOD", precision = 15, scale = 2)
	private BigDecimal summaZaGod;

	@Column(name = "SODERZANIE", length = 300)
	private String soderzanie;

}
