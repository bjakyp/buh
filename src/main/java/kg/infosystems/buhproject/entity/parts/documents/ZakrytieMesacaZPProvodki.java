package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "ZakrytieMesacaZPProvodki", schema = "parts_documents")
@Getter
@Setter
public class ZakrytieMesacaZPProvodki {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.ZakrytieMesacaZP part;

    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;


    @Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_FINANSIROVANIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCET_DT_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBKONTO_DT1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkontoDt1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBKONTO_DT2_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkontoDt2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBKONTO_DT3_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkontoDt3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCET_KT_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetKt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBKONTO_KT1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkontoKt1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBKONTO_KT2_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkontoKt2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBKONTO_KT3_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkontoKt3;

    @Column(name = "SUMMA", precision = 15, scale = 2)
    private BigDecimal summa;

    @Column(name = "SODERZANIE", length = 200)
    private String soderzanie;

}
