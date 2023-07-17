package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.KategoriaRabotnikov;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_Sotrudniki")
@Table(name = "SotrudnikiIr", schema = "informations")
@Getter
@Setter
public class Sotrudniki extends BaseEntity {
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

    @InstanceName
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOLZNOST1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

    @Column(name = "ZANIMAEMYH_STAVOK", precision = 3, scale = 2)
    private BigDecimal zanimaemyhStavok;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAFIK_RABOTY_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_SOBYTIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyKadrovyhSobytij vidSobytia;

    @Column(name = "ISPYTATEL1NYJ_SROK")
    private LocalDateTime ispytatel1nyjSrok;

    @JoinColumn(name = "KATEGORIA_RABOTNIKOV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private KategoriaRabotnikov kategoriaRabotnikov;

    @Column(name = "KOLVO_IJDIVENCEV")
    private Integer kolvoIjdivencev;

    @Column(name = "DATA_OKONCANIE")
    private LocalDateTime dataOkoncanie;
}
