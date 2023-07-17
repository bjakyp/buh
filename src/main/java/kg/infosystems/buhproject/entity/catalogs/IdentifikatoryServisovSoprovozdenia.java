package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "IdentifikatoryServisovSoprovozdenia", schema = "catalogs")
@Getter
@Setter
public class IdentifikatoryServisovSoprovozdenia {
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

	@Lob
	@Column(name = "URL_OPISANIE")
	private String uRLOpisanie;

	@Lob
	@Column(name = "URL_USLOVIA_POLUCENIA")
	private String uRLUsloviaPolucenia;

	@Column(name = "IDENTIFIKATOR_KARTINKI")
	private String identifikatorKartinki;

	@Column(name = "IDENTIFIKATOR_SERVISA")
	private String identifikatorServisa;

	@Column(name = "OPISANIE", length = 150)
	private String opisanie;

}
