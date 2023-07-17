package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.KategoriaRabotnikov;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.documents.KadrovoePeremesenie;
import kg.infosystems.buhproject.entity.documents.PriemNaRabotu;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_PlanovyeNacisleniaNacalo")
@Table(name = "PlanovyeNacisleniaNacaloIr", schema = "informations", indexes = {
    @Index(name = "IDX_PLANOVYENACISLENIANACALOIR_KATEGORIA_RABOTNIKOV", columnList = "KATEGORIA_RABOTNIKOV_ID")
})
@Getter
@Setter
public class PlanovyeNacisleniaNacalo extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTRATOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registrator;

    @Column(name = "PERIOD")
    private LocalDateTime period;

    @Column(name = "NOMER_STROKI", precision = 9, scale = 0)
    private BigDecimal nomerStroki;

    @Column(name = "AKTIVNOST1")
    private Boolean aktivnost1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_RASCETA_ID")
    private VidyNacislenij vidRasceta;

    @Column(name = "RAZMER", precision = 15, scale = 2)
    private BigDecimal razmer;

    @Column(name = "OSNOVNOJ")
    private Boolean osnovnoj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOLZNOST1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAFIK_RABOTY_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRIEM_NA_RABOTU_ID")
    private PriemNaRabotu priemNaRabotu;

    @JoinColumn(name = "KADROVOE_PEREMESENIE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private KadrovoePeremesenie kadrovoePeremesenie;

    @JoinColumn(name = "KATEGORIA_RABOTNIKOV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private KategoriaRabotnikov kategoriaRabotnikov;

    @Column(name = "KOLVO_IJDIVENCEV")
    private Integer kolvoIjdivencev;
}
