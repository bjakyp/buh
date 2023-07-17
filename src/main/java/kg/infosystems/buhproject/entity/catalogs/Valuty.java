package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.catalogs.ValutyPredstavlenia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Valuty", schema = "catalogs")
@Getter
@Setter
public class Valuty {
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

	@Column(name = "KOD", length = 3)
	private String kod;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 10)
	private String naimenovanie;

	@Column(name = "ZAGRUZAETSA_IZ_INTERNETA")
	private Boolean zagruzaetsaIzInterneta;

	@Column(name = "NAIMENOVANIE_POLNOE", length = 50)
	private String naimenovaniePolnoe;

	@Column(name = "NACENKA", precision = 10, scale = 2)
	private BigDecimal nacenka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OSNOVNAA_VALUTA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Valuty osnovnaaValuta;

	@Column(name = "PARAMETRY_PROPISI", length = 200)
	private String parametryPropisi;

	@Column(name = "FORMULA_RASCETA_KURSA", length = 100)
	private String formulaRascetaKursa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_USTANOVKI_KURSA_ID")
	private kg.infosystems.buhproject.entity.enumerations.SposobyUstanovkiKursaValuty sposobUstanovkiKursa;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<ValutyPredstavlenia> predstavlenia;

}
