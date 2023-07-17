package kg.infosystems.buhproject.entity.compensations;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.accounts.Hozrascetnyj;
import kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty;
import kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov;
import kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania;
import kg.infosystems.buhproject.entity.enumerations.KategoriiRascetov;
import kg.infosystems.buhproject.entity.enumerations.SposobyRascetaUderzanij;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity
@Table(name = "VidyUderzanij", schema = "comps")
@Getter
@Setter
// ВидыУдержаний
public class VidyUderzanij extends BaseEntity {
    // Код (_Code)
    @Column(name = "CODE", length = 5)
    private String code;

    @InstanceName
    // Наименование (_Description)
    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    // ВидФинансирования (_Fld2738RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDY_FINANSIROVANIA_ID")
    private VidyFinansirovania vidyFinansirovania;

    // СпособРасчета (_Fld2739RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOSOBY_RASCETA_UDERZANIJ_ID")
    private SposobyRascetaUderzanij sposobyRasceta;

    // СпособОтражения (_Fld2718RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOSOBY_OTRAZENIA_ZARABOTNOJ_PLATY_ID")
    private SposobyOtrazeniaZarabotnojPlaty sposobyOtrazeniaZarabotnojPlaty;

    // Описание (_Fld2740)
    @Lob
    @Column(name = "OPISANIE")
    private String opisanie;

    // ТребуетсяРасчетБазы (_Fld2741)
    @Column(name = "TREBUETSA_RASCET_BAZY")
    private Boolean trebuetsaRascetBazy;

    // ТребуетсяРасчетВремени (_Fld2742)
    @Column(name = "TREBUETSA_RASCET_VREMENI")
    private Boolean trebuetsaRascetVremeni;

    //   КатегорияРасчета (_Fld2743RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KATEGORII_RASCETOV_ID")
    private KategoriiRascetov kategoriiRascetov;

    //   Порядок (_Fld2744)
    @Column(name = "PORADOK")
    private Integer poradok;

    //   РасчетЗаМинусомПН (_Fld2745)
    @Column(name = "RASCET_ZA_MINUSOM_PN")
    private Boolean rascetZaMinusomPN;

    //   РасчетЗаМинусомСФ (_Fld2746)
    @Column(name = "RASCET_ZA_MINUSOM_SF")
    private Boolean rascetZaMinusomSF;

    //   СчетУчета (_Fld2747RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCET_UCETA")
    private Hozrascetnyj scetUceta;

    //   Статья (_Fld2748RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STAT1A")
    private Stat1iDohodovIRashodov stat1a;

//   ОбластьДанныхОсновныеДанные (_Fld367)
}
