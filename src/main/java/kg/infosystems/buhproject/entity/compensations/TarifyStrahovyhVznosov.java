package kg.infosystems.buhproject.entity.compensations;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "TARIFY_STRAHOVYH_VZNOSOV", schema = "comps")
@Entity
public class TarifyStrahovyhVznosov {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "KOD", length = 10)
    private String kod;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATA_SOZDANIE")
    private LocalDate dataSozdanie;

    @Column(name = "STATUS")
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public LocalDate getDataSozdanie() {
        return dataSozdanie;
    }

    public void setDataSozdanie(LocalDate dataSozdanie) {
        this.dataSozdanie = dataSozdanie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"kod", "name"})
    public String getInstanceName() {
        return String.format("%s %s", kod, name);
    }
}
