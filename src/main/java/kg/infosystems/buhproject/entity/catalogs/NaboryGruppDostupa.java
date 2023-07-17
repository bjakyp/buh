package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.NaboryGruppDostupaGruppy;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "NaboryGruppDostupa", schema = "catalogs")
@Getter
@Setter
public class NaboryGruppDostupa {
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

	@Column(name = "NAIMENOVANIE", length = 80)
    private String naimenovanie;

	@Column(name = "DLA_VNESNIH_POL1ZOVATELEJ")
    private Boolean dlaVnesnihPol1zovatelej;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_ELEMENTOV_NABORA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple tipElementovNabora;

	@Column(name = "HES", precision = 10, scale = 0)
    private BigDecimal hes;

	@Column(name = "NE_ISPOL1ZUETSA_S")
    private LocalDateTime neIspol1zuetsaS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RAZRESENNYJ_NABOR_GRUPP_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryGruppDostupa razresennyjNaborGruppDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RAZRESENNYJ_NABOR_GRUPP_POL1ZOVATELEJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryGruppDostupa razresennyjNaborGruppPol1zovatelej;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOVYJ_NABOR_GRUPP_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryGruppDostupa novyjNaborGruppDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOVYJ_NABOR_GRUPP_POL1ZOVATELEJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryGruppDostupa novyjNaborGruppPol1zovatelej;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NaboryGruppDostupaGruppy> gruppy;
}
