package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "AvansovyjOtcetOplata", schema = "parts_documents")
@Getter
@Setter
public class AvansovyjOtcetOplata {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.AvansovyjOtcet part;

    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;


    @Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KONTRAGENT_ID")
    private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

    @Column(name = "SUMMA", precision = 15, scale = 2)
    private BigDecimal summa;

    @Column(name = "VHODASIJ_DOKUMENT", length = 50)
    private String vhodasijDokument;

    @Column(name = "NOMER_VHODASEGO_DOKUMENTA", length = 20)
    private String nomerVhodasegoDokumenta;

    @Column(name = "DATA_VHODASEGO_DOKUMENTA")
    private LocalDateTime dataVhodasegoDokumenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STAT1A_ID")
    private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_ZADOLZENNOSTI_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyZadolzennosti vidZadolzennosti;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SCET_RASCETOV_ID", nullable = false)
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetov;

    @Column(name = "SODERZANIE", length = 200)
    private String soderzanie;

}
