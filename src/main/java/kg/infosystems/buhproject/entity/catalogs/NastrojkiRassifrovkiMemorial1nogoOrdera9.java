package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaPeredaci;
import kg.infosystems.buhproject.entity.parts.catalogs.NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaPostuplenia;
import kg.infosystems.buhproject.entity.parts.catalogs.NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaSpisania;
import kg.infosystems.buhproject.entity.parts.catalogs.NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaVnutrennegoPeremesenia;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "NastrojkiRassifrovkiMemorial1nogoOrdera9", schema = "catalogs")
@Getter
@Setter
public class NastrojkiRassifrovkiMemorial1nogoOrdera9 {
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

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaPostuplenia> sobytiaPostuplenia;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaVnutrennegoPeremesenia> sobytiaVnutrennegoPeremesenia;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaPeredaci> sobytiaPeredaci;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NastrojkiRassifrovkiMemorial1nogoOrdera9SobytiaSpisania> sobytiaSpisania;
}
