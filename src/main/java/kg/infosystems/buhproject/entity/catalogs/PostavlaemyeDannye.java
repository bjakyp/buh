package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.PostavlaemyeDannyeHarakteristikiDannyh;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "PostavlaemyeDannye", schema = "catalogs")
@Getter
@Setter
public class PostavlaemyeDannye {
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

	@Column(name = "VID_DANNYH", length = 20)
    private String vidDannyh;

	@Column(name = "DATA_DOBAVLENIA")
    private LocalDateTime dataDobavlenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANIMYJ_FAJL_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hranimyjFajl;

	@Lob
	@Column(name = "PUT1_K_FAJLU")
    private String put1KFajlu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOM_ID")
    private kg.infosystems.buhproject.entity.catalogs.TomaHraneniaFajlov tom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_HRANENIA_FAJLA_ID")
    private kg.infosystems.buhproject.entity.enumerations.TipyHraneniaFajlov tipHraneniaFajla;

	@Column(name = "IDENTIFIKATOR_FAJLA")
    private UUID identifikatorFajla;

	@Lob
	@Column(name = "OPISANIE")
    private String opisanie;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostavlaemyeDannyeHarakteristikiDannyh> harakteristikiDannyh;
}
