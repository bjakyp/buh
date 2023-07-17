package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Bol1nicnyjListSrednijZarabotok", schema = "parts_documents")
@Getter
@Setter
public class Bol1nicnyjListSrednijZarabotok {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.Bol1nicnyjList part;

    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;


    @Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

    @NotNull
    @Column(name = "PERIOD_REGISTRACII", nullable = false)
    private LocalDateTime periodRegistracii;

    @Column(name = "NORMA_DNEJ", precision = 7, scale = 2)
    private BigDecimal normaDnej;

    @Column(name = "OTRABOTANO_DNEJ", precision = 7, scale = 2)
    private BigDecimal otrabotanoDnej;

    @Column(name = "OTRABOTANO_CASOV", precision = 7, scale = 2)
    private BigDecimal otrabotanoCasov;

    @Column(name = "REZUL1TAT", precision = 15, scale = 2)
    private BigDecimal rezul1tat;

}
