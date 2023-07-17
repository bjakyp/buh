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
@Entity(name = "informations_NastrojkiKomandPecati")
@Table(name = "NastrojkiKomandPecatiIr", schema = "informations")
@Getter
@Setter
public class NastrojkiKomandPecati extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_ID")
    private kg.infosystems.buhproject.entity.one.Multiple vladelec;

	@Column(name = "UNIKAL1NYJ_IDENTIFIKATOR", length = 32)
    private String unikal1nyjIdentifikator;

	@Column(name = "VIDIMOST1")
    private Boolean vidimost1;

}
