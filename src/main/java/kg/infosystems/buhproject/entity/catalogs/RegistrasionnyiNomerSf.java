package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.TarifyStrahovyhVznosov;
import kg.infosystems.buhproject.entity.documents.RegionalnyeOrganySF;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "REGISTRASIONNYI_NOMER_SF", indexes = {
    @Index(name = "IDX_REGISTRASIONNYI_NOMER_SF_KOD_RAYONA_SF", columnList = "KOD_RAYONA_SF_ID"),
    @Index(name = "IDX_REGISTRASIONNYI_NOMER_SF_VID_TARIFA", columnList = "VID_TARIFA_ID")
})
@Entity
@Getter
@Setter
public class RegistrasionnyiNomerSf {
    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZACII_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacii;

    @NotNull
    @JoinColumn(name = "KOD_RAYONA_SF_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private RegionalnyeOrganySF kodRayonaSf;

    @NotNull
    @Column(name = "SOSTOANIE", nullable = false)
    private Boolean sostoanie = false;

    @NotNull
    @JoinColumn(name = "VID_TARIFA_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private TarifyStrahovyhVznosov vidTarifa;

    @InstanceName
    @NotNull
    @Column(name = "REGISTRASIONNYI_NOMER", nullable = false)
    private Long registrasionnyiNomer;

    @NotNull
    @Column(name = "DATA_REGISTRASII", nullable = false)
    private LocalDateTime dataRegistrasii;

    @Column(name = "KOMMENTARIJ")
    private String kommentarij;

    @Column(name = "VERSIA_DANNYH")
    @Version
    private Integer versiaDannyh;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

}
