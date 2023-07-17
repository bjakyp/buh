package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "RASCETNYJ_POKAZATEL1", schema = "documents")
@Entity
@Getter
@Setter
public class RascetnyjPokazatel1 {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @NotNull
    @Column(name = "DATA_NACALA", nullable = false)
    private LocalDateTime dataNacala;

    @InstanceName
    @Column(name = "RAZMER", precision = 19, scale = 2)
    private BigDecimal razmer;
}
