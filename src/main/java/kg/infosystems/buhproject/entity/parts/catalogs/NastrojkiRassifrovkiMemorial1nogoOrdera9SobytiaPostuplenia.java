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
@Table(name = "NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaPostuplenia", schema = "parts_catalogs")
@Getter
@Setter
public class NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaPostuplenia {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiRassifrovkiMemorial1nogoOrdera9 part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOBYTIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytie;

}
