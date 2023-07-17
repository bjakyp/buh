package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@JmixEntity
@Table(name = "VedomstvennayaClassifikacia", schema = "catalogs")
@Entity
@Getter
@Setter
public class VedomstvennayaClassifikacia {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "CODE")
    private Integer code;

    @InstanceName
    @Column(name = "NAME")
    private String name;

}
