package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.Sotrudniki;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "NeavkaSotrudniki", schema = "parts_documents", indexes = {
    @Index(name = "IDX_NEAVKASOTRUDNIKI_SOTRUDNIK", columnList = "SOTRUDNIK_ID")
})
@Getter
@Setter
public class NeavkaSotrudniki {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.Neavka part;

    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;


    @Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

    @JoinColumn(name = "SOTRUDNIK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sotrudniki sotrudnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAFIK_RABOTY_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_RASCETA_ID")
    private VidyNacislenij vidRasceta;

    @Column(name = "DATA_NACALA")
    private LocalDate dataNacala;

    @Column(name = "DATA_OKONCANIA")
    private LocalDate dataOkoncania;

    @Column(name = "DNEJ", precision = 3, scale = 0)
    private BigDecimal dnej;

    @Column(name = "CASOV", precision = 7, scale = 2)
    private BigDecimal casov;

    @Lob
    @Column(name = "PRICINA")
    private String pricina;

    @Column(name = "TABEL_NOMER")
    private Long tabelNomer;

    @Column(name = "DATA_OTSUTSTVIA")
    private LocalDate dataOtsutstvia;

}
