package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.NomenklaturaPrisoedinennyeFajlyElektronnyePodpisi;
import kg.infosystems.buhproject.entity.parts.catalogs.NomenklaturaPrisoedinennyeFajlySertifikatySifrovania;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "NomenklaturaPrisoedinennyeFajly", schema = "catalogs")
@Getter
@Setter
public class NomenklaturaPrisoedinennyeFajly {
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

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple avtor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_FAJLA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Nomenklatura vladelecFajla;

	@Column(name = "DATA_ZAEMA")
    private LocalDateTime dataZaema;

	@Column(name = "DATA_MODIFIKACII_UNIVERSAL1NAA")
    private LocalDateTime dataModifikaciiUniversal1naa;

	@Column(name = "DATA_SOZDANIA")
    private LocalDateTime dataSozdania;

	@Column(name = "ZASIFROVAN")
    private Boolean zasifrovan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IZMENIL_ID")
    private kg.infosystems.buhproject.entity.one.Multiple izmenil;

	@Column(name = "INDEKS_KARTINKI", precision = 10, scale = 0)
    private BigDecimal indeksKartinki;

	@Lob
	@Column(name = "OPISANIE")
    private String opisanie;

	@Column(name = "PODPISAN_EP")
    private Boolean podpisanEP;

	@Lob
	@Column(name = "PUT1_K_FAJLU")
    private String put1KFajlu;

	@Column(name = "RAZMER", precision = 10, scale = 0)
    private BigDecimal razmer;

	@Column(name = "RASSIRENIE", length = 10)
    private String rassirenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REDAKTIRUET_ID")
    private kg.infosystems.buhproject.entity.one.Multiple redaktiruet;

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

	@Column(name = "HRANIT1_VERSII")
    private Boolean hranit1Versii;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NomenklaturaPrisoedinennyeFajlyElektronnyePodpisi> elektronnyePodpisi;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NomenklaturaPrisoedinennyeFajlySertifikatySifrovania> sertifikatySifrovania;
}
