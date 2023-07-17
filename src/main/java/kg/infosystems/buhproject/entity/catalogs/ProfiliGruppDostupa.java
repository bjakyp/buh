package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.ProfiliGruppDostupaNaznacenie;
import kg.infosystems.buhproject.entity.parts.catalogs.ProfiliGruppDostupaRoli;
import kg.infosystems.buhproject.entity.parts.catalogs.ProfiliGruppDostupaVidyDostupa;
import kg.infosystems.buhproject.entity.parts.catalogs.ProfiliGruppDostupaZnaceniaDostupa;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "ProfiliGruppDostupa", schema = "catalogs")
@Getter
@Setter
public class ProfiliGruppDostupa {
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
	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.ProfiliGruppDostupa roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@Column(name = "IDENTIFIKATOR_POSTAVLAEMYH_DANNYH")
    private UUID identifikatorPostavlaemyhDannyh;

	@Column(name = "POSTAVLAEMYJ_PROFIL1_IZMENEN")
    private Boolean postavlaemyjProfil1Izmenen;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<ProfiliGruppDostupaRoli> roli;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<ProfiliGruppDostupaVidyDostupa> vidyDostupa;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<ProfiliGruppDostupaZnaceniaDostupa> znaceniaDostupa;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<ProfiliGruppDostupaNaznacenie> naznacenie;
}
