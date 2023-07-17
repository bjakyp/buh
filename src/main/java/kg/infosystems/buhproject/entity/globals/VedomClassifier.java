package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "VEDOM_CLASSIFIER", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_VEDOM_CLASSIFIER_PARENT", columnList = "PARENT")
})
@Entity
@Getter
@Setter
public class VedomClassifier extends BaseDict<VedomClassifier> {
    @JoinColumn(name = "PARENT")
    @ManyToOne(fetch = FetchType.LAZY)
    private VedomClassifier parent;
}
