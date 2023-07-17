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
@Table(name = "UcetnyeZapisiSinhronizaciiFajlov", schema = "catalogs")
@Getter
@Setter
public class UcetnyeZapisiSinhronizaciiFajlov {
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

	@Column(name = "NAIMENOVANIE", length = 100)
	private String naimenovanie;

	@Column(name = "SERVIS", length = 100)
	private String servis;

	@Column(name = "KORNEVAA_PAPKA", length = 30)
	private String kornevaaPapka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_FAJLOV_ID")
	private kg.infosystems.buhproject.entity.one.Multiple avtorFajlov;

}
