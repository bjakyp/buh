package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Banki", schema = "catalogs")
@Getter
@Setter
public class Banki {
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

    @InstanceName
    @Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Banki roditel1;

    @Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

    @Column(name = "KORR_SCET", length = 20)
    private String korrScet;

    @Column(name = "GOROD", length = 50)
    private String gorod;

    @Column(name = "SWIFT", length = 25)
    private String sWIFT;

    @Column(name = "CLEARING", length = 20)
    private String clearing;

    @Column(name = "TELEFONY", length = 250)
    private String telefony;

    @Column(name = "ADRES", length = 500)
    private String adres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STRANA_ID")
    private kg.infosystems.buhproject.entity.catalogs.StranyMira strana;

}
