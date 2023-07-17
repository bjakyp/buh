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
@Table(name = "Vedomost1ZarabotnojPlatyTablicaVyplat", schema = "parts_documents")
@Getter
@Setter
public class Vedomost1ZarabotnojPlatyTablicaVyplat {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.Vedomost1ZarabotnojPlaty part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@Column(name = "NAIMENOVANIE", length = 20)
	private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANK_ID")
	private kg.infosystems.buhproject.entity.catalogs.Banki bank;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@Column(name = "SUMMA_OSTATOK", precision = 15, scale = 2)
	private BigDecimal summaOstatok;

}
