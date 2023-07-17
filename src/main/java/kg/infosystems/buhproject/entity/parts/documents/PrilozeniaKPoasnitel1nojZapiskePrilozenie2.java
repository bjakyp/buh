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
@Table(name = "PrilozeniaKPoasnitel1nojZapiskePrilozenie2", schema = "parts_documents")
@Getter
@Setter
public class PrilozeniaKPoasnitel1nojZapiskePrilozenie2 {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.PrilozeniaKPoasnitel1nojZapiske part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "KOD_ELEMENTA", length = 10)
    private String kodElementa;

	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@Column(name = "SUMMA", precision = 15, scale = 2)
    private BigDecimal summa;

	@Column(name = "OTNESENO_NA32171120", precision = 15, scale = 2)
    private BigDecimal otnesenoNa32171120;

	@Column(name = "OTNESENO_NA_DRUGOJ_ELEMENT", precision = 15, scale = 2)
    private BigDecimal otnesenoNaDrugojElement;

	@Column(name = "PRICINA_PROVEDENIA_INVENTARIZACII", length = 200)
    private String pricinaProvedeniaInventarizacii;

	@Column(name = "DATA")
    private LocalDateTime data;

	@Column(name = "NOMER", length = 10)
    private String nomer;

	@Column(name = "DATA_PRIKAZA")
    private LocalDateTime dataPrikaza;

	@Column(name = "NE_VYVODIT1_NA_PECAT1")
    private Boolean neVyvodit1NaPecat1;

}
