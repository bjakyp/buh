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
@Entity(name = "informations_ProsmotrennyeDannyeInformacionnogoCentra")
@Table(name = "ProsmotrennyeDannyeInformacionnogoCentraIr", schema = "informations")
@Getter
@Setter
public class ProsmotrennyeDannyeInformacionnogoCentra extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli pol1zovatel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DANNYE_INFORMACIONNOGO_CENTRA_ID")
    private kg.infosystems.buhproject.entity.catalogs.ObsieDannyeInformacionnogoCentra dannyeInformacionnogoCentra;

	@Column(name = "PROSMOTRENY")
    private Boolean prosmotreny;

}
