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
@Entity(name = "informations_Ocered1RassirenijDlaOpovesenij")
@Table(name = "Ocered1RassirenijDlaOpovesenijIr", schema = "informations")
@Getter
@Setter
public class Ocered1RassirenijDlaOpovesenij extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli pol1zovatel1;

	@Column(name = "IDENTIFIKATOR_RASSIRENIA")
    private UUID identifikatorRassirenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTOANIE_ID")
    private kg.infosystems.buhproject.entity.enumerations.SostoaniaRassirenij sostoanie;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
