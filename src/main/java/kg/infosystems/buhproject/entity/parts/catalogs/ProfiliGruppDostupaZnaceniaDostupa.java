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
@Table(name = "ProfiliGruppDostupaZnaceniaDostupa", schema = "parts_catalogs")
@Getter
@Setter
public class ProfiliGruppDostupaZnaceniaDostupa {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.ProfiliGruppDostupa part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple vidDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenieDostupa;

	@Column(name = "VKLUCAA_NIZESTOASIE")
    private Boolean vklucaaNizestoasie;

}
