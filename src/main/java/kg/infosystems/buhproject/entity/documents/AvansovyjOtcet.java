package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.*;
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
@Table(name = "AvansovyjOtcet", schema = "documents")
@Getter
@Setter
public class AvansovyjOtcet {
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
	@JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_RASCETOV_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetov;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaDokumenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SKLAD_ID")
	private kg.infosystems.buhproject.entity.catalogs.Sklady sklad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_OS_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenieOS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_NMA_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenieNMA;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_BIBLIOTECNYH_FONDOV_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenieBibliotecnyhFondov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOL_BIBLIOTECNYH_FONDOV_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica mOLBibliotecnyhFondov;

	@Column(name = "KOLICESTVO_LISTOV_V_PRILOZENII", precision = 10, scale = 0)
	private BigDecimal kolicestvoListovVPrilozenii;

	@Column(name = "KOLICESTVO_DOKUMENTOV_V_PRILOZENII", precision = 10, scale = 0)
	private BigDecimal kolicestvoDokumentovVPrilozenii;

	@Column(name = "PO_VEDOMOSTI")
	private Boolean poVedomosti;

	@Column(name = "OSTATOK_NA_NACALO", precision = 15, scale = 2)
	private BigDecimal ostatokNaNacalo;

	@Column(name = "IZRASHODOVANO", precision = 15, scale = 2)
	private BigDecimal izrashodovano;

	@Column(name = "OSTATOK_NA_KONEC", precision = 15, scale = 2)
	private BigDecimal ostatokNaKonec;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOBYTIE_S_TOVARAMI_ID")
	private kg.infosystems.buhproject.entity.catalogs.SobytiaSTovarami sobytieSTovarami;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_OSNOVANIE_ID")
	private kg.infosystems.buhproject.entity.one.Multiple dokumentOsnovanie;

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
	private List<AvansovyjOtcetAvansyRassifrovka> avansyRassifrovka;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<AvansovyjOtcetTovary> tovary;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<AvansovyjOtcetOplata> oplata;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<AvansovyjOtcetProcee> procee;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<AvansovyjOtcetVyplataZP> vyplataZP;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<AvansovyjOtcetOS> os;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<AvansovyjOtcetNMA> nma;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<AvansovyjOtcetBibliotecnyeFondy> bibliotecnyeFondy;
}
