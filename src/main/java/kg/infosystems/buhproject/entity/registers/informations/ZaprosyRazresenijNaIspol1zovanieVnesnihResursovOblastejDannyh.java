package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity(name = "informations_ZaprosyRazresenijNaIspol1zovanieVnesnihResursovOblastejDannyh")
@Table(name = "ZaprosyRazresenijNaIspol1zovanieVnesnihResursovOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class ZaprosyRazresenijNaIspol1zovanieVnesnihResursovOblastejDannyh extends BaseEntity {
	@Column(name = "IDENTIFIKATORY_ZAPROSOV")
	private UUID identifikatoryZaprosov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_PROGRAMMNOGO_MODULA_ID")
	private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh tipProgrammnogoModula;

	@Column(name = "IDENTIFIKATOR_PROGRAMMNOGO_MODULA")
	private UUID identifikatorProgrammnogoModula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_VLADEL1CA_ID")
	private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh tipVladel1ca;

	@Column(name = "IDENTIFIKATOR_VLADEL1CA")
	private UUID identifikatorVladel1ca;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BEZOPASNYJ_REZIM_ID")
	private kg.infosystems.buhproject.entity.one.Multiple bezopasnyjRezim;

	@Column(name = "REZIM_ZAMESENIA")
	private Boolean rezimZamesenia;

	@Lob
	@Column(name = "DOBAVLAEMYE_RAZRESENIA")
	private String dobavlaemyeRazresenia;

	@Lob
	@Column(name = "UDALAEMYE_RAZRESENIA")
	private String udalaemyeRazresenia;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
	private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
