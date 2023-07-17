package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_VremennyeIdentifikatoryZaprosov")
@Table(name = "VremennyeIdentifikatoryZaprosovIr", schema = "informations")
@Getter
@Setter
public class VremennyeIdentifikatoryZaprosov extends BaseEntity {
	@Column(name = "IDENTIFIKATOR", length = 64)
	private String identifikator;

	@Column(name = "DATA")
	private LocalDateTime data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZAPROS_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage zapros;

}
