package kg.infosystems.buhproject.entity.compensations;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "KATEGORIA_RABOTNIKOV", schema = "comps")
@Entity
@Getter
@Setter
public class KategoriaRabotnikov {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "KOD", length = 10)
    private String kod;

    @Column(name = "NAME")
    private String name;

    @CreatedDate
    @Column(name = "DATA_SOZDANIE")
    private LocalDate dataSozdanie;

    @InstanceName
    @DependsOnProperties({"kod", "name"})
    public String getInstanceName() {
        return String.format("%s %s", kod, name);
    }
}
