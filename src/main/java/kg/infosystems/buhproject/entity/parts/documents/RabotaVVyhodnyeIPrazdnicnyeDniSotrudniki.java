package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
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
@Table(name = "RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki", schema = "parts_documents")
@Getter
@Setter
public class RabotaVVyhodnyeIPrazdnicnyeDniSotrudniki {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.RabotaVVyhodnyeIPrazdnicnyeDni part;

    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;


    @Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

    @InstanceName
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_RASCETA_RAZMERA_ID")
    private VidyNacislenij vidRascetaRazmera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAFIK_RABOTY_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "VID_RASCETA_ID", nullable = false)
    private VidyNacislenij vidRasceta;

    @NotNull
    @Column(name = "RAZMER", nullable = false, precision = 15, scale = 2)
    private BigDecimal razmer;

    @NotNull
    @Column(name = "REZUL1TAT", nullable = false, precision = 15, scale = 2)
    private BigDecimal rezul1tat;

    @NotNull
    @Column(name = "COEFFICIENT", precision = 15, scale = 2)
    private BigDecimal coefficient;

    @NotNull
    @Column(name = "DATA_NACALA", nullable = false)
    private LocalDateTime dataNacala;

    @Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

    @NotNull
    @Column(name = "CASOV", nullable = false, precision = 7, scale = 2)
    private BigDecimal casov;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOSOB_OTRAZENIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty sposobOtrazenia;

}
