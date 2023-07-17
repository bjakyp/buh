package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_KesProgrammnyhInterfejsov")
@Table(name = "KesProgrammnyhInterfejsovIr", schema = "informations")
@Getter
@Setter
public class KesProgrammnyhInterfejsov extends BaseEntity {
	@Column(name = "IDENTIFIKATOR", length = 400)
	private String identifikator;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_DANNYH_ID")
	private kg.infosystems.buhproject.entity.enumerations.TipyDannyhKesaProgrammnyhInterfejsov tipDannyh;

	@Column(name = "DATA_OBNOVLENIA")
	private LocalDateTime dataObnovlenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DANNYE_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage dannye;

}
