package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyUderzanij;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "STAVKA_PROFSOYUZA", schema = "parts_catalogs", indexes = {
    @Index(name = "IDX_STAVKA_PROFSOYUZA_VID_UDERZANIA", columnList = "VID_UDERZANIA_ID")
})
@Entity
@Getter
@Setter
public class StavkaProfsoyuza {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @NotNull
    @Column(name = "DATA_NACHALA_DEISTVIA", nullable = false)
    private LocalDateTime dataNachalaDeistvia;

    @NotNull
    @InstanceName
    @JoinColumn(name = "VID_UDERZANIA_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VidyUderzanij vidyUderzanij;

    @NotNull
    @Column(name = "STAVKA", nullable = false, precision = 19, scale = 2)
    private BigDecimal stavka;

    @OnDeleteInverse(DeletePolicy.CASCADE)

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stavkaProfsoyuza")
    private Organizacii organizacii;
}
