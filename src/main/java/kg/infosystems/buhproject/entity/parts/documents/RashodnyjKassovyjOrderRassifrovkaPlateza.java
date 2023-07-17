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
@Table(name = "RashodnyjKassovyjOrderRassifrovkaPlateza", schema = "parts_documents")
@Getter
@Setter
public class RashodnyjKassovyjOrderRassifrovkaPlateza {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.RashodnyjKassovyjOrder part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_ZADOLZENNOSTI_ID")
	private kg.infosystems.buhproject.entity.enumerations.VidyZadolzennosti vidZadolzennosti;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KASSA_BANK_ID")
	private kg.infosystems.buhproject.entity.one.Multiple kassaBank;

	@NotNull
	@Column(name = "SUMMA_PLATEZA", nullable = false, precision = 15, scale = 2)
	private BigDecimal summaPlateza;

}
