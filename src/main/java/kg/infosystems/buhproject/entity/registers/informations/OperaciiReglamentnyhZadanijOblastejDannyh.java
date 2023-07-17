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
@Entity(name = "informations_OperaciiReglamentnyhZadanijOblastejDannyh")
@Table(name = "OperaciiReglamentnyhZadanijOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class OperaciiReglamentnyhZadanijOblastejDannyh extends BaseEntity {
	@Column(name = "OPERACIA", length = 200)
    private String operacia;

	@Column(name = "DATA_VYPOLNENIA")
    private LocalDateTime dataVypolnenia;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
