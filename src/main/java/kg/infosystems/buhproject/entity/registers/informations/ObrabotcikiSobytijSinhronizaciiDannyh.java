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
@Entity(name = "informations_ObrabotcikiSobytijSinhronizaciiDannyh")
@Table(name = "ObrabotcikiSobytijSinhronizaciiDannyhIr", schema = "informations")
@Getter
@Setter
public class ObrabotcikiSobytijSinhronizaciiDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
    private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@Column(name = "SOBYTIE", length = 50)
    private String sobytie;

	@Column(name = "OBRABOTCIK", length = 50)
    private String obrabotcik;

}
