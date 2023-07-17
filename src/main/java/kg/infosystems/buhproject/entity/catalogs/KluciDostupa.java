package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "KluciDostupa", schema = "catalogs")
@Getter
@Setter
public class KluciDostupa {
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

	@Column(name = "NAIMENOVANIE", length = 36)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPISOK_ID")
    private kg.infosystems.buhproject.entity.one.Multiple spisok;

	@Column(name = "DLA_VNESNIH_POL1ZOVATELEJ")
    private Boolean dlaVnesnihPol1zovatelej;

	@Column(name = "HES", precision = 10, scale = 0)
    private BigDecimal hes;

	@Column(name = "SOSTAV_POLEJ", precision = 17, scale = 0)
    private BigDecimal sostavPolej;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenie1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE2_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenie2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE3_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenie3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE4_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenie4;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE5_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenie5;

	@Column(name = "NE_ISPOL1ZUETSA_S")
    private LocalDateTime neIspol1zuetsaS;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<KluciDostupaSapka> sapka;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<KluciDostupaTablicnaaCast11> tablicnaaCast11;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<KluciDostupaTablicnaaCast12> tablicnaaCast12;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<KluciDostupaTablicnaaCast13> tablicnaaCast13;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<KluciDostupaTablicnaaCast14> tablicnaaCast14;
}
