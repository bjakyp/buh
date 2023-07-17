package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.Dolznosti;
import kg.infosystems.buhproject.entity.compensations.VidyPosobiy;
import kg.infosystems.buhproject.entity.enumerations.Procenty;
import kg.infosystems.buhproject.entity.parts.documents.Bol1nicnyjListNacislenia;
import kg.infosystems.buhproject.entity.parts.documents.Bol1nicnyjListSrednijZarabotok;
import kg.infosystems.buhproject.entity.registers.informations.RazovoeNacislenie;
import kg.infosystems.buhproject.entity.registers.informations.Tabel1UcetaPoseshenia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Bol1nicnyjList", schema = "documents", indexes = {
    @Index(name = "IDX_BOL1NICNYJLIST_VID_POSOBII", columnList = "VID_POSOBII_ID"),
    @Index(name = "IDX_BOL1NICNYJLIST_PROCENT", columnList = "PROCENT_ID"),
    @Index(name = "IDX_BOL1NICNYJLIST_REGISTER_POSOBIA", columnList = "REGISTER_POSOBIA_ID")
})
@Getter
@Setter
public class Bol1nicnyjList {
    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;

    @JoinColumn(name = "PROCENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Procenty procent;

    @JoinColumn(name = "VID_POSOBII_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private VidyPosobiy vidPosobii;

    @Column(name = "VERSIA_DANNYH")
    @Version
    private Integer versiaDannyh;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "NOMER", length = 9)
    private String nomer;

    @Column(name = "PROVEDEN")
    private Boolean proveden;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORGANIZACIA_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GRAFIK_RABOTY_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @Column(name = "KOLICESTVO_LET_STAZA", precision = 2, scale = 0)
    private BigDecimal kolicestvoLetStaza;

    @Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

    @Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

    @Column(name = "DNEJ", precision = 3, scale = 0)
    private BigDecimal dnej;

    @Column(name = "DNEJ_ORGANIZACII", precision = 3, scale = 0)
    private BigDecimal dnejOrganizacii;

    @Column(name = "DNEJ_ZA_SCET_SF", precision = 3, scale = 0)
    private BigDecimal dnejZaScetSF;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PODRAZDELENIE_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @Lob
    @Column(name = "KOMMENTARIJ")
    private String kommentarij;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AVTOR_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OrderBy("nomerStroki")
    @OneToMany(mappedBy = "part", cascade = CascadeType.PERSIST)
    private List<Bol1nicnyjListSrednijZarabotok> srednijZarabotok;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OrderBy("nomerStroki")
    @OneToMany(mappedBy = "part", cascade = CascadeType.PERSIST)
    private List<Bol1nicnyjListNacislenia> nacislenia;

    @JoinColumn(name = "DOLZNOST1_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dolznosti dolznost1;

    @Column(name = "DATA_VYDACI_LISTKA")
    private LocalDateTime dataVydaciListka;

    @Column(name = "ORGANIZASIA_ZDRAVOHRANENIA", length = 80)
    private String organizasiaZdravohranenia;

    @Column(name = "NOMER_LISTKA")
    private String nomerListka;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "bol1nicnyjList", cascade = CascadeType.PERSIST)
    private List<RazovoeNacislenie> regRazovoeNacislenie;

    @JoinColumn(name = "REGISTER_POSOBIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tabel1UcetaPoseshenia registerPosobia;

    @InstanceName
    @DependsOnProperties({"data", "nomer"})
    public String getInstanceName() {
        return String.format("%s %s", data, nomer);
    }

}
