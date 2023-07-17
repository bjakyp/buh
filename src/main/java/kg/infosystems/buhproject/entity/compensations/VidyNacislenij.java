package kg.infosystems.buhproject.entity.compensations;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty;
import kg.infosystems.buhproject.entity.enumerations.KategoriiRascetov;
import kg.infosystems.buhproject.entity.enumerations.SposobyRascetaNacislenij;
import kg.infosystems.buhproject.entity.globals.AccountType;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@JmixEntity
@Entity
@Table(name = "VidyNacislenij", schema = "comps", indexes = {
    @Index(name = "IDX_VIDYNACISLENIJ_VID_BUDJETA", columnList = "VID_BUDJETA_ID")
})
@Getter
@Setter
// ВидыНачислений
public class VidyNacislenij extends BaseEntity {
    // Код (_Code)
    @Column(name = "CODE", length = 5)
    private String code;

    @InstanceName
    // Наименование (_Description)
    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    // ПериодДействияБазовый (_BaseAsAct)
    @Column(name = "BASE_AS_ACT")
    private Boolean baseAsAct;

    @JoinColumn(name = "VID_BUDJETA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccountType vidBudjeta;

    // СпособРасчета (_Fld2717RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOSOB_RASCETA_NACISLENIJ_ID")
    private SposobyRascetaNacislenij sposobRasceta;

    // СпособОтражения (_Fld2718RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPOSOBY_OTRAZENIA_ZARABOTNOJ_PLATY_ID")
    private SposobyOtrazeniaZarabotnojPlaty sposobyOtrazeniaZarabotnojPlaty;

    // БуквенныйКод (_Fld2719)
    @Column(name = "BUKVENNIJ_KOD", length = 2)
    private String bukvennijKod;

    // РасчетОтОбратного (_Fld2720)
    @Column(name = "RASCET_OT_OBRATNOGO")
    private Boolean rascetOtObratnogo;

    // ЗачетОтработанногоВремени (_Fld2721)
    @Column(name = "ZACET_OTRABOTANNOGO_VREMENI")
    private Boolean zacetOtrabotannogoVremeni;

    // ДополнительныйДоход (_Fld2722)
    @Column(name = "DOPOLNITEL1NIJ_DOHOD")
    private Boolean dopolnitel1nijDohod;

    // Описание (_Fld2723)
    @Lob
    @Column(name = "OPISANIE")
    private String opisanie;

    // КатегорияРасчета (_Fld2724RRef)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KATEGORII_RASCETOV_ID")
    private KategoriiRascetov kategoriiRascetov;

    // ТребуетсяРасчетБазы (_Fld2725)
    @Column(name = "TREBUETSA_RASCET_BAZY")
    private Boolean trebuetsaRascetBazy;

    // ТребуетсяРасчетВремени (_Fld2726)
    @Column(name = "TREBUETSA_RASCET_VREMENI")
    private Boolean trebuetsaRascetVremeni;

    // ТребуетсяРасчетВремениВЧасах (_Fld2727)
    @Column(name = "TREBUETSA_RASCET_VREMENI_V_CASAH")
    private Boolean trebuetsaRascetVremeniVCasah;

    // ОблагаетсяПН (_Fld2728)
    @Column(name = "OBLAGAETSA_PN")
    private Boolean oblagaetsaPN;

    // ОблагаетсяСФ (_Fld2729)
    @Column(name = "OBLAGAETSA_SF")
    private Boolean oblagaetsaSF;

    @Column(name = "UCET_PRI_RASCETE")
    private Boolean ucetPriRascete;

    // ПериодРасчетаСреднегоЗаработка (_Fld2730)
    @Column(name = "PERIOD_RESCETA_SREDNEGO_ZARABOTKA", precision = 5, scale = 0)
    private BigDecimal periodRascetaSrednegoZarabotka;

    // Порядок (_Fld2731)
    @Column(name = "PORADOK")
    private Integer poradok;

    // КоличествоЧасов (_Fld2732)
    @Column(name = "KOLICESTVO_CASOV", precision = 5, scale = 2)
    private BigDecimal kolicestvoCasov;

    // Коэффициент1 (_Fld2733)
    @Column(name = "KOEF1", precision = 5, scale = 2)
    private BigDecimal koef1;

    // Коэффициент2 (_Fld2734)
    @Column(name = "KOEF2", precision = 5, scale = 2)
    private BigDecimal koef2;

    public AccountType getVidBudjeta() {
        return vidBudjeta;
    }

    public void setVidBudjeta(AccountType vidBudjeta) {
        this.vidBudjeta = vidBudjeta;
    }

    //   ОбластьДанныхОсновныеДанные (_Fld367)
}
