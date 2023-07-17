package kg.infosystems.buhproject.entity.parts.catalogs;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "ProfiliKlucevyhOperacijKlucevyeOperaciiProfila", schema = "parts_catalogs")
@Getter
@Setter
public class ProfiliKlucevyhOperacijKlucevyeOperaciiProfila {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.ProfiliKlucevyhOperacij part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUCEVAA_OPERACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KlucevyeOperacii klucevaaOperacia;

	@Column(name = "CELEVOE_VREMA", precision = 5, scale = 1)
    private BigDecimal celevoeVrema;

	@Column(name = "PRIORITET", precision = 5, scale = 0)
    private BigDecimal prioritet;

}
