package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.enumerations.VidyTabelyaUceta;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "TABEL1_UCETA_POSESHENIA", indexes = {
    @Index(name = "IDX_TABEL1_UCETA_POSESHENIA_VIDY_TABELYA_UCETA", columnList = "VIDY_TABELYA_UCETA_ID")
})
@Entity
@Getter
@Setter
public class Tabel1UcetaPoseshenia extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTRATOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registrator;

    @JoinColumn(name = "VIDY_TABELYA_UCETA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private VidyTabelyaUceta vidyTabelyaUceta;

    @Column(name = "PERIOD")
    private LocalDateTime period;

    @NotNull
    @Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

    @NotNull
    @Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

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

    @Column(name = "TABEL")
    private UUID tabel;
}
