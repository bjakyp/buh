package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.ObrabotcikiOcerediZadanijMetody;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "ObrabotcikiOcerediZadanij", schema = "catalogs")
@Getter
@Setter
public class ObrabotcikiOcerediZadanij {
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

	@Column(name = "NAIMENOVANIE", length = 50)
    private String naimenovanie;

	@Column(name = "ISPOL1ZOVANIE")
    private Boolean ispol1zovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RASPISANIE_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage raspisanie;

	@Column(name = "KOLICESTVO_ZADANIJ", precision = 2, scale = 0)
    private BigDecimal kolicestvoZadanij;

	@Column(name = "DLITEL1NOST1_ZADANIA", precision = 4, scale = 0)
    private BigDecimal dlitel1nost1Zadania;

	@Column(name = "AVTO")
    private Boolean avto;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<ObrabotcikiOcerediZadanijMetody> metody;
}
