package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@JmixEntity
@Entity(name = "informations_SkloneniaPredstavlenijOb2ektov")
@Table(name = "SkloneniaPredstavlenijOb2ektovIr", schema = "informations")
@Getter
@Setter
public class SkloneniaPredstavlenijOb2ektov extends BaseEntity {
	@Column(name = "HES_PREDSTAVLENIA", length = 40)
	private String hesPredstavlenia;

	@Column(name = "OB2EKT", length = 10)
	private String ob2ekt;

	@Lob
	@Column(name = "IMENITEL1NYJ_PADEZ")
	private String imenitel1nyjPadez;

	@Lob
	@Column(name = "RODITEL1NYJ_PADEZ")
	private String roditel1nyjPadez;

	@Lob
	@Column(name = "DATEL1NYJ_PADEZ")
	private String datel1nyjPadez;

	@Lob
	@Column(name = "VINITEL1NYJ_PADEZ")
	private String vinitel1nyjPadez;

	@Lob
	@Column(name = "TVORITEL1NYJ_PADEZ")
	private String tvoritel1nyjPadez;

	@Lob
	@Column(name = "PREDLOZNYJ_PADEZ")
	private String predloznyjPadez;

}
