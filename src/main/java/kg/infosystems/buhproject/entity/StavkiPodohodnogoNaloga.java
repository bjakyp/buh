package kg.infosystems.buhproject.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "STAVKI_PODOHODNOGO_NALOGA", schema = "comps")
@Entity
public class StavkiPodohodnogoNaloga {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DATA_SOZDANIE")
    private LocalDate dataSozdanie;

    @Max(message = "{msg://kg.infosystems.buhproject.entity/StavkiPodohodnogoNaloga.stavka.validation.Max}", value = 100)
    @Min(message = "{msg://kg.infosystems.buhproject.entity/StavkiPodohodnogoNaloga.stavka.validation.Min}", value = 0)
    @Column(name = "STAVKA")
    private Integer stavka;

    public LocalDate getDataSozdanie() {
        return dataSozdanie;
    }

    public void setDataSozdanie(LocalDate dataSozdanie) {
        this.dataSozdanie = dataSozdanie;
    }

    public Integer getStavka() {
        return stavka;
    }

    public void setStavka(Integer stavka) {
        this.stavka = stavka;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"stavka"})
    public String getInstanceName() {
        return String.format("%s", stavka+"%");
    }
}
