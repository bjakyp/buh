package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_UcetnaaPolitikaPoPersonalu")
@Table(name = "UcetnaaPolitikaPoPersonaluIr", schema = "informations")
@Getter
@Setter
public class UcetnaaPolitikaPoPersonalu extends BaseEntity {
	@Column(name = "PERIOD")
	private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_PN_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovPN;

	@Column(name = "OTBRASYVAT1_TYJYNY_OBLAGAEMOJ_BAZY_PN")
	private Boolean otbrasyvat1TyjynyOblagaemojBazyPN;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_PENSIONNOGO_FONDA_S_RABOTNIKA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovPensionnogoFondaSRabotnika;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_PENSIONNOGO_FONDA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovPensionnogoFonda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_MEDSTRAHOVANIA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovMedstrahovania;

	@Column(name = "MINIMAL1NYJ_FOND_OPLATY_TRUDA_SOC_FOND", precision = 15, scale = 2)
	private BigDecimal minimal1nyjFondOplatyTrudaSocFond;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_FONDA_OZDOROVLENIA_TRUDASIHSA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovFondaOzdorovleniaTrudasihsa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_GOSUDARSTVENNOGO_NAKOPITEL1NOGO_PF_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovGosudarstvennogoNakopitel1nogoPF;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOLICESTVO_SOTRUDNIKOV_DLA_OTCETA_SF_ID")
	private kg.infosystems.buhproject.entity.enumerations.KolicestvoSotrudnikovDlaOtcetaSF kolicestvoSotrudnikovDlaOtcetaSF;

	@Column(name = "VOZVRAT_OT_RABOTNIKA_OTRICATEL1NOJ_SUMMOJ")
	private Boolean vozvratOtRabotnikaOtricatel1nojSummoj;

	@Column(name = "PO_VIDAM_FINANSIROVANIA")
	private Boolean poVidamFinansirovania;

	@Column(name = "PO_PROCENTAM")
	private Boolean poProcentam;

	@Column(name = "RAJONNYJ_KOEFFICIENT_S_OTPUSKNYH", precision = 5, scale = 2)
	private BigDecimal rajonnyjKoefficientSOtpusknyh;

	@Column(name = "RASCET_PN_BEZ_NAKOPLENIA")
	private Boolean rascetPNBezNakoplenia;

}
