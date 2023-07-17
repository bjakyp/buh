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
@Entity(name = "informations_ObnovlenieKlucejDostupaTekusieZadania")
@Table(name = "ObnovlenieKlucejDostupaTekusieZadaniaIr", schema = "informations")
@Getter
@Setter
public class ObnovlenieKlucejDostupaTekusieZadania extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_POTOKA")
    private UUID identifikatorPotoka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARAMETRY_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage parametry;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REZUL1TAT_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage rezul1tat;

	@Column(name = "ETO_ZAPUSK")
    private Boolean etoZapusk;

	@Column(name = "DATA_IZMENENIA_ZAPISI_REGISTRA")
    private LocalDateTime dataIzmeneniaZapisiRegistra;

}
