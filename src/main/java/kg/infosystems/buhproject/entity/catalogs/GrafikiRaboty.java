package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "GrafikiRaboty", schema = "catalogs")
@Getter
@Setter
public class GrafikiRaboty {
    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;

    @Column(name = "VERSIA_DANNYH")
    @Version
    private Integer versiaDannyh;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

    @InstanceName
    @Column(name = "NAIMENOVANIE", length = 50)
    private String naimenovanie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty roditel1;

    @Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

    @Column(name = "UCITYVAT1_PRAZDNIKI")
    private Boolean ucityvat1Prazdniki;

    @Column(name = "NORMA_CASOV_ZAPOLNENIA", precision = 7, scale = 2)
    private BigDecimal normaCasovZapolnenia = BigDecimal.valueOf(8);

    @Column(name = "PERIOD_V_DNJAH", precision = 19, scale = 2)
    private BigDecimal periodVDnjah = BigDecimal.valueOf(7);

}
