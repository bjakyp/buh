package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "KlassifikatorEdinicIzmerenia", schema = "catalogs")
@Getter
@Setter
public class KlassifikatorEdinicIzmerenia {
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

	@Column(name = "KOD", length = 4)
	private String kod;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 25)
	private String naimenovanie;

	@Column(name = "NAIMENOVANIE_POLNOE", length = 100)
	private String naimenovaniePolnoe;

	@Column(name = "MEZDUNARODNOE_SOKRASENIE", length = 3)
	private String mezdunarodnoeSokrasenie;

}
