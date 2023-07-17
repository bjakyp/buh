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
@Table(name = "PrilozeniaKPoasnitel1nojZapiskePrilozenie9", schema = "parts_documents")
@Getter
@Setter
public class PrilozeniaKPoasnitel1nojZapiskePrilozenie9 {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.PrilozeniaKPoasnitel1nojZapiske part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
    private kg.infosystems.buhproject.entity.one.Multiple stat1a;

	@Column(name = "SUMMA", precision = 15, scale = 2)
    private BigDecimal summa;

	@Column(name = "NE_VYVODIT1_NA_PECAT1")
    private Boolean neVyvodit1NaPecat1;

}
