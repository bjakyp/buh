package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_BezopasnoeHraniliseDannyhOblastejDannyh")
@Table(name = "BezopasnoeHraniliseDannyhOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class BezopasnoeHraniliseDannyhOblastejDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_ID")
	private kg.infosystems.buhproject.entity.one.Multiple vladelec;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DANNYE_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage dannye;

}
