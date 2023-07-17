package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "BuhgalterskijBalansBalans", schema = "parts_documents")
@Getter
@Setter
public class BuhgalterskijBalansBalans {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.BuhgalterskijBalans part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@Column(name = "NAIMENOVANIE", length = 100)
	private String naimenovanie;

	@Column(name = "KOD", length = 100)
	private String kod;

	@Column(name = "PRILOZENIE", length = 100)
	private String prilozenie;

	@Column(name = "ITOGO_NA_NACALO", precision = 15, scale = 2)
	private BigDecimal itogoNaNacalo;

	@Column(name = "ITOGO_NA_KONEC", precision = 15, scale = 2)
	private BigDecimal itogoNaKonec;

	@Column(name = "BUDZETNYE_SREDSTVA_NA_NACALO", precision = 15, scale = 2)
	private BigDecimal budzetnyeSredstvaNaNacalo;

	@Column(name = "BUDZETNYE_SREDSTVA_NA_KONEC", precision = 15, scale = 2)
	private BigDecimal budzetnyeSredstvaNaKonec;

	@Column(name = "SPECIAL1NYE_SREDSTVA_NA_NACALO", precision = 15, scale = 2)
	private BigDecimal special1nyeSredstvaNaNacalo;

	@Column(name = "SPECIAL1NYE_SREDSTVA_NA_KONEC", precision = 15, scale = 2)
	private BigDecimal special1nyeSredstvaNaKonec;

}
