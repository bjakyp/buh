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
@Entity(name = "informations_DannyeOb2ektovDlaRegistraciiVObmenah")
@Table(name = "DannyeOb2ektovDlaRegistraciiVObmenahIr", schema = "informations")
@Getter
@Setter
public class DannyeOb2ektovDlaRegistraciiVObmenah extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SSYLKA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple ssylka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
    private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

}
