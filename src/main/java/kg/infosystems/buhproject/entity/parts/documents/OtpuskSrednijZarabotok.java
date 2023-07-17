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
@Table(name = "OtpuskSrednijZarabotok", schema = "parts_documents")
@Getter
@Setter
public class OtpuskSrednijZarabotok {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.Otpusk part;

    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;


    @Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

    @NotNull
    @Column(name = "PERIOD_REGISTRACII")
    private LocalDateTime periodRegistracii;

    @Column(name = "KOEFFICIENT_RASCETA", precision = 5, scale = 2)
    private BigDecimal koefficientRasceta;

    @NotNull
    @Column(name = "REZUL1TAT", nullable = false, precision = 15, scale = 2)
    private BigDecimal rezul1tat;

}
