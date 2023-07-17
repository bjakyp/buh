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
@Entity(name = "informations_IncidentyOtkrytye")
@Table(name = "IncidentyOtkrytyeIr", schema = "informations")
@Getter
@Setter
public class IncidentyOtkrytye extends BaseEntity {
	@Column(name = "TIP_INCIDENTA", length = 100)
    private String tipIncidenta;

	@Column(name = "KOD_INCIDENTA", length = 100)
    private String kodIncidenta;

	@Column(name = "INCIDENT_AKTUALEN")
    private Boolean incidentAktualen;

}
