package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "TomaHraneniaFajlov", schema = "catalogs")
@Getter
@Setter
public class TomaHraneniaFajlov {
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

	@Column(name = "KOD", length = 9)
	private String kod;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 150)
	private String naimenovanie;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@Column(name = "MAKSIMAL1NYJ_RAZMER", precision = 10, scale = 0)
	private BigDecimal maksimal1nyjRazmer;

	@Lob
	@Column(name = "POLNYJ_PUT1_LINUX")
	private String polnyjPut1Linux;

	@Lob
	@Column(name = "POLNYJ_PUT1_WINDOWS")
	private String polnyjPut1Windows;

	@Column(name = "PORADOK_ZAPOLNENIA", precision = 3, scale = 0)
	private BigDecimal poradokZapolnenia;

}
