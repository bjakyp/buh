package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.PrinatieKUcetuOSINMAKomissia;
import kg.infosystems.buhproject.entity.parts.documents.PrinatieKUcetuOSINMANMA;
import kg.infosystems.buhproject.entity.parts.documents.PrinatieKUcetuOSINMAOS;
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
@Table(name = "PrinatieKUcetuOSINMA", schema = "documents")
@Getter
@Setter
public class PrinatieKUcetuOSINMA {
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
	@JoinColumn(name = "VID_OPERACII_ID", nullable = false)
	private kg.infosystems.buhproject.entity.enumerations.VidyOperacijPrinatieKUcetuOSINMA vidOperacii;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SOBYTIE_OS_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytieOS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONTRAGENT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_POSTUPLENIA_ID")
	private kg.infosystems.buhproject.entity.enumerations.SposobyPostupleniaOS sposobPostuplenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOMENKLATURA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Nomenklatura nomenklatura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SKLAD_ID")
	private kg.infosystems.buhproject.entity.catalogs.Sklady sklad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_STROITEL1STVA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Ob2ektyStroitel1stva ob2ektStroitel1stva;

	@Column(name = "SKRYT1_STOIMOST1")
	private Boolean skryt1Stoimost1;

	@Column(name = "NA_OSNOVANII", length = 200)
	private String naOsnovanii;

	@Column(name = "NOMER_OSNOVANIA", length = 30)
	private String nomerOsnovania;

	@Column(name = "DATA_OSNOVANIA")
	private LocalDateTime dataOsnovania;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaDokumenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_OSNOVANIE_ID")
	private kg.infosystems.buhproject.entity.one.Multiple dokumentOsnovanie;

	@Column(name = "KOLICESTVO_SPISYVAEMOGO_TOVARA", precision = 15, scale = 3)
	private BigDecimal kolicestvoSpisyvaemogoTovara;

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
	private List<PrinatieKUcetuOSINMAOS> os;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrinatieKUcetuOSINMANMA> nma;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrinatieKUcetuOSINMAKomissia> komissia;
}
