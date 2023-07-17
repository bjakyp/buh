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
@Table(name = "Vedomost1ZarabotnojPlaty", schema = "documents")
@Getter
@Setter
public class Vedomost1ZarabotnojPlaty {
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
	@JoinColumn(name = "BANKOVSKIJ_SCET_ID")
	private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_ZP_PROEKTA_ID")
	private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScetZPProekta;

	@NotNull
	@Column(name = "PERIOD_REGISTRACII", nullable = false)
	private LocalDateTime periodRegistracii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@NotNull
	@Column(name = "VID_VEDOMOSTI", nullable = false, precision = 1, scale = 0)
	private BigDecimal vidVedomosti;

	@Column(name = "VID_DOKUMENTA_VYPLATY", precision = 1, scale = 0)
	private BigDecimal vidDokumentaVyplaty;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KASSA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kassy kassa;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PORADOK_OKRUGLENIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.enumerations.PoradkiOkruglenia poradokOkruglenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetov;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaDokumenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_OPERACII_RKO_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyOperacijRKO vidOperaciiRKO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_OPERACII_PPI_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyOperacijPPI vidOperaciiPPI;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONTRAGENT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_KONTRAGENTA_ID")
	private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScetKontragenta;

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
	private List<Vedomost1ZarabotnojPlatyZarplata> zarplata;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Vedomost1ZarabotnojPlatyRaspredelenie> raspredelenie;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Vedomost1ZarabotnojPlatyTablicaVyplat> tablicaVyplat;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Vedomost1ZarabotnojPlatyItogiPoStat1am> itogiPoStat1am;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Vedomost1ZarabotnojPlatyItogiPoVidamFinansirovania> itogiPoVidamFinansirovania;

	@InstanceName
	@DependsOnProperties({"data", "nomer"})
	public String getInstanceName() {
		return String.format("%s %s", data, nomer);
	}

}
