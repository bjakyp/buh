package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@JmixEntity
@Table(name = "BazoviyOklad", schema = "catalogs")
@Entity
@Data
public class BazoviyOklad {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "CODE")
    private Integer code;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "SUMMA", precision = 19, scale = 2)
    private BigDecimal summa;

    @Column(name = "TYPE_OF_NPA", length = 128)
    private String typeOfNPA;

    @Column(name = "REGISTER_NUMBER", length = 128)
    private String registerNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_")
    private Date date;

    @ManyToMany(mappedBy = "bazoviyOklads")
    private Set<TipOrganizacii> tipOrganizacii;
}
