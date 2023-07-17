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
@Entity(name = "informations_GruppyZnacenijDostupa")
@Table(name = "GruppyZnacenijDostupaIr", schema = "informations")
@Getter
@Setter
public class GruppyZnacenijDostupa extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenieDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRUPPA_ZNACENIJ_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple gruppaZnacenijDostupa;

	@Column(name = "GRUPPA_DANNYH", precision = 1, scale = 0)
    private BigDecimal gruppaDannyh;

}
