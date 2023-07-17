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
@Entity(name = "informations_ObsieNastrojkiUzlovInformacionnyhBaz")
@Table(name = "ObsieNastrojkiUzlovInformacionnyhBazIr", schema = "informations")
@Getter
@Setter
public class ObsieNastrojkiUzlovInformacionnyhBaz extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
    private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@Column(name = "VYPOLNIT1_KORREKTIROVKU_INFORMACII_SOPOSTAVLENIA")
    private Boolean vypolnit1KorrektirovkuInformaciiSopostavlenia;

	@Column(name = "NACAL1NAA_VYGRUZKA_DANNYH")
    private Boolean nacal1naaVygruzkaDannyh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UDALIT1_POL1ZOVATEL1_DLA_SINHRONIZACII_DANNYH_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli udalit1Pol1zovatel1DlaSinhronizaciiDannyh;

	@Column(name = "VYPOLNIT1_OTPRAVKU_DANNYH")
    private Boolean vypolnit1OtpravkuDannyh;

	@Column(name = "NASTROJKA_ZAVERSENA")
    private Boolean nastrojkaZaversena;

	@Column(name = "NACAL1NYJ_OBRAZ_SOZDAN")
    private Boolean nacal1nyjObrazSozdan;

	@Column(name = "SOOBSENIE_DLA_SOPOSTAVLENIA_DANNYH", length = 36)
    private String soobsenieDlaSopostavleniaDannyh;

	@Column(name = "VERSIA_KORRESPONDENTA", length = 16)
    private String versiaKorrespondenta;

	@Column(name = "NOMER_OTPRAVLENNOGO", precision = 10, scale = 0)
    private BigDecimal nomerOtpravlennogo;

	@Column(name = "NOMER_OTPRAVLENNOGO_NACAL1NAA_VYGRUZKA_DANNYH", precision = 10, scale = 0)
    private BigDecimal nomerOtpravlennogoNacal1naaVygruzkaDannyh;

	@Column(name = "PREFIKS", length = 2)
    private String prefiks;

	@Column(name = "PREFIKS_KORRESPONDENTA", length = 2)
    private String prefiksKorrespondenta;

}
