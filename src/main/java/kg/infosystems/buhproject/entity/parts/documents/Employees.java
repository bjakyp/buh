package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.Dolznosti;
import kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij;
import kg.infosystems.buhproject.entity.documents.UpravlenieStatnymRaspisaniem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Table(name = "employees", schema = "parts_documents")
@Entity
@Getter
@Setter
public class Employees {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FULLNAME")
    private String fullname;//фио

    @JoinColumn(name = "DOLJNOST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dolznosti doljnost;//наименование должности

    @Column(name = "STAVKA", precision = 19, scale = 2)
    private BigDecimal stavka;//базовый оклад

    @Column(name = "KOEFFICENT_KRATNOSTI", precision = 19, scale = 2)
    private BigDecimal koefficentKratnosti;//коэффициент кратности

    @Column(name = "DOLJNOSTNOY_OKLAD", precision = 19, scale = 2)
    private BigDecimal doljnostnoyOklad;//размер должностного оклада

    @Column(name = "ZA_VYSLUGI_LET_PERCENT", precision = 19, scale = 2)
    private BigDecimal zaVyslugiLetPercent;//выслуга лет - процент

    @Column(name = "ZA_VYSLUGI_LET", precision = 19, scale = 2)
    private BigDecimal zaVyslugiLet;//выслуга лет - сумма

    @Column(name = "NADBAVKA_ZA_VYSOKOGORIE_PERCENT", precision = 19, scale = 2)
    private BigDecimal nadbavkaZaVysokogoriePercent;//Выслуга лет  за стаж работы, расположенных в высокогорных и отдаленных зонах - процент

    @Column(name = "NADBAVKA_ZA_VYSOKOGORIE", precision = 19, scale = 2)
    private BigDecimal nadbavkaZaVysokogorie;//Выслуга лет  за стаж работы, расположенных в высокогорных и отдаленных зонах - сумма

    @Column(name = "KLASNYI_CHIN", precision = 19, scale = 2)
    private BigDecimal klasnyiChin;//классный чин

    @Column(name = "NADBAVKA_ZA_SLOJNOST1_PERCENT", precision = 19, scale = 2)
    private BigDecimal nadbavkaZaSlojnost1Percent;//За сложность, качество, результаты труда, проявление профессиональной инициативы и ненормированный день - процент

    @Column(name = "NADBAVKA_ZA_SLOJNOST1", precision = 19, scale = 2)
    private BigDecimal nadbavkaZaSlojnost1;//За сложность, качество, результаты труда, проявление профессиональной инициативы и ненормированный день - сумма

    @Column(name = "SECRETNOST1_PERCENT", precision = 19, scale = 2)
    private BigDecimal secretnost1Percent;//Надбавка за секретный характер работы и секретное делопроизводство/совместительство - процент

    @Column(name = "SECRETNOST1", precision = 19, scale = 2)
    private BigDecimal secretnost1;//Надбавка за секретный характер работы и секретное делопроизводство/совместительство - сумма

    @Column(name = "VREDNOST1_PERCENT", precision = 19, scale = 2)
    private BigDecimal vrednost1Percent;//надбавка за вредность, за совм.обязанности - процент

    @Column(name = "VREDNOST1", precision = 19, scale = 2)
    private BigDecimal vrednost1;//надбавка за вредность, за совм.обязанности - сумма

    @Column(name = "UCHENAYA_STEPEN", precision = 19, scale = 2)
    private BigDecimal uchenayaStepen;//Надбавка за ученую степень

    @Column(name = "MESACNAYA_ZARPLATA_NA_RABOTNIKA", precision = 19, scale = 2)
    private BigDecimal mesacnayaZarplataNaRabotnika;//Месячная заработная плата на 1 работника

    @Column(name = "RAYONNIY_KOEFFICENT_PERCENT", precision = 19, scale = 2)
    private BigDecimal rayonniyKoefficentPercent;//Районный коэффициент за работу, расположенных в высокогорных и отдаленных зонах - процент

    @Column(name = "RAYONNIY_KOEFFICENT", precision = 19, scale = 2)
    private BigDecimal rayonniyKoefficent;//Районный коэффициент за работу, расположенных в высокогорных и отдаленных зонах - сумма

    @Column(name = "ITOGO_NADBAVKI_I_DOPLATY", precision = 19, scale = 2)
    private BigDecimal itogoNadbavkiIDoplaty;//Итого надбавки и доплаты

    @Column(name = "VSEGO_ZA_FO_TZA_MESYAC", precision = 19, scale = 2)
    private BigDecimal vsegoZaFOTzaMesyac;//Итого фонд  месячной заработной платы

    @Column(name = "OTPUSKNOY", precision = 19, scale = 2)
    private BigDecimal otpusknoy;//Отпускные

    @Column(name = "LECHEBNOE_POSOBIE_K_OTPUSKU", precision = 19, scale = 2)
    private BigDecimal lechebnoePosobieKOtpusku;//лечебные пособия к отпуску

    @Column(name = "ZARPLATA13", precision = 19, scale = 2)
    private BigDecimal zarplata13;//13 зарплата

    @Column(name = "KOMPENSACIONNYE_ZA_PERVYI_MESAC", precision = 19, scale = 2)
    private BigDecimal kompensacionnyeZaPervyiMesac;//Компенсация за 1 мес.

    @Column(name = "KOMPENSACIONNYE_ZA_ODINNADCATYI_MESAC", precision = 19, scale = 2)
    private BigDecimal kompensacionnyeZaOdinnadcatyiMesac;//Компенсация  за 11 мес.

    @Column(name = "GODOVOY_FOT", precision = 19, scale = 2)
    private BigDecimal godovoyFOT;//Всего  годовой фонд зп

    @Column(name = "STAVKA_SOC_FOT_PERCENT", precision = 19, scale = 2)
    private BigDecimal stavkaSocFotPercent;//Ставка соц-фонда

    @Column(name = "OTCHISLENIE_V_SOC_FOND", precision = 19, scale = 2)
    private BigDecimal otchislenieVSocFond;//Отчисления в социальный фонд

    @Column(name = "GODOVOY_FO_TZA_VYCHETOM_SFKR", precision = 19, scale = 2)
    private BigDecimal godovoyFOTzaVychetomSFKR;// Годовой фонд оплаты труда

    @Column(name = "SREDNEMESACNAYA_ZP", precision = 19, scale = 2)
    private BigDecimal srednemesacnayaZP;//среднемесячная зп.

    @Column(name = "PRIMECHANIE", precision = 19, scale = 2)
    private BigDecimal primechanie;//Примечание


    @Column(name = "PITANIE", precision = 19, scale = 2)
    private BigDecimal pitanie;

    @Column(name = "OTCHISLENIE_SFKR", precision = 19, scale = 2)
    private BigDecimal otchislenieSFKR;

    @Column(name = "PROEZD", precision = 19, scale = 2)
    private BigDecimal proezd;

    @Column(name = "INYE_NADBAVKI", precision = 19, scale = 2)
    private BigDecimal inyeNadbavki;

    @Column(name = "PREMIA", precision = 19, scale = 2)
    private BigDecimal premia;


    @JoinColumn(name = "UPRAVLENIE_STATNYM_RASPISANIEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UpravlenieStatnymRaspisaniem upravlenieStatnymRaspisaniem;

    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PodrazdeleniaOrganizacij podrazdelenie;
}
