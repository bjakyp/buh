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
@Entity(name = "informations_KodirovkiFajlov")
@Table(name = "KodirovkiFajlovIr", schema = "informations")
@Getter
@Setter
public class KodirovkiFajlov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_ID")
    private kg.infosystems.buhproject.entity.one.Multiple fajl;

	@Column(name = "KODIROVKA", length = 50)
    private String kodirovka;

}
