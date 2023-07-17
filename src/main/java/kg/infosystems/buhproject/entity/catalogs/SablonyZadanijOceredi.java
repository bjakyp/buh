package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "SablonyZadanijOceredi", schema = "catalogs")
@Getter
@Setter
public class SablonyZadanijOceredi {
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

	@Column(name = "NAIMENOVANIE", length = 150)
	private String naimenovanie;

	@Column(name = "ISPOL1ZOVANIE")
	private Boolean ispol1zovanie;

	@Column(name = "IMA_METODA")
	private String imaMetoda;

	@Column(name = "KLUC", length = 128)
	private String kluc;

	@Column(name = "KOLICESTVO_POVTOROV_PRI_AVARIJNOM_ZAVERSENII", precision = 10, scale = 0)
	private BigDecimal kolicestvoPovtorovPriAvarijnomZaversenii;

	@Column(name = "INTERVAL_POVTORA_PRI_AVARIJNOM_ZAVERSENII", precision = 10, scale = 0)
	private BigDecimal intervalPovtoraPriAvarijnomZaversenii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RASPISANIE_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage raspisanie;

	@Column(name = "IMA")
	private String ima;

}
