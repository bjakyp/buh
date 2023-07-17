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
@Entity(name = "informations_NastrojkiOtpravitela")
@Table(name = "NastrojkiOtpravitelaIr", schema = "informations")
@Getter
@Setter
public class NastrojkiOtpravitela extends BaseEntity {
	@Column(name = "KANAL_SOOBSENIJ", length = 150)
    private String kanalSoobsenij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLUCATEL1_ID")
    private kg.infosystems.buhproject.entity.publications.ObmenSoobseniami polucatel1;

}
