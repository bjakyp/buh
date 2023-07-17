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
@Entity(name = "informations_NomeraOtskanirovannyhFajlov")
@Table(name = "NomeraOtskanirovannyhFajlovIr", schema = "informations")
@Getter
@Setter
public class NomeraOtskanirovannyhFajlov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_ID")
    private kg.infosystems.buhproject.entity.one.Multiple vladelec;

	@Column(name = "NOMER", precision = 9, scale = 0)
    private BigDecimal nomer;

}
