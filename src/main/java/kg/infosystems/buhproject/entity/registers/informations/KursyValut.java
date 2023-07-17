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
@Entity(name = "informations_KursyValut")
@Table(name = "KursyValutIr", schema = "informations")
@Getter
@Setter
public class KursyValut extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALUTA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Valuty valuta;

	@Column(name = "KURS", precision = 10, scale = 0)
    private BigDecimal kurs;

	@Column(name = "KRATNOST1", precision = 10, scale = 0)
    private BigDecimal kratnost1;

}
