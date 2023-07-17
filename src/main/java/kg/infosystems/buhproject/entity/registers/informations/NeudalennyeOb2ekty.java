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
@Entity(name = "informations_NeudalennyeOb2ekty")
@Table(name = "NeudalennyeOb2ektyIr", schema = "informations")
@Getter
@Setter
public class NeudalennyeOb2ekty extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple ob2ekt;

	@Column(name = "KOLICESTVO_POPYTOK", precision = 10, scale = 0)
    private BigDecimal kolicestvoPopytok;

	@Column(name = "VREMA_POSLEDNEJ_POPYTKI")
    private LocalDateTime vremaPoslednejPopytki;

}
