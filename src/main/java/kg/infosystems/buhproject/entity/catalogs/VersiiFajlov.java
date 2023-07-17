package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.catalogs.VersiiFajlovUdalit1ElektronnyePodpisi;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VersiiFajlov", schema = "catalogs")
@Getter
@Setter
public class VersiiFajlov {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_ID")
	private kg.infosystems.buhproject.entity.catalogs.Fajly vladelec;

	@Column(name = "KOD", length = 11)
	private String kod;

	@Column(name = "NAIMENOVANIE", length = 150)
	private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.one.Multiple avtor;

	@Column(name = "DATA_MODIFIKACII_UNIVERSAL1NAA")
	private LocalDateTime dataModifikaciiUniversal1naa;

	@Column(name = "DATA_MODIFIKACII_FAJLA")
	private LocalDateTime dataModifikaciiFajla;

	@Column(name = "DATA_SOZDANIA")
	private LocalDateTime dataSozdania;

	@Column(name = "UDALIT1_ZASIFROVAN")
	private Boolean udalit1Zasifrovan;

	@Column(name = "INDEKS_KARTINKI", precision = 10, scale = 0)
	private BigDecimal indeksKartinki;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@Column(name = "NOMER_VERSII", precision = 5, scale = 0)
	private BigDecimal nomerVersii;

	@Column(name = "UDALIT1_PODPISAN_EP")
	private Boolean udalit1PodpisanEP;

	@Column(name = "POLNOE_NAIMENOVANIE", length = 256)
	private String polnoeNaimenovanie;

	@Lob
	@Column(name = "PUT1_K_FAJLU")
	private String put1KFajlu;

	@Column(name = "RAZMER", precision = 10, scale = 0)
	private BigDecimal razmer;

	@Column(name = "RASSIRENIE", length = 10)
	private String rassirenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1SKAA_VERSIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.VersiiFajlov roditel1skaaVersia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_IZVLECENIA_TEKSTA_ID")
	private kg.infosystems.buhproject.entity.enumerations.StatusyIzvleceniaTekstaFajlov statusIzvleceniaTeksta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEKST_HRANILISE_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage tekstHranilise;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_HRANENIA_FAJLA_ID")
	private kg.infosystems.buhproject.entity.enumerations.TipyHraneniaFajlov tipHraneniaFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOM_ID")
	private kg.infosystems.buhproject.entity.catalogs.TomaHraneniaFajlov tom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_HRANILISE_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage fajlHranilise;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<VersiiFajlovUdalit1ElektronnyePodpisi> udalit1ElektronnyePodpisi;
}
