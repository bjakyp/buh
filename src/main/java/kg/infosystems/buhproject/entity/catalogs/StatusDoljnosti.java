package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "STATUS_DOLJNOSTI")
@Entity
@Getter
@Setter
public class StatusDoljnosti {
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

    @InstanceName
    @Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

    @Column(name = "KOD", length = 60)
    private String kod;

    @Column(name = "NAIMENOVANIE_KOROTKOE")
    private String naimenovanieKorotkoe;

    @Column(name = "STATUS")
    private Boolean status;

}
