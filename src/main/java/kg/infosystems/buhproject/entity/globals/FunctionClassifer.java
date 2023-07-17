package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "FUNCTION_CLASSIFER", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_FUNCTION_CLASSIFER_PARENT", columnList = "PARENT")
})
@Entity
@Getter
@Setter
public class FunctionClassifer extends BaseDict<FunctionClassifer> {
    @JoinColumn(name = "PARENT")
    @ManyToOne(fetch = FetchType.LAZY)
    private FunctionClassifer parent;
}
