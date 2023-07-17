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
@Entity(name = "informations_PsevdonimyPredopredelennyhUzlov")
@Table(name = "PsevdonimyPredopredelennyhUzlovIr", schema = "informations")
@Getter
@Setter
public class PsevdonimyPredopredelennyhUzlov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KORRESPONDENT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple korrespondent;

	@Column(name = "KOD_UZLA", length = 36)
    private String kodUzla;

}
