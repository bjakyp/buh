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
@Entity(name = "informations_OblastiDannyh")
@Table(name = "OblastiDannyhIr", schema = "informations")
@Getter
@Setter
public class OblastiDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID")
    private kg.infosystems.buhproject.entity.enumerations.StatusyOblastejDannyh status;

	@Column(name = "VARIANT", length = 20)
    private String variant;

	@Column(name = "IDENTIFIKATOR_VYGRUZKI")
    private UUID identifikatorVygruzki;

	@Column(name = "OSIBKA_OBRABOTKI")
    private Boolean osibkaObrabotki;

	@Column(name = "POVTOR", precision = 2, scale = 0)
    private BigDecimal povtor;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
