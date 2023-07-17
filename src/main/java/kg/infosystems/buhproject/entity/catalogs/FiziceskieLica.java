package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.catalogs.FiziceskieLicaKontaktnaaInformacia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "FiziceskieLica", schema = "catalogs")
@Getter
@Setter
public class FiziceskieLica {
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

    @Column(name = "KOD", length = 6)
    private String kod;

    @InstanceName
    @Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica roditel1;

    @Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

    @Column(name = "DATA_ROZDENIA")
    private LocalDateTime dataRozdenia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POL_ID")
    private kg.infosystems.buhproject.entity.enumerations.PolFiziceskogoLica pol;

    @Column(name = "MESTO_ROZDENIA", length = 240)
    private String mestoRozdenia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAZDANSTVO_ID")
    private kg.infosystems.buhproject.entity.catalogs.StranyMira grazdanstvo;

    @Column(name = "FIO", length = 50)
    private String fIO;

    @Column(name = "FIRS_NAME", length = 50)
    private String firsName;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "PASSPORT_SERIES", length = 50)
    private String passportSeries;

    @Column(name = "PASSPORT_NUMBER", length = 50)
    private String passportNumber;

    @Column(name = "ISSUED_DATE", length = 50)
    private String issuedDate;

    @Column(name = "EXPIRED_DATE", length = 50)
    private String expiredDate;

    @Column(name = "PASSPORT_AUTHORITY", length = 50)
    private String passportAuthority;

    @Column(name = "ADDRESS_LOCALITY_CODE", length = 50)
    private String addressLocalityCode;

    @Column(name = "PASSPORT_NUMBER_AC", length = 50)
    private String passportNumberAC;

    @Column(name = "INN", length = 14)
    private String iNN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NACIONAL1NOST1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Nacional1nosti nacional1nost1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSNOVNOJ_BANKOVSKIJ_SCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta osnovnojBankovskijScet;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OrderBy("nomerStroki")
    @OneToMany(mappedBy = "part")
    private List<FiziceskieLicaKontaktnaaInformacia> kontaktnaaInformacia;


}
