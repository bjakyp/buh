package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_ObrabotcikiObnovlenia")
@Table(name = "ObrabotcikiObnovleniaIr", schema = "informations")
@Getter
@Setter
public class ObrabotcikiObnovlenia extends BaseEntity {
	@Column(name = "IMA_OBRABOTCIKA", length = 255)
    private String imaObrabotcika;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID")
    private kg.infosystems.buhproject.entity.enumerations.StatusyObrabotcikovObnovlenia status;

	@Column(name = "VERSIA", length = 20)
    private String versia;

	@Column(name = "IMA_BIBLIOTEKI", length = 100)
    private String imaBiblioteki;

	@Column(name = "DLITEL1NOST1_OBRABOTKI", precision = 10, scale = 0)
    private BigDecimal dlitel1nost1Obrabotki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REZIM_VYPOLNENIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.RezimyVypolneniaObrabotcikov rezimVypolnenia;

	@Column(name = "VERSIA_REGISTRACII", length = 20)
    private String versiaRegistracii;

	@Column(name = "VERSIA_PORADOK", precision = 11, scale = 0)
    private BigDecimal versiaPoradok;

	@Column(name = "IDENTIFIKATOR")
    private UUID identifikator;

	@Column(name = "CISLO_POPYTOK", precision = 10, scale = 0)
    private BigDecimal cisloPopytok;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATISTIKA_VYPOLNENIA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage statistikaVypolnenia;

	@Column(name = "INFORMACIA_OB_OSIBKE", length = 1024)
    private String informaciaObOsibke;

	@Column(name = "KOMMENTARIJ", length = 1024)
    private String kommentarij;

	@Column(name = "PRIORITET", length = 100)
    private String prioritet;

	@Column(name = "PROCEDURA_PROVERKI", length = 255)
    private String proceduraProverki;

	@Column(name = "PROCEDURA_ZAPOLNENIA_DANNYH_OBNOVLENIA", length = 255)
    private String proceduraZapolneniaDannyhObnovlenia;

	@Column(name = "OCERED1_OTLOZENNOJ_OBRABOTKI", precision = 10, scale = 0)
    private BigDecimal ocered1OtlozennojObrabotki;

	@Column(name = "ZAPUSKAT1_TOL1KO_V_GLAVNOM_UZLE")
    private Boolean zapuskat1Tol1koVGlavnomUzle;

	@Column(name = "ZAPUSKAT1_IV_PODCINENNOM_UZLE_RIBS_FIL1TRAMI")
    private Boolean zapuskat1IVPodcinennomUzleRIBSFil1trami;

	@Column(name = "MNOGOPOTOCNYJ")
    private Boolean mnogopotocnyj;

	@Column(name = "OBRABOTKA_PORCII_ZAVERSENA")
    private Boolean obrabotkaPorciiZaversena;

	@Column(name = "GRUPPA_OBNOVLENIA", precision = 10, scale = 0)
    private BigDecimal gruppaObnovlenia;

	@Column(name = "ITERACIA_ZAPUSKA", precision = 10, scale = 0)
    private BigDecimal iteraciaZapuska;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBRABATYVAEMYE_DANNYE_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage obrabatyvaemyeDannye;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REZIM_VYPOLNENIA_OTLOZENNOGO_OBRABOTCIKA_ID")
    private kg.infosystems.buhproject.entity.enumerations.RezimyVypolneniaOtlozennyhObrabotcikov rezimVypolneniaOtlozennogoObrabotcika;

	@Column(name = "IZMENAEMYE_OB2EKTY", length = 1024)
    private String izmenaemyeOb2ekty;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
