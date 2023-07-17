package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "KomandirovkaSotrudniki", schema = "parts_documents")
@Getter
@Setter
public class KomandirovkaSotrudniki {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.Komandirovka part;

    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;


    @Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PODRAZDELENIE_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOLZNOST1_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

    @Column(name = "SUTOCNYE", precision = 15, scale = 2)
    private BigDecimal sutocnye;

    @Column(name = "PROZIVANIE", precision = 15, scale = 2)
    private BigDecimal prozivanie;

    @Column(name = "PROEZDNYE", precision = 15, scale = 2)
    private BigDecimal proezdnye;

    @NotNull
    @Column(name = "SUMMA_VSEGO", nullable = false, precision = 15, scale = 2)
    private BigDecimal summaVsego;

    @Column(name = "ZADANIE", length = 150)
    private String zadanie;

}
