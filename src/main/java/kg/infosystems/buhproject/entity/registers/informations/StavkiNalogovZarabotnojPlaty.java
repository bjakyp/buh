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
@Entity(name = "informations_StavkiNalogovZarabotnojPlaty")
@Table(name = "StavkiNalogovZarabotnojPlatyIr", schema = "informations")
@Getter
@Setter
public class StavkiNalogovZarabotnojPlaty extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID")
    private kg.infosystems.buhproject.entity.catalogs.Statusy status;

	@Column(name = "STAVKA_PFR", precision = 5, scale = 2)
    private BigDecimal stavkaPFR;

	@Column(name = "STAVKA_PN", precision = 5, scale = 2)
    private BigDecimal stavkaPN;

	@Column(name = "STAVKA_PFF", precision = 5, scale = 2)
    private BigDecimal stavkaPFF;

	@Column(name = "STAVKA_FOTF", precision = 5, scale = 2)
    private BigDecimal stavkaFOTF;

	@Column(name = "STAVKA_MSF", precision = 5, scale = 2)
    private BigDecimal stavkaMSF;

	@Column(name = "STAVKA_MSR", precision = 5, scale = 2)
    private BigDecimal stavkaMSR;

	@Column(name = "STAVKA_GNPFR", precision = 5, scale = 2)
    private BigDecimal stavkaGNPFR;

	@Column(name = "VYCETY", precision = 5, scale = 2)
    private BigDecimal vycety;

	@Column(name = "NE_VYCITAT1_PF")
    private Boolean neVycitat1PF;

}
