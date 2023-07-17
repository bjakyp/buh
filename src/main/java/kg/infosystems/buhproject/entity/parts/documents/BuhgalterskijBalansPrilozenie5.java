package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "BuhgalterskijBalansPrilozenie5", schema = "parts_documents")
@Getter
@Setter
public class BuhgalterskijBalansPrilozenie5 {
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
