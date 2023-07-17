package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.globals.IstocnikiFinansirovania;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VidyFinansirovania", schema = "catalogs", indexes = {
    @Index(name = "IDX_VIDYFINANSIROVANIA_ISTOCNIK_FINANSIROVANIE", columnList = "ISTOCNIK_FINANSIROVANIE_ID")
})
@Getter
@Setter
public class VidyFinansirovania {
    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;

    @Column(name = "VERSIA_DANNYH")
    @Version
    private Integer versiaDannyh;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

    @InstanceName
    @Column(name = "NAIMENOVANIE", length = 25)
    private String naimenovanie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FINANSIROVANIE_ID")
    private kg.infosystems.buhproject.entity.enumerations.Finansirovania finansirovanie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_BUDZETA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyBudzeta vidBudzeta;

    @Column(name = "KOD_V_VEDOMSTVENNOM_KLASSIFIKATORE", length = 10)
    private String kodVVedomstvennomKlassifikatore;

    @Column(name = "KOD_V_FUNKCIONAL1NOM_KLASSIFIKATORE", length = 10)
    private String kodVFunkcional1nomKlassifikatore;

    @JoinColumn(name = "ISTOCNIK_FINANSIROVANIE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private IstocnikiFinansirovania istocnikFinansirovanie;
}
