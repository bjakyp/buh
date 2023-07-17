package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_BezopasnoeHraniliseDannyh")
@Table(name = "BezopasnoeHraniliseDannyhIr", schema = "informations")
@Getter
@Setter
public class BezopasnoeHraniliseDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_ID")
	private kg.infosystems.buhproject.entity.one.Multiple vladelec;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DANNYE_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage dannye;

}
