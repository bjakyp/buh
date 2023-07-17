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
@Entity(name = "informations_FIOFiziceskihLic")
@Table(name = "FIOFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class FIOFiziceskihLic extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@Column(name = "FAMILIA", length = 50)
    private String familia;

	@Column(name = "IMA", length = 50)
    private String ima;

	@Column(name = "OTCESTVO", length = 50)
    private String otcestvo;

	@Column(name = "OSNOVANIE", length = 1024)
    private String osnovanie;

}
