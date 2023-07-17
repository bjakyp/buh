package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyDocumenta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@JmixEntity
@Table(name = "DoljnostnieOklady", schema = "catalogs", indexes = {
    @Index(name = "IDX_DOLJNOSTNIEOKLADY_VID_DOCUMENTA", columnList = "VID_DOCUMENTA_ID")
})
@Entity
@Getter
@Setter
public class DoljnostnieOklady {
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

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "ORGANIZASIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacii organizasia;

    @JoinColumn(name = "VID_DOCUMENTA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private VidyDocumenta vidDocumenta;

    @Column(name = "REGISTER_NUMBER", length = 128)
    private String registerNumber;

    @Column(name = "DATE_")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "DATA_DOCUMENTA")
    @Temporal(TemporalType.DATE)
    private Date dataDocumenta;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "doljnostnieOklady")
    private Set<DoljnostnieOkladyDetail1> detail1;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "doljnostnieOklady")
    private Set<DoljnostnieOkladyDetail2> detail2;

}
