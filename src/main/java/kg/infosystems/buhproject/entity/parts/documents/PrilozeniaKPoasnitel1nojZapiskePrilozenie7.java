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
@Table(name = "PrilozeniaKPoasnitel1nojZapiskePrilozenie7", schema = "parts_documents")
@Getter
@Setter
public class PrilozeniaKPoasnitel1nojZapiskePrilozenie7 {
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

	@Column(name = "NAIMENOVANIE", length = 200)
    private String naimenovanie;

	@Column(name = "BUDZETNYE_SREDSTVA_DT", precision = 15, scale = 2)
    private BigDecimal budzetnyeSredstvaDt;

	@Column(name = "BUDZETNYE_SREDSTVA_KT", precision = 15, scale = 2)
    private BigDecimal budzetnyeSredstvaKt;

	@Column(name = "SPECIAL1NYE_SREDSTVA_DT", precision = 15, scale = 2)
    private BigDecimal special1nyeSredstvaDt;

	@Column(name = "SPECIAL1NYE_SREDSTVA_KT", precision = 15, scale = 2)
    private BigDecimal special1nyeSredstvaKt;

	@Column(name = "KOD_RODITEL1", length = 10)
    private String kodRoditel1;

	@Column(name = "NAIMENOVANIE_RODITEL1", length = 200)
    private String naimenovanieRoditel1;

	@Column(name = "RASSIRENNYJ_KOD", length = 20)
    private String rassirennyjKod;

	@Column(name = "NE_VYVODIT1_NA_PECAT1")
    private Boolean neVyvodit1NaPecat1;

}
