package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.Dolznosti;
import kg.infosystems.buhproject.entity.documents.Bol1nicnyjList;
import kg.infosystems.buhproject.entity.documents.Komandirovka;
import kg.infosystems.buhproject.entity.documents.Otpusk;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "RAZOVOE_NACISLENIE", schema = "informations")
@Entity
@Getter
@Setter
public class RazovoeNacislenie {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "PROVEDEN")
    private Boolean status;

    @Column(name = "PERIOD")
    private LocalDateTime dataNacislenia;

    @Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @JoinColumn(name = "DOLZNOST1_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dolznosti dolznost1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAFIK_RABOTY_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_RASCETA_ID")
    private kg.infosystems.buhproject.entity.compensations.VidyNacislenij vidRasceta;

    @Column(name = "NORMA_DNEJ", precision = 4, scale = 2)
    private BigDecimal dnej;

    @Column(name = "NORMA_CASOV", precision = 7, scale = 2)
    private BigDecimal casov;

    @Column(name = "RAZMER", precision = 15, scale = 2)
    private BigDecimal razmer;

    @Column(name = "REZUL1TAT", precision = 15, scale = 2)
    private BigDecimal rezul1tat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOSOB_OTRAJENIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty sposobOtrajenia;

    @JoinColumn(name = "BOL1NICNYJ_LIST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bol1nicnyjList bol1nicnyjList;

    @JoinColumn(name = "OTPUSK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Otpusk otpusk;

    @JoinColumn(name = "KOMANDIROVKA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Komandirovka komandirovka;

}
