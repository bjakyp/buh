package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Getter
@Setter
@Table(name = "STATNIE_RASPISANIE_PRIKAZY", schema = "informations")
@Entity
public class StatnieRaspisaniePrikazy {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "ORGANIZASIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacii organizasia;

    @Column(name = "PERIOD_")
    private LocalDateTime period;

    @Column(name = "DATE_")
    private LocalDateTime date;

    @Column(name = "I_NN")
    private String iNN;

    @Column(name = "NOMER")
    private String nomer;

}
