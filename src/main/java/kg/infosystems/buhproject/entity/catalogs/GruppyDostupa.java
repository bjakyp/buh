package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.GruppyDostupaPol1zovateli;
import kg.infosystems.buhproject.entity.parts.catalogs.GruppyDostupaVidyDostupa;
import kg.infosystems.buhproject.entity.parts.catalogs.GruppyDostupaZnaceniaDostupa;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "GruppyDostupa", schema = "catalogs")
@Getter
@Setter
public class GruppyDostupa {
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
    private kg.infosystems.buhproject.entity.catalogs.GruppyDostupa roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFIL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.ProfiliGruppDostupa profil1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTVETSTVENNYJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli otvetstvennyj;

	@Column(name = "OSNOVNAA_GRUPPA_DOSTUPA_POSTAVLAEMOGO_PROFILA")
    private Boolean osnovnaaGruppaDostupaPostavlaemogoProfila;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<GruppyDostupaPol1zovateli> pol1zovateli;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<GruppyDostupaVidyDostupa> vidyDostupa;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<GruppyDostupaZnaceniaDostupa> znaceniaDostupa;
}
