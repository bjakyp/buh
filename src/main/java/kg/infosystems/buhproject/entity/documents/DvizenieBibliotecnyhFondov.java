package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.DvizenieBibliotecnyhFondovBibliotecnyeFondy;
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
@Table(name = "DvizenieBibliotecnyhFondov", schema = "documents")
@Getter
@Setter
public class DvizenieBibliotecnyhFondov {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_OPERACII_ID", nullable = false)
	private kg.infosystems.buhproject.entity.enumerations.VidyOperacijDvizenieBibliotecnyhFondov vidOperacii;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SOBYTIE_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONTRAGENT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOL_OTPRAVITEL1_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica mOLOtpravitel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_OTPRAVITEL1_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenieOtpravitel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOL_POLUCATEL1_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica mOLPolucatel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_POLUCATEL1_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdeleniePolucatel1;

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
	private List<DvizenieBibliotecnyhFondovBibliotecnyeFondy> bibliotecnyeFondy;
}
