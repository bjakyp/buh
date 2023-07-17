package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.SpisanieOSINMAKomissia;
import kg.infosystems.buhproject.entity.parts.documents.SpisanieOSINMANMA;
import kg.infosystems.buhproject.entity.parts.documents.SpisanieOSINMAOS;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "SpisanieOSINMA", schema = "documents")
@Getter
@Setter
public class SpisanieOSINMA {
	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;

	@Column(name = "VERSIA_DANNYH")
	@Version
	private Integer versiaDannyh;

	@DeletedBy
	@Column(name = "DELETED_BY")
	private String deletedBy;

	@DeletedDate
	@Column(name = "DELETED_DATE")
	private LocalDateTime deletedDate;

	@NotNull
	@Column(name = "DATA", nullable = false)
	private LocalDateTime data;

	@Column(name = "NOMER", length = 9)
	private String nomer;

	@Column(name = "PROVEDEN")
	private Boolean proveden;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ORGANIZACIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SOBYTIE_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytie;

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
	@JoinColumn(name = "SCET_ZATRAT_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetZatrat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ZATRAT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1aZatrat;

	@Column(name = "NE_UKAZYVAT1_STOIMOSTI")
	private Boolean neUkazyvat1Stoimosti;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOMISSIA_PO_SPISANIU_OS_ID")
	private kg.infosystems.buhproject.entity.enumerations.VidyNaznacenijKomissijSpisaniaOS komissiaPoSpisaniuOS;

	@Column(name = "DATA_SPISANIA")
	private LocalDateTime dataSpisania;

	@Column(name = "NOMER_SPISANIA", length = 30)
	private String nomerSpisania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRICINA_SPISANIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.PricinySpisaniaOSINMA pricinaSpisania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_OSNOVANIE_ID")
	private kg.infosystems.buhproject.entity.documents.InventarizaciaOS dokumentOsnovanie;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<SpisanieOSINMAOS> os;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<SpisanieOSINMANMA> nma;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<SpisanieOSINMAKomissia> komissia;
}
