package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.globals.EconomClassifier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "SposobyOtrazeniaZarabotnojPlaty", schema = "catalogs", indexes = {
    @Index(name = "IDX_SPOSOBYOTRAZENIAZARABOTNOJPLATY_SCET_DT", columnList = "SCET_DT_ID"),
    @Index(name = "IDX_SPOSOBYOTRAZENIAZARABOTNOJPLATY_SCET_KT", columnList = "SCET_KT_ID")
})
@Getter
@Setter
public class SposobyOtrazeniaZarabotnojPlaty {
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
    @Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STAT1A_ZATRAT_ID")
    private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1aZatrat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCET_DT_SOC_FOND_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDtSocFond;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCET_DT_MEDICINSKOE_STRAHOVANIE_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDtMedicinskoeStrahovanie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCET_DT_FOND_OPLATY_TRUDA_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDtFondOplatyTruda;

    @JoinColumn(name = "SCET_DT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EconomClassifier scetDt;


    @JoinColumn(name = "SCET_KT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EconomClassifier scetKt;

}
