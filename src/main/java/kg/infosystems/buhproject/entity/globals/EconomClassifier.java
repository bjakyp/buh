package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "ECONOM_CLASSIFIER", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_ECONOM_CLASSIFIER_PARENT", columnList = "PARENT")
})
@Entity
@Getter
@Setter
public class EconomClassifier extends BaseDict<EconomClassifier> {
    @JoinColumn(name = "PARENT")
    @ManyToOne(fetch = FetchType.LAZY)
    private EconomClassifier parent;
}
