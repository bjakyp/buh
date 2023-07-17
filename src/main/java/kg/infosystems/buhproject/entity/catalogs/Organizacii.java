package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.TarifyPodohodnogoNaloga;
import kg.infosystems.buhproject.entity.parts.catalogs.OrganizaciiKontaktnaaInformacia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Organizacii", schema = "catalogs", indexes = {
    @Index(name = "IDX_ORGANIZACII_STAVKA_PROFSOYUZA", columnList = "STAVKA_PROFSOYUZA_ID")
})
@Getter
@Setter
public class Organizacii {
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
    @Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

    @Column(name = "INN", length = 14)
    private String iNN;

    @Column(name = "DATA_REGISTRACII")
    private LocalDateTime dataRegistracii;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSNOVNOJ_BANKOVSKIJ_SCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta osnovnojBankovskijScet;

    @Column(name = "KOD_PO_OKPO", length = 10)
    private String kodPoOKPO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OSNOVNAA_KASSA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Kassy osnovnaaKassa;

    @Column(name = "NAIMENOVANIE_POLNOE", length = 1024)
    private String naimenovaniePolnoe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GNS_ID")
    private kg.infosystems.buhproject.entity.catalogs.GNS gNS;

    @Column(name = "REG_NOMER_SOC_FONDA_BUDZET", length = 30)
    private String regNomerSocFondaBudzet;

    @Column(name = "REG_NOMER_SOC_FONDA_SPEC_SCET", length = 30)
    private String regNomerSocFondaSpecScet;

    @Column(name = "KOD_GKED", length = 8)
    private String kodGKED;

    @Column(name = "NAIMENOVANIE_GKED", length = 254)
    private String naimenovanieGKED;

    @Column(name = "ORGAN_UPRAVLENIA", length = 200)
    private String organUpravlenia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KOD_PRAVOVOJ_FORMY_ID")
    private kg.infosystems.buhproject.entity.enumerations.KodyPravovojFormy kodPravovojFormy;

    @Column(name = "PREFIKS", length = 2)
    private String prefiks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAJL_LOGOTIP_ID")
    private kg.infosystems.buhproject.entity.catalogs.OrganizaciiPrisoedinennyeFajly fajlLogotip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAJL_FAKSIMIL1NAA_PECAT1_ID")
    private kg.infosystems.buhproject.entity.catalogs.OrganizaciiPrisoedinennyeFajly fajlFaksimil1naaPecat1;

    @Column(name = "SOATO", length = 14)
    private String sOATO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RAJONNOE_OTDELENIE_KAZNACEJSTVA_ID")
    private kg.infosystems.buhproject.entity.catalogs.RajonnoeOtdelenieKaznacejstva rajonnoeOtdelenieKaznacejstva;

    @Column(name = "KOD_V_VEDOMSTVENNOM_KLASSIFIKATORE", length = 10)
    private String kodVVedomstvennomKlassifikatore;

    @Column(name = "KOD_V_FUNKCIONAL1NOM_KLASSIFIKATORE", length = 10)
    private String kodVFunkcional1nomKlassifikatore;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OrderBy("nomerStroki")
    @OneToMany(mappedBy = "part")
    private List<OrganizaciiKontaktnaaInformacia> kontaktnaaInformacia;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "organizacii")
    private List<RegistrasionnyiNomerSf> registrasionnyiNomerSf;


    @JoinColumn(name = "STAVKA_PROFSOYUZA_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private StavkaProfsoyuza stavkaProfsoyuza;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "organizacii")
    private List<TarifyPodohodnogoNaloga> podohodnyiNalog_;

    @Column(name = "PRIM_TEST", length = 45)
    private String primTest;

}
