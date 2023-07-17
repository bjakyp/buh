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
@Table(name = "PrilozeniaKPoasnitel1nojZapiskePrilozenie1", schema = "parts_documents")
@Getter
@Setter
public class PrilozeniaKPoasnitel1nojZapiskePrilozenie1 {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.PrilozeniaKPoasnitel1nojZapiske part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "KOLICESTVO_UCREZDENIJ_NA_NACALO", precision = 15, scale = 2)
    private BigDecimal kolicestvoUcrezdenijNaNacalo;

	@Column(name = "KOLICESTVO_UCREZDENIJ_NA_KONEC", precision = 15, scale = 2)
    private BigDecimal kolicestvoUcrezdenijNaKonec;

	@Column(name = "STATNAA_CISLENNOST1_RABOTNIKOV_BUHGALTERII", precision = 15, scale = 2)
    private BigDecimal statnaaCislennost1RabotnikovBuhgalterii;

	@Column(name = "CENTRAL1NYJ_APPARAT", precision = 15, scale = 2)
    private BigDecimal central1nyjApparat;

	@Column(name = "PODVEDOMSTVENNYE_PODRAZDELENIA", precision = 15, scale = 2)
    private BigDecimal podvedomstvennyePodrazdelenia;

	@Column(name = "TERRITORIAL1NYE_PODRAZDELENIA", precision = 15, scale = 2)
    private BigDecimal territorial1nyePodrazdelenia;

}
