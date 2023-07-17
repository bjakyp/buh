package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "ISTOCNIKI_FINANSIROVANIA", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_ISTOCNIKI_FINANSIROVANIA_PARENT", columnList = "PARENT_ID")
})
@Entity
@Getter
@Setter
public class IstocnikiFinansirovania extends BaseDict<IstocnikiFinansirovania> {

    @JoinColumn(name = "PARENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private IstocnikiFinansirovania parent;
}

