package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "PROGRAMMY", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_PROGRAMMY_PARENT", columnList = "PARENT_ID")
})
@Entity
@Getter
@Setter
public class Programmy extends BaseDict<Programmy>{

    @JoinColumn(name = "PARENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programmy parent;

}
