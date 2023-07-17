package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Entity(name = "informations_ZaprosyRazresenijNaIspol1zovanieVnesnihResursov")
@Table(name = "ZaprosyRazresenijNaIspol1zovanieVnesnihResursovIr", schema = "informations")
@Getter
@Setter
public class ZaprosyRazresenijNaIspol1zovanieVnesnihResursov extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_ZAPROSA")
	private UUID identifikatorZaprosa;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OPERACIA_ID")
	private kg.infosystems.buhproject.entity.enumerations.OperaciiAdministrirovaniaProfilejBezopasnosti operacia;

	@Lob
	@Column(name = "IMA")
	private String ima;

	@Column(name = "REZIM_ZAMESENIA")
	private Boolean rezimZamesenia;

	@Lob
	@Column(name = "DOBAVLAEMYE_RAZRESENIA")
	private String dobavlaemyeRazresenia;

	@Lob
	@Column(name = "UDALAEMYE_RAZRESENIA")
	private String udalaemyeRazresenia;

	@Column(name = "ZAPROS_ADMINISTRIROVANIA")
	private Boolean zaprosAdministrirovania;

}
