package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@JmixEntity
@Table(name = "TipOrganizacii", schema = "catalogs")
@Entity
@Getter
@Setter
public class TipOrganizacii {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "CODE")
    private Integer code;

    @InstanceName
    @Column(name = "NAME")
    private String name;
    @JoinTable(name = "TIP_ORGANIZACII_BAZOVIY_OKLAD_LINK", schema = "catalogs",
        joinColumns = @JoinColumn(name = "TIP_ORGANIZACII_ID"),
        inverseJoinColumns = @JoinColumn(name = "BAZOVIi_OKLAD_ID"))
    @ManyToMany
    private Set<BazoviyOklad> bazoviyOklads;
}
