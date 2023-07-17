package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.PostuplenieTovarovUslugNMA;
import kg.infosystems.buhproject.entity.parts.documents.PostuplenieTovarovUslugOS;
import kg.infosystems.buhproject.entity.parts.documents.PostuplenieTovarovUslugTovary;
import kg.infosystems.buhproject.entity.parts.documents.PostuplenieTovarovUslugUslugi;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "PostuplenieTovarovUslug", schema = "documents")
@Getter
@Setter
public class PostuplenieTovarovUslug {
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
	@JoinColumn(name = "VID_OPERACII_ID", nullable = false)
	private kg.infosystems.buhproject.entity.enumerations.VidyOperacijPostuplenia vidOperacii;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "KONTRAGENT_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SKLAD_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Sklady sklad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_OS_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenieOS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_NMA_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenieNMA;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_PO_TOVARAM_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovPoTovaram;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_PO_USLUGAM_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovPoUslugam;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_PO_OS_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovPoOS;

	@Column(name = "PATENT", length = 200)
	private String patent;

	@Column(name = "VLADELEC", length = 200)
	private String vladelec;

	@Column(name = "NOMER_PATENTA", length = 200)
	private String nomerPatenta;

	@Column(name = "INN", length = 200)
	private String iNN;

	@Column(name = "PASPORT", length = 200)
	private String pasport;

	@Column(name = "ADRES", length = 200)
	private String adres;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOBYTIE_OS_ID")
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytieOS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOBYTIE_NMA_ID")
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytieNMA;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOBYTIE_S_TOVARAMI_ID")
	private kg.infosystems.buhproject.entity.catalogs.SobytiaSTovarami sobytieSTovarami;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_OSNOVANIE_ID")
	private kg.infosystems.buhproject.entity.documents.Doverennost1 dokumentOsnovanie;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaDokumenta;

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
	private List<PostuplenieTovarovUslugTovary> tovary;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostuplenieTovarovUslugUslugi> uslugi;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostuplenieTovarovUslugOS> os;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostuplenieTovarovUslugNMA> nma;
}
