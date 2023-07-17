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
@Table(name = "AktSverkiVzaimorascetovPoDannymKontragenta", schema = "parts_documents")
@Getter
@Setter
public class AktSverkiVzaimorascetovPoDannymKontragenta {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.AktSverkiVzaimorascetov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "DATA")
    private LocalDateTime data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_SVERKI_ID")
    private kg.infosystems.buhproject.entity.one.Multiple dokumentSverki;

	@Column(name = "SUMMA_DT", precision = 15, scale = 2)
    private BigDecimal summaDt;

	@Column(name = "SUMMA_KT", precision = 15, scale = 2)
    private BigDecimal summaKt;

}
