package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Sotrudniki", schema = "catalogs")
@Getter
@Setter
public class Sotrudniki {
    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "sotrudniki")
    private List<Profsoyuz> profsoyuz;

    @Column(name = "VERSIA_DANNYH")
    @Version
    private Integer versiaDannyh;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

    @Column(name = "KOD")
    private Long kod;

    @InstanceName
    @Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

    @Column(name = "I_NN", length = 14)
    private String iNN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki roditel1;

    @JoinColumn(name = "ORGANIZACIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacii organizacia;

    @Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSNOVNOJ_BANKOVSKIJ_SCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta osnovnojBankovskijScet;


    @OneToMany(mappedBy = "sotrudniki")
    private List<BankovskieSceta> drugieBankovskieSceta;

    @OneToMany(mappedBy = "sotrudniki")
    private List<KartScetaSotrudnikov> kartScet;
}
