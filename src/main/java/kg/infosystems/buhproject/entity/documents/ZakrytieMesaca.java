package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "ZakrytieMesaca", schema = "documents")
@Getter
@Setter
public class ZakrytieMesaca {
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

	@Column(name = "DATA")
	private LocalDateTime data;

	@Column(name = "NOMER", length = 9)
	private String nomer;

	@Column(name = "PROVEDEN")
	private Boolean proveden;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@Column(name = "NACISLENIE_AMORTIZACII_OSINMA")
	private Boolean nacislenieAmortizaciiOSINMA;

	@Column(name = "ZAKRYTIE_NA_SVOD_DOHODOV_I_RASHODOV")
	private Boolean zakrytieNaSvodDohodovIRashodov;

	@Column(name = "ZAKRYTIE_NA_FINANSOVYJ_REZUL1TAT")
	private Boolean zakrytieNaFinansovyjRezul1tat;

	@Column(name = "ZAKRYTIE_PARNYH_SCETOV")
	private Boolean zakrytieParnyhScetov;

	@Lob
	@Column(name = "NADPIS1_NACISLENIE_AMORTIZACII_OSINMA")
	private String nadpis1NacislenieAmortizaciiOSINMA;

	@Lob
	@Column(name = "NADPIS1_ZAKRYTIE_NA_SVOD_DOHODOV_I_RASHODOV")
	private String nadpis1ZakrytieNaSvodDohodovIRashodov;

	@Lob
	@Column(name = "NADPIS1_ZAKRYTIE_NA_FINANSOVYJ_REZUL1TAT")
	private String nadpis1ZakrytieNaFinansovyjRezul1tat;

	@Lob
	@Column(name = "NADPIS1_ZAKRYTIE_PARNYH_SCETOV")
	private String nadpis1ZakrytieParnyhScetov;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

}
