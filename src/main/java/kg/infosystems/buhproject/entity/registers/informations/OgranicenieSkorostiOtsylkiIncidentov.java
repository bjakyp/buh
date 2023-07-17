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
@Entity(name = "informations_OgranicenieSkorostiOtsylkiIncidentov")
@Table(name = "OgranicenieSkorostiOtsylkiIncidentovIr", schema = "informations")
@Getter
@Setter
public class OgranicenieSkorostiOtsylkiIncidentov extends BaseEntity {
	@Column(name = "TIP_INCIDENTA", length = 100)
    private String tipIncidenta;

	@Column(name = "POSLEDNAA_OTSYLKA")
    private LocalDateTime poslednaaOtsylka;

}
