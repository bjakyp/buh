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
@Table(name = "DvizenieBibliotecnyhFondovBibliotecnyeFondy", schema = "parts_documents")
@Getter
@Setter
public class DvizenieBibliotecnyhFondovBibliotecnyeFondy {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.DvizenieBibliotecnyhFondov part;

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

	@NotNull
	@Column(name = "KOLICESTVO", nullable = false, precision = 15, scale = 3)
	private BigDecimal kolicestvo;

	@Column(name = "CENA", precision = 15, scale = 2)
	private BigDecimal cena;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

}
