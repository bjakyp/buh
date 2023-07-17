package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.base.BaseLong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@JmixEntity
@MappedSuperclass
@Getter
@Setter
public abstract class BaseDict<P> extends BaseLong implements HasParent<P> {
    @Column(name = "CODE", length = 25)
    private String code;

    @InstanceName
    @Column(name = "NAME", length = 500)
    private String name;

    @Column(name = "SHORT_NAME", length = 500)
    private String shortName;

//    @JoinColumn(name = "PARENT")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Rok parent;

    @Column(name = "ACTIVE")
    private Boolean active;
}
