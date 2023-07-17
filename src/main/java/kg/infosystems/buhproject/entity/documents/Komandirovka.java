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
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.parts.documents.KomandirovkaSotrudniki;
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
@Table(name = "Komandirovka", schema = "documents", indexes = {
    @Index(name = "IDX_KOMANDIROVKA_REGISTER_TABELYA", columnList = "REGISTER_TABELYA_ID"),
    @Index(name = "IDX_KOMANDIROVKA_VID_NACISLENII", columnList = "VID_NACISLENII_ID")
})
@Getter
@Setter
public class Komandirovka {
    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;

    @JoinColumn(name = "REGISTER_TABELYA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tabel1UcetaPoseshenia registerTabelya;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "komandirovka")
    private List<RazovoeNacislenie> regRazovoeNacislenie;

    @Column(name = "VERSIA_DANNYH")
    @Version
    private Integer versiaDannyh;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

    @NotNull
    @Column(name = "DATA", nullable = false)
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
    @JoinColumn(name = "STRANA_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.StranyMira strana;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GOROD_ID")
    private kg.infosystems.buhproject.entity.catalogs.Goroda gorod;

    @Column(name = "KOLICESTVO_DNEJ", precision = 3, scale = 0)
    private BigDecimal kolicestvoDnej;

    @NotNull
    @Column(name = "DATA_NACALA", nullable = false)
    private LocalDateTime dataNacala;

    @NotNull
    @Column(name = "DATA_OKONCANIA", nullable = false)
    private LocalDateTime dataOkoncania;

    @Column(name = "SODERZANIE_O_VYPLATE", length = 250)
    private String soderzanieOVyplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @Column(name = "OPLATA_PO_SREDNEMU_ZARABOTKU")
    private Boolean oplataPoSrednemuZarabotku;

    @Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
    private BigDecimal summaDokumenta;

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
    private List<KomandirovkaSotrudniki> sotrudniki;

    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "VID_NACISLENII_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private VidyNacislenij vidNacislenii;

    @InstanceName
    @DependsOnProperties({"data", "nomer"})
    public String getInstanceName() {
        return String.format("%s %s", data, nomer);
    }

}
