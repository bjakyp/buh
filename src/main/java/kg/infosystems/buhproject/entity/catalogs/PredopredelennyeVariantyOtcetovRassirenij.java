package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.PredopredelennyeVariantyOtcetovRassirenijPredstavlenia;
import kg.infosystems.buhproject.entity.parts.catalogs.PredopredelennyeVariantyOtcetovRassirenijRazmesenie;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "PredopredelennyeVariantyOtcetovRassirenij", schema = "catalogs")
@Getter
@Setter
public class PredopredelennyeVariantyOtcetovRassirenij {
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

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.PredopredelennyeVariantyOtcetovRassirenij roditel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovRassirenij otcet;

	@Column(name = "KLUC_VARIANTA", length = 256)
    private String klucVarianta;

	@Column(name = "VKLUCEN")
    private Boolean vklucen;

	@Column(name = "GRUPPIROVAT1_PO_OTCETU")
    private Boolean gruppirovat1PoOtcetu;

	@Column(name = "VIDIMOST1_PO_UMOLCANIU")
    private Boolean vidimost1PoUmolcaniu;

	@Lob
	@Column(name = "OPISANIE")
    private String opisanie;

	@Column(name = "HES_NASTROEK", length = 32)
    private String hesNastroek;

	@Lob
	@Column(name = "NAIMENOVANIA_POLEJ")
    private String naimenovaniaPolej;

	@Lob
	@Column(name = "NAIMENOVANIA_PARAMETROV_I_OTBOROV")
    private String naimenovaniaParametrovIOtborov;

	@Lob
	@Column(name = "KLUCEVYE_SLOVA")
    private String klucevyeSlova;

	@Column(name = "KLUC_ZAMEROV", length = 135)
    private String klucZamerov;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PredopredelennyeVariantyOtcetovRassirenijRazmesenie> razmesenie;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PredopredelennyeVariantyOtcetovRassirenijPredstavlenia> predstavlenia;
}
