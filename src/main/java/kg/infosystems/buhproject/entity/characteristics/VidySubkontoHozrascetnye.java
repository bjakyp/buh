package kg.infosystems.buhproject.entity.characteristics;

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
@Table(name = "VidySubkontoHozrascetnye", schema = "characteristics")
@Getter
@Setter
public class VidySubkontoHozrascetnye {
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

	@Column(name = "TIP_ZNACENIA")
	private byte[] tipZnacenia;

	@Column(name = "KOD", length = 6)
	private String kod;

	@Column(name = "NAIMENOVANIE", length = 50)
	private String naimenovanie;

}
