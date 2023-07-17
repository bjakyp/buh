package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.catalogs.ScenariiObmenovDannymiNastrojkiObmena;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "ScenariiObmenovDannymi", schema = "catalogs")
@Getter
@Setter
public class ScenariiObmenovDannymi {
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

	@Column(name = "KOD", length = 5)
	private String kod;

	@Column(name = "NAIMENOVANIE", length = 150)
	private String naimenovanie;

	@Column(name = "ISPOL1ZOVAT1_REGLAMENTNOE_ZADANIE")
	private Boolean ispol1zovat1ReglamentnoeZadanie;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@Column(name = "REGLAMENTNOE_ZADANIE_GUID", length = 40)
	private String reglamentnoeZadanieGUID;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<ScenariiObmenovDannymiNastrojkiObmena> nastrojkiObmena;
}
