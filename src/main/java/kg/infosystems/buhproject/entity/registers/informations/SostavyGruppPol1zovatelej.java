package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_SostavyGruppPol1zovatelej")
@Table(name = "SostavyGruppPol1zovatelejIr", schema = "informations")
@Getter
@Setter
public class SostavyGruppPol1zovatelej extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRUPPA_POL1ZOVATELEJ_ID")
	private kg.infosystems.buhproject.entity.one.Multiple gruppaPol1zovatelej;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
	private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@Column(name = "ISPOL1ZUETSA")
	private Boolean ispol1zuetsa;

}
