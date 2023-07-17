package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_SootvetstviaOb2ektovInformacionnyhBaz")
@Table(name = "SootvetstviaOb2ektovInformacionnyhBazIr", schema = "informations")
@Getter
@Setter
public class SootvetstviaOb2ektovInformacionnyhBaz extends BaseEntity {
	@Column(name = "UNIKAL1NYJ_IDENTIFIKATOR_PRIEMNIKA", length = 36)
	private String unikal1nyjIdentifikatorPriemnika;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIKAL1NYJ_IDENTIFIKATOR_ISTOCNIKA_ID")
	private kg.infosystems.buhproject.entity.one.Multiple unikal1nyjIdentifikatorIstocnika;

	@Column(name = "TIP_PRIEMNIKA", length = 100)
	private String tipPriemnika;

	@Column(name = "TIP_ISTOCNIKA", length = 100)
	private String tipIstocnika;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
	private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@Column(name = "UNIKAL1NYJ_IDENTIFIKATOR_ISTOCNIKA_STROKOJ", length = 36)
	private String unikal1nyjIdentifikatorIstocnikaStrokoj;

	@Column(name = "OB2EKT_VYGRUZEN_PO_SSYLKE")
	private Boolean ob2ektVygruzenPoSsylke;

}
