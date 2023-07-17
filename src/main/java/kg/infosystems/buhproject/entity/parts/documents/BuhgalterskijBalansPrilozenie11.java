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
@Table(name = "BuhgalterskijBalansPrilozenie11", schema = "parts_documents")
@Getter
@Setter
public class BuhgalterskijBalansPrilozenie11 {
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

	@Column(name = "ITOGO", precision = 15, scale = 2)
	private BigDecimal itogo;

	@Column(name = "BUDZETNYE_SREDSTVA", precision = 15, scale = 2)
	private BigDecimal budzetnyeSredstva;

	@Column(name = "SPECIAL1NYE_SREDSTVA", precision = 15, scale = 2)
	private BigDecimal special1nyeSredstva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FORMULA_ID")
	private kg.infosystems.buhproject.entity.one.Multiple formula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNAK_ID")
	private kg.infosystems.buhproject.entity.enumerations.PlusMinus znak;

}
