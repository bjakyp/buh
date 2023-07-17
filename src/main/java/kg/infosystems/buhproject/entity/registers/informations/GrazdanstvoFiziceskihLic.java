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
@Entity(name = "informations_GrazdanstvoFiziceskihLic")
@Table(name = "GrazdanstvoFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class GrazdanstvoFiziceskihLic extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STRANA_ID")
    private kg.infosystems.buhproject.entity.catalogs.StranyMira strana;

}
