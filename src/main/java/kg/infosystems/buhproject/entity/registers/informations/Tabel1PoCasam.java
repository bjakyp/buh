package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_Tabel1PoCasam")
@Table(name = "Tabel1PoCasamIr", schema = "informations")
@Getter
@Setter
public class Tabel1PoCasam extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTRATOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registrator;

    @Column(name = "NOMER_STROKI", precision = 9, scale = 0)
    private BigDecimal nomerStroki;

    @Column(name = "AKTIVNOST1")
    private Boolean aktivnost1;

    @Column(name = "DATA")
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_RASCETA_ID")
    private VidyNacislenij vidRasceta;

    @Column(name = "CASOV_OTRABOTKI", precision = 2, scale = 0)
    private BigDecimal casovOtrabotki;

    @Column(name = "CASOV_NEAVKI", precision = 4, scale = 2)
    private BigDecimal casovNeavki;

    @Column(name = "DNEJ_OTRABOTKI", precision = 1, scale = 0)
    private BigDecimal dnejOtrabotki;

}
