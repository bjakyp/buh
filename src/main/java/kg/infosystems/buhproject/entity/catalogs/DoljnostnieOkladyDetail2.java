package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.globals.FunctionClassifer;
import kg.infosystems.buhproject.entity.globals.VedomClassifier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "DoljnostnieOkladyDetail2", schema = "catalogs", indexes = {
    @Index(name = "IDX_DOLJNOSTNIE_OKLADY_DETAIL2_DOLJNOSTNIE_OKLADY", columnList = "DOLJNOSTNIE_OKLADY_ID"),
    @Index(name = "IDX_DOLJNOSTNIEOKLADYDETAIL2_VEDOM_CLASSIFIER", columnList = "VEDOM_CLASSIFIER_ID"),
    @Index(name = "IDX_DOLJNOSTNIEOKLADYDETAIL2_FUNCTION_CLASSIFER", columnList = "FUNCTION_CLASSIFER_ID")
})
@Entity
@Getter
@Setter
public class DoljnostnieOkladyDetail2 {
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

    @JoinColumn(name = "DOLJNOSTNIE_OKLADY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DoljnostnieOklady doljnostnieOklady;

    @JoinColumn(name = "VEDOM_CLASSIFIER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private VedomClassifier vedomClassifier;

    @JoinColumn(name = "FUNCTION_CLASSIFER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private FunctionClassifer functionClassifer;
}
