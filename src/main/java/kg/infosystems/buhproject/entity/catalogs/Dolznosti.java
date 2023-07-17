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
@Table(name = "Dolznosti", schema = "catalogs")
@Getter
@Setter
public class Dolznosti {
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
    @Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

    @Column(name = "PORADOK", precision = 5, scale = 0)
    private BigDecimal poradok;

    @JoinColumn(name = "STATUS_DOLJNOSTI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatusDoljnosti statusDoljnosti;

    @JoinColumn(name = "REGISTR_DOLJNOSTI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private RegistrDoljnosti registrDoljnosti;

    @Column(name = "KOD", length = 60)
    private String kod;

}
