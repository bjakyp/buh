package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_SessiiObmenaSoobseniamiSistemy")
@Table(name = "SessiiObmenaSoobseniamiSistemyIr", schema = "informations")
@Getter
@Setter
public class SessiiObmenaSoobseniamiSistemy extends BaseEntity {
	@Column(name = "SESSIA")
    private UUID sessia;

	@Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

	@Column(name = "ZAVERSENA_USPESNO")
    private Boolean zaversenaUspesno;

	@Column(name = "ZAVERSENA_S_OSIBKOJ")
    private Boolean zaversenaSOsibkoj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DANNYE_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dannye;

}
