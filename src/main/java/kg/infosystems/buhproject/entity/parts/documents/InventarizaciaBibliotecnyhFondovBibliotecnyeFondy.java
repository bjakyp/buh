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
@Table(name = "InventarizaciaBibliotecnyhFondovBibliotecnyeFondy", schema = "parts_documents")
@Getter
@Setter
public class InventarizaciaBibliotecnyhFondovBibliotecnyeFondy {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.InventarizaciaBibliotecnyhFondov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IZDANIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.BibliotecnyeFondy izdanie;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_UCETA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KORRESPONDIRUUSIJ_SCET_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj korrespondiruusijScet;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
	private BigDecimal kolicestvo;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@Column(name = "UCETNOE_KOLICESTVO", precision = 15, scale = 3)
	private BigDecimal ucetnoeKolicestvo;

	@Column(name = "UCETNAA_SUMMA", precision = 15, scale = 2)
	private BigDecimal ucetnaaSumma;

	@Column(name = "KOLICESTVO_OTKLONENIE", precision = 15, scale = 3)
	private BigDecimal kolicestvoOtklonenie;

	@Column(name = "SUMMA_OTKLONENIE", precision = 15, scale = 2)
	private BigDecimal summaOtklonenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

}
