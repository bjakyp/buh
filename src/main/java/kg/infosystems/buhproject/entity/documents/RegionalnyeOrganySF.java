package kg.infosystems.buhproject.entity.documents;

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
@Table(name = "REGIONALNYE_ORGANY_SF", schema = "documents")
@Entity
@Getter
@Setter
public class RegionalnyeOrganySF {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "KOD", length = 3)
    private String kod;


    @Column(name = "NAIMENOVANIE", length = 60)
    private String naimenovanie;

    @Column(name = "INN", length = 14)
    private String iNN;

    @Column(name = "POLNOE_NAIMENOVANIE", length = 254)
    private String polnoeNaimenovanie;

}
