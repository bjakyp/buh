package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_ZnaceniaGruppDostupa")
@Table(name = "ZnaceniaGruppDostupaIr", schema = "informations")
@Getter
@Setter
public class ZnaceniaGruppDostupa extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRUPPA_DOSTUPA_ID")
	private kg.infosystems.buhproject.entity.catalogs.GruppyDostupa gruppaDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_DOSTUPA_ID")
	private kg.infosystems.buhproject.entity.one.Multiple znacenieDostupa;

	@Column(name = "ZNACENIE_RAZRESENO")
	private Boolean znacenieRazreseno;

}
