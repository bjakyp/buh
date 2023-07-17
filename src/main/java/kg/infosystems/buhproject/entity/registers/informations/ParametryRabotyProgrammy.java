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
@Entity(name = "informations_ParametryRabotyProgrammy")
@Table(name = "ParametryRabotyProgrammyIr", schema = "informations")
@Getter
@Setter
public class ParametryRabotyProgrammy extends BaseEntity {
	@Column(name = "IMA_PARAMETRA", length = 128)
    private String imaParametra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_PARAMETRA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseParametra;

}
