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
@Table(name = "Subkonto", schema = "catalogs")
@Getter
@Setter
public class Subkonto {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_ID")
    private kg.infosystems.buhproject.entity.characteristics.VidySubkontoHozrascetnye vladelec;

	@Column(name = "KOD", length = 9)
    private String kod;

	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Subkonto roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

}
