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
@Entity(name = "informations_NalicieFajlov")
@Table(name = "NalicieFajlovIr", schema = "informations")
@Getter
@Setter
public class NalicieFajlov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_S_FAJLAMI_ID")
    private kg.infosystems.buhproject.entity.one.Multiple ob2ektSFajlami;

	@Column(name = "EST1_FAJLY")
    private Boolean est1Fajly;

	@Column(name = "IDENTIFIKATOR_OB2EKTA", length = 10)
    private String identifikatorOb2ekta;

}
