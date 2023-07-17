package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_Udalit1HranimyeFajlyVersij")
@Table(name = "Udalit1HranimyeFajlyVersijIr", schema = "informations")
@Getter
@Setter
public class Udalit1HranimyeFajlyVersij extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VERSIA_FAJLA_ID")
	private kg.infosystems.buhproject.entity.catalogs.VersiiFajlov versiaFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANIMYJ_FAJL_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage hranimyjFajl;

}
