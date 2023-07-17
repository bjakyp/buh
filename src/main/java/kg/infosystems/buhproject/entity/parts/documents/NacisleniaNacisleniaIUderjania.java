package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "NACISLENIA_NACISLENIA_I_UDERJANIA", schema = "documents")
@Entity
@Getter
@Setter
public class NacisleniaNacisleniaIUderjania {

    @JoinColumn(name = "NACISLENIA_I_UDERJANIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private kg.infosystems.buhproject.entity.documents.NacisleniyaIUderjaniya nacisleniaIUderjania;

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOLZNOST1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAFIK_RABOTY_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @Column(name = "NORMA_DNEJ", precision = 4, scale = 2)
    private BigDecimal normaDnej;

    @Column(name = "NORMA_CASOV", precision = 7, scale = 2)
    private BigDecimal normaCasov;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_RASCETA_ID")
    private VidyNacislenij vidRasceta;

    @Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

    @Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

    @Column(name = "REZUL1TAT", precision = 15, scale = 2)
    private BigDecimal rezul1tat;

    @Column(name = "RAZMER", precision = 15, scale = 2)
    private BigDecimal razmer;

    @Column(name = "OTRABOTANO_DNEJ", precision = 4, scale = 2)
    private BigDecimal otrabotanoDnej;


    @Column(name = "OTRABOTANO_CASOV", precision = 7, scale = 2)
    private BigDecimal otrabotanoCasov;

    @InstanceName
    @DependsOnProperties({"vidRasceta", "razmer"})
    public String getInstanceName() {
        return String.format("%s: %s", vidRasceta, razmer);
    }

}
