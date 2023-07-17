package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.catalogs.VariantyOtcetovPredstavlenia;
import kg.infosystems.buhproject.entity.parts.catalogs.VariantyOtcetovRazmesenie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VariantyOtcetov", schema = "catalogs")
@Getter
@Setter
public class VariantyOtcetov {
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
	private kg.infosystems.buhproject.entity.catalogs.VariantyOtcetov roditel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.one.Multiple avtor;

	@Column(name = "VIDIMOST1_PO_UMOLCANIU")
	private Boolean vidimost1PoUmolcaniu;

	@Column(name = "VIDIMOST1_PO_UMOLCANIU_PEREOPREDELENA")
	private Boolean vidimost1PoUmolcaniuPereopredelena;

	@Column(name = "INTERAKTIVNAA_POMETKA_UDALENIA")
	private Boolean interaktivnaaPometkaUdalenia;

	@Column(name = "KLUC_VARIANTA", length = 256)
	private String klucVarianta;

	@Lob
	@Column(name = "KLUCEVYE_SLOVA")
	private String klucevyeSlova;

	@Column(name = "KONTEKST", length = 430)
	private String kontekst;

	@Lob
	@Column(name = "NAIMENOVANIA_PARAMETROV_I_OTBOROV")
	private String naimenovaniaParametrovIOtborov;

	@Lob
	@Column(name = "NAIMENOVANIA_POLEJ")
	private String naimenovaniaPolej;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKI_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage nastrojki;

	@Lob
	@Column(name = "OPISANIE")
	private String opisanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTCET_ID")
	private kg.infosystems.buhproject.entity.one.Multiple otcet;

	@Column(name = "POL1ZOVATEL1SKIJ")
	private Boolean pol1zovatel1skij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREDOPREDELENNYJ_VARIANT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple predopredelennyjVariant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_OTCETA_ID")
	private kg.infosystems.buhproject.entity.enumerations.TipyOtcetov tipOtceta;

	@Column(name = "TOL1KO_DLA_AVTORA")
	private Boolean tol1koDlaAvtora;

	@Column(name = "HES_NASTROEK", length = 32)
	private String hesNastroek;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<VariantyOtcetovRazmesenie> razmesenie;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<VariantyOtcetovPredstavlenia> predstavlenia;
}
