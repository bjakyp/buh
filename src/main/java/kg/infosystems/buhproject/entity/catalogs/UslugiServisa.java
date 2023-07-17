package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "UslugiServisa", schema = "catalogs")
@Getter
@Setter
public class UslugiServisa {
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

    @Column(name = "KOD", length = 9)
    private String kod;

    @Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

    @Column(name = "IDENTIFIKATOR", length = 50)
    private String identifikator;

    @Column(name = "POKAZYVAT1_PRI_DOBAVLENII_V_TARIF")
    private Boolean pokazyvat1PriDobavleniiVTarif;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSTAVSIK_USLUGI_ID")
    private kg.infosystems.buhproject.entity.catalogs.PostavsikiUslugServisa postavsikUslugi;

    @Column(name = "TARIFICIRUETSA")
    private Boolean tarificiruetsa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIP_USLUGI_ID")
    private kg.infosystems.buhproject.entity.enumerations.TipyUslug tipUslugi;

}
