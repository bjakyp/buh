package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.parts.documents.NacislenieZarplatyPoSrednemuZarabotkuSrednijZarabotok;
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
@Table(name = "NacislenieZarplatyPoSrednemuZarabotku", schema = "documents")
@Getter
@Setter
public class NacislenieZarplatyPoSrednemuZarabotku {
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
	@JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@NotNull
	@Column(name = "DATA_NACALA", nullable = false)
	private LocalDateTime dataNacala;

	@NotNull
	@Column(name = "DATA_OKONCANIA", nullable = false)
	private LocalDateTime dataOkoncania;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_RASCETA_ID", nullable = false)
	private VidyNacislenij vidRasceta;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SPOSOB_OTRAZENIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty sposobOtrazenia;

	@Column(name = "DNEJ", precision = 4, scale = 0)
	private BigDecimal dnej;

	@Column(name = "REZUL1TAT", precision = 15, scale = 2)
	private BigDecimal rezul1tat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRAFIK_RABOTY_ID")
	private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOLZNOST1_ID")
	private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_OSNOVANIE_ID")
	private kg.infosystems.buhproject.entity.documents.Komandirovka dokumentOsnovanie;

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
	private List<NacislenieZarplatyPoSrednemuZarabotkuSrednijZarabotok> srednijZarabotok;

	@InstanceName
	@DependsOnProperties({"data", "nomer"})
	public String getInstanceName() {
		return String.format("%s %s", data, nomer);
	}

}
