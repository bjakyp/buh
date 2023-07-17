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
@Table(name = "PrilozeniaKPoasnitel1nojZapiskePrilozenie6", schema = "parts_documents")
@Getter
@Setter
public class PrilozeniaKPoasnitel1nojZapiskePrilozenie6 {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.PrilozeniaKPoasnitel1nojZapiske part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "KOD", length = 10)
    private String kod;

	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@Column(name = "ITOGO_OSTATOK_NA_NACALO", precision = 15, scale = 2)
    private BigDecimal itogoOstatokNaNacalo;

	@Column(name = "ITOGO_OSTATOK_NA_KONEC", precision = 15, scale = 2)
    private BigDecimal itogoOstatokNaKonec;

	@Column(name = "BUDZETNYE_SREDSTVA_NA_NACALO", precision = 15, scale = 2)
    private BigDecimal budzetnyeSredstvaNaNacalo;

	@Column(name = "BUDZETNYE_SREDSTVA_NA_KONEC", precision = 15, scale = 2)
    private BigDecimal budzetnyeSredstvaNaKonec;

	@Column(name = "SPECIAL1NYE_SREDSTVA_NA_NACALO", precision = 15, scale = 2)
    private BigDecimal special1nyeSredstvaNaNacalo;

	@Column(name = "SPECIAL1NYE_SREDSTVA_NA_KONEC", precision = 15, scale = 2)
    private BigDecimal special1nyeSredstvaNaKonec;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FORMULA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple formula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNAK_ID")
    private kg.infosystems.buhproject.entity.enumerations.PlusMinus znak;

}
