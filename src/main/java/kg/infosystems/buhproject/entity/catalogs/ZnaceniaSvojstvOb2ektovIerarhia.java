package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.ZnaceniaSvojstvOb2ektovIerarhiaPredstavlenia;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "ZnaceniaSvojstvOb2ektovIerarhia", schema = "catalogs")
@Getter
@Setter
public class ZnaceniaSvojstvOb2ektovIerarhia {
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
    private kg.infosystems.buhproject.entity.characteristics.Dopolnitel1nyeRekvizityISvedenia vladelec;

	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.ZnaceniaSvojstvOb2ektovIerarhia roditel1;

	@Column(name = "VES", precision = 10, scale = 2)
    private BigDecimal ves;

	@Lob
	@Column(name = "POLNOE_NAIMENOVANIE")
    private String polnoeNaimenovanie;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<ZnaceniaSvojstvOb2ektovIerarhiaPredstavlenia> predstavlenia;
}
