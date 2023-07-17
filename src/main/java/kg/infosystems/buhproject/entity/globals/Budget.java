package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.base.BaseLong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "BUDGET", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_BUDGET_ROK", columnList = "ROK_ID")
})
@Entity
@Getter
@Setter
public class Budget extends BaseLong {
    @Column(name = "CODE", length = 25)
    private String code;

    @InstanceName
    @Column(name = "NAME", length = 500)
    private String name;

    @Column(name = "SHORT_NAME", length = 500)
    private String shortName;

    @JoinColumn(name = "ROK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rok rok;

    @Column(name = "ACTIVE")
    private Boolean active;
}
