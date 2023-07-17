package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.FajlyDopolnitel1nyeRekvizity;
import kg.infosystems.buhproject.entity.parts.catalogs.FajlyUdalit1SertifikatySifrovania;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "Fajly", schema = "catalogs")
@Getter
@Setter
public class Fajly {
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

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple avtor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_FAJLA_ID")
    private kg.infosystems.buhproject.entity.catalogs.PapkiFajlov vladelecFajla;

	@Column(name = "DATA_ZAEMA")
    private LocalDateTime dataZaema;

	@Column(name = "DATA_MODIFIKACII_UNIVERSAL1NAA")
    private LocalDateTime dataModifikaciiUniversal1naa;

	@Column(name = "DATA_SOZDANIA")
    private LocalDateTime dataSozdania;

	@Column(name = "ZASIFROVAN")
    private Boolean zasifrovan;

	@Column(name = "INDEKS_KARTINKI", precision = 10, scale = 0)
    private BigDecimal indeksKartinki;

	@Lob
	@Column(name = "OPISANIE")
    private String opisanie;

	@Column(name = "PODPISAN_EP")
    private Boolean podpisanEP;

	@Column(name = "UDALIT1_POLNOE_NAIMENOVANIE", length = 256)
    private String udalit1PolnoeNaimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REDAKTIRUET_ID")
    private kg.infosystems.buhproject.entity.one.Multiple redaktiruet;

	@Column(name = "SLUZEBNYJ")
    private Boolean sluzebnyj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEKST_HRANILISE_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage tekstHranilise;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEKUSAA_VERSIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VersiiFajlov tekusaaVersia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IZMENIL_ID")
    private kg.infosystems.buhproject.entity.one.Multiple izmenil;

	@Column(name = "UDALIT1_TEKUSAA_VERSIA_DATA_MODIFIKACII_FAJLA")
    private LocalDateTime udalit1TekusaaVersiaDataModifikaciiFajla;

	@Column(name = "UDALIT1_TEKUSAA_VERSIA_DATA_SOZDANIA")
    private LocalDateTime udalit1TekusaaVersiaDataSozdania;

	@Column(name = "UDALIT1_TEKUSAA_VERSIA_KOD", length = 11)
    private String udalit1TekusaaVersiaKod;

	@Column(name = "UDALIT1_TEKUSAA_VERSIA_NOMER_VERSII", precision = 5, scale = 0)
    private BigDecimal udalit1TekusaaVersiaNomerVersii;

	@Lob
	@Column(name = "PUT1_K_FAJLU")
    private String put1KFajlu;

	@Column(name = "RAZMER", precision = 10, scale = 0)
    private BigDecimal razmer;

	@Column(name = "RASSIRENIE", length = 10)
    private String rassirenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOM_ID")
    private kg.infosystems.buhproject.entity.catalogs.TomaHraneniaFajlov tom;

	@Column(name = "HRANIT1_VERSII")
    private Boolean hranit1Versii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_HRANENIA_FAJLA_ID")
    private kg.infosystems.buhproject.entity.enumerations.TipyHraneniaFajlov tipHraneniaFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_IZVLECENIA_TEKSTA_ID")
    private kg.infosystems.buhproject.entity.enumerations.StatusyIzvleceniaTekstaFajlov statusIzvleceniaTeksta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_HRANILISE_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage fajlHranilise;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<FajlyDopolnitel1nyeRekvizity> dopolnitel1nyeRekvizity;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<FajlyUdalit1SertifikatySifrovania> udalit1SertifikatySifrovania;
}
