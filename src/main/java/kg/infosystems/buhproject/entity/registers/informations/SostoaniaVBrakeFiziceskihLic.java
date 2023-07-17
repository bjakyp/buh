package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SostoaniaVBrakeFiziceskihLic")
@Table(name = "SostoaniaVBrakeFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class SostoaniaVBrakeFiziceskihLic extends BaseEntity {
	@Column(name = "PERIOD")
	private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTOANIE_V_BRAKE_ID")
	private kg.infosystems.buhproject.entity.catalogs.SostoanieVBrake sostoanieVBrake;

}
