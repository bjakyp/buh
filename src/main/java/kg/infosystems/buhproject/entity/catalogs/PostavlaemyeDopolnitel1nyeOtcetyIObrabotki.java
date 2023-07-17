package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.PostavlaemyeDopolnitel1nyeOtcetyIObrabotkiKomandy;
import kg.infosystems.buhproject.entity.parts.catalogs.PostavlaemyeDopolnitel1nyeOtcetyIObrabotkiRazresenia;
import kg.infosystems.buhproject.entity.parts.catalogs.PostavlaemyeDopolnitel1nyeOtcetyIObrabotkiSovmestimost1;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "PostavlaemyeDopolnitel1nyeOtcetyIObrabotki", schema = "catalogs")
@Getter
@Setter
public class PostavlaemyeDopolnitel1nyeOtcetyIObrabotki {
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

	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyDopolnitel1nyhOtcetovIObrabotok vid;

	@Column(name = "ISPOL1ZOVAT1_DLA_FORMY_OB2EKTA")
    private Boolean ispol1zovat1DlaFormyOb2ekta;

	@Column(name = "ISPOL1ZOVAT1_DLA_FORMY_SPISKA")
    private Boolean ispol1zovat1DlaFormySpiska;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PUBLIKACIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VariantyPublikaciiDopolnitel1nyhOtcetovIObrabotok publikacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRICINA_OTKLUCENIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.PricinyOtkluceniaDopolnitel1nyhOtcetovIObrabotokVModeliServisa pricinaOtklucenia;

	@Column(name = "INFORMACIA", length = 1024)
    private String informacia;

	@Column(name = "VERSIA", length = 10)
    private String versia;

	@Column(name = "BEZOPASNYJ_REZIM")
    private Boolean bezopasnyjRezim;

	@Column(name = "IMA_OB2EKTA", length = 256)
    private String imaOb2ekta;

	@Column(name = "IMA_FAJLA", length = 260)
    private String imaFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_OBRABOTKI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseObrabotki;

	@Column(name = "HRANILISE_VARIANTOV", length = 150)
    private String hraniliseVariantov;

	@Column(name = "VERSIA_GUID")
    private UUID versiaGUID;

	@Column(name = "KONTROLIROVAT1_SOVMESTIMOST1_S_VERSIAMI_KONFIGURACII")
    private Boolean kontrolirovat1Sovmestimost1SVersiamiKonfiguracii;

	@Column(name = "ISPOL1ZUET_HRANILISE_VARIANTOV")
    private Boolean ispol1zuetHraniliseVariantov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REZIM_SOVMESTIMOSTI_RAZRESENIJ_ID")
    private kg.infosystems.buhproject.entity.enumerations.RezimySovmestimostiRazresenijDopolnitel1nyhOtcetovIObrabotok rezimSovmestimostiRazresenij;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostavlaemyeDopolnitel1nyeOtcetyIObrabotkiKomandy> komandy;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostavlaemyeDopolnitel1nyeOtcetyIObrabotkiSovmestimost1> sovmestimost1;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostavlaemyeDopolnitel1nyeOtcetyIObrabotkiRazresenia> razresenia;
}
