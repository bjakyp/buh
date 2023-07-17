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
@Table(name = "ProgrammyElektronnojPodpisiISifrovania", schema = "catalogs")
@Getter
@Setter
public class ProgrammyElektronnojPodpisiISifrovania {
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

	@Column(name = "IMA_PROGRAMMY", length = 430)
    private String imaProgrammy;

	@Column(name = "TIP_PROGRAMMY", precision = 9, scale = 0)
    private BigDecimal tipProgrammy;

	@Column(name = "ALGORITM_PODPISI", length = 100)
    private String algoritmPodpisi;

	@Column(name = "ALGORITM_HESIROVANIA", length = 100)
    private String algoritmHesirovania;

	@Column(name = "ALGORITM_SIFROVANIA", length = 100)
    private String algoritmSifrovania;

	@Column(name = "ETO_PROGRAMMA_OBLACNOGO_SERVISA")
    private Boolean etoProgrammaOblacnogoServisa;

}
