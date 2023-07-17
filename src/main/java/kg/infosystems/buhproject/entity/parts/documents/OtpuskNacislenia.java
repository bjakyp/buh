package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "OtpuskNacislenia", schema = "parts_documents")
@Getter
@Setter
public class OtpuskNacislenia {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_RASCETA_ID")
    private VidyNacislenij vidRasceta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOSOB_OTRAZENIA_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty sposobOtrazenia;

    @Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

    @Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

    @Column(name = "REZUL1TAT", precision = 15, scale = 2)
    private BigDecimal rezul1tat;

    @Column(name = "RAZMER", precision = 15, scale = 2)
    private BigDecimal razmer;

    @Column(name = "OTRABOTANO_DNEJ", precision = 7, scale = 2)
    private BigDecimal otrabotanoDnej;

}
