package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "DoljnostnieOkladyDetail1", schema = "catalogs")
@Entity
@Getter
@Setter
public class DoljnostnieOkladyDetail1 {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
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

    @Column(name = "CODE")
    private Integer code;

    @JoinColumn(name = "DOLJNOST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dolznosti doljnost;

    @JoinColumn(name = "BAZOVIY_OKLAD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private BazoviyOklad bazoviyOklad;

    @Column(name = "COEFFICENT_KRATNOSTI", precision = 19, scale = 2)
    private BigDecimal coefficentKratnosti;

    @Column(name = "SUMMA", precision = 19, scale = 2)
    private BigDecimal summa;

    @JoinColumn(name = "DOLJNOSTNIE_OKLADY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DoljnostnieOklady doljnostnieOklady;
}
