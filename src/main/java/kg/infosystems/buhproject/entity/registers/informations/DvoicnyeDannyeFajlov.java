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
@Entity(name = "informations_DvoicnyeDannyeFajlov")
@Table(name = "DvoicnyeDannyeFajlovIr", schema = "informations")
@Getter
@Setter
public class DvoicnyeDannyeFajlov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_ID")
    private kg.infosystems.buhproject.entity.one.Multiple fajl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DVOICNYE_DANNYE_FAJLA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dvoicnyeDannyeFajla;

}
