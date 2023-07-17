package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.Dopolnitel1nyeOtcetyIObrabotkiKomandy;
import kg.infosystems.buhproject.entity.parts.catalogs.Dopolnitel1nyeOtcetyIObrabotkiNaznacenie;
import kg.infosystems.buhproject.entity.parts.catalogs.Dopolnitel1nyeOtcetyIObrabotkiRazdely;
import kg.infosystems.buhproject.entity.parts.catalogs.Dopolnitel1nyeOtcetyIObrabotkiRazresenia;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "Dopolnitel1nyeOtcetyIObrabotki", schema = "catalogs")
@Getter
@Setter
public class Dopolnitel1nyeOtcetyIObrabotki {
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
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dopolnitel1nyeOtcetyIObrabotki roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@Column(name = "BEZOPASNYJ_REZIM")
    private Boolean bezopasnyjRezim;

	@Column(name = "VERSIA", length = 10)
    private String versia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyDopolnitel1nyhOtcetovIObrabotok vid;

	@Column(name = "IMA_OB2EKTA", length = 256)
    private String imaOb2ekta;

	@Column(name = "IMA_FAJLA", length = 260)
    private String imaFajla;

	@Column(name = "INFORMACIA", length = 1024)
    private String informacia;

	@Column(name = "ISPOL1ZOVAT1_DLA_FORMY_OB2EKTA")
    private Boolean ispol1zovat1DlaFormyOb2ekta;

	@Column(name = "ISPOL1ZOVAT1_DLA_FORMY_SPISKA")
    private Boolean ispol1zovat1DlaFormySpiska;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTVETSTVENNYJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli otvetstvennyj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PUBLIKACIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VariantyPublikaciiDopolnitel1nyhOtcetovIObrabotok publikacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_NASTROEK_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseNastroek;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_OBRABOTKI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseObrabotki;

	@Column(name = "ISPOL1ZUET_HRANILISE_VARIANTOV")
    private Boolean ispol1zuetHraniliseVariantov;

	@Column(name = "TESNAA_INTEGRACIA_S_FORMOJ_OTCETA")
    private Boolean tesnaaIntegraciaSFormojOtceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REZIM_SOVMESTIMOSTI_RAZRESENIJ_ID")
    private kg.infosystems.buhproject.entity.enumerations.RezimySovmestimostiRazresenijDopolnitel1nyhOtcetovIObrabotok rezimSovmestimostiRazresenij;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Dopolnitel1nyeOtcetyIObrabotkiKomandy> komandy;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Dopolnitel1nyeOtcetyIObrabotkiNaznacenie> naznacenie;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Dopolnitel1nyeOtcetyIObrabotkiRazdely> razdely;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Dopolnitel1nyeOtcetyIObrabotkiRazresenia> razresenia;
}
