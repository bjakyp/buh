package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "AktSverkiVzaimorascetovPoDannymOrganizacii", schema = "parts_documents")
@Getter
@Setter
public class AktSverkiVzaimorascetovPoDannymOrganizacii {
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
