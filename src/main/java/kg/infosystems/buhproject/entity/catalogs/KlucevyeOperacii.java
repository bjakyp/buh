package kg.infosystems.buhproject.entity.catalogs;

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
@Table(name = "KlucevyeOperacii", schema = "catalogs")
@Getter
@Setter
public class KlucevyeOperacii {
	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;

	@Column(name = "VERSIA_DANNYH")
	@Version
    private Integer versiaDannyh;

	@DeletedBy
	@Column(name = "DELETED_BY")
    private String deletedBy;

	@DeletedDate
	@Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@Column(name = "IMA", length = 1000)
    private String ima;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MINIMAL1NO_DOPUSTIMYJ_UROVEN1_ID")
    private kg.infosystems.buhproject.entity.enumerations.UrovniProizvoditel1nosti minimal1noDopustimyjUroven1;

	@Column(name = "PRIORITET", precision = 15, scale = 0)
    private BigDecimal prioritet;

	@Column(name = "CELEVOE_VREMA", precision = 15, scale = 2)
    private BigDecimal celevoeVrema;

	@Column(name = "IMA_HES", length = 40)
    private String imaHes;

	@Column(name = "VYPOLNENA_S_OSIBKOJ")
    private Boolean vypolnenaSOsibkoj;

	@Column(name = "DLITEL1NAA")
    private Boolean dlitel1naa;

}
