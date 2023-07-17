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
import kg.infosystems.buhproject.entity.compensations.KategoriaRabotnikov;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.parts.documents.PriemNaRabotuNacislenia;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaNacalo;
import kg.infosystems.buhproject.entity.registers.informations.Sotrudniki;
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
@Table(name = "PriemNaRabotu", schema = "documents", indexes = {
    @Index(name = "IDX_PRIEMNARABOTU_KATEGORIA_RABOTNIKOV", columnList = "KATEGORIA_RABOTNIKOV_ID")
})
@Getter
@Setter
public class PriemNaRabotu {
    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;

    @Column(name = "KOLVO_IJDIVENCEV")
    private Integer kolvoIjdivencev;

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
    @JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PODRAZDELENIE_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOLZNOST1_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GRAFIK_RABOTY_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    private kg.infosystems.buhproject.entity.catalogs.Statusy status;

    @NotNull
    @Column(name = "PERIOD", nullable = false)
    private LocalDateTime period;

    @Column(name = "DATA_OKONCANIA_RABOTY")
    private LocalDateTime dataOkoncaniaRaboty;

    @Column(name = "ISPYTATEL1NYJ_SROK")
    private LocalDateTime ispytatel1nyjSrok;

    @NotNull
    @Column(name = "RAZMER", nullable = false, precision = 15, scale = 2)
    private BigDecimal razmer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "VID_RASCETA_ID", nullable = false)
    private VidyNacislenij vidRasceta;

    @NotNull
    @Column(name = "ZANIMAEMYH_STAVOK", nullable = false, precision = 3, scale = 2)
    private BigDecimal zanimaemyhStavok;

    @Column(name = "OBSIJ_STAZ_LET", precision = 2, scale = 0)
    private BigDecimal obsijStazLet;

    @Column(name = "OBSIJ_STAZ_MESACEV", precision = 2, scale = 0)
    private BigDecimal obsijStazMesacev;

    @Column(name = "OBSIJ_STAZ_DNEJ", precision = 2, scale = 0)
    private BigDecimal obsijStazDnej;

    @Lob
    @Column(name = "KOMMENTARIJ")
    private String kommentarij;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AVTOR_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

    @OrderBy("nomerStroki")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "part")
    private List<PriemNaRabotuNacislenia> nacislenia;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "register_id", referencedColumnName = "id")
    private Sotrudniki registerSotrudnika;

    @OneToMany(mappedBy = "priemNaRabotu")
    private List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacalo;

    @JoinColumn(name = "KATEGORIA_RABOTNIKOV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private KategoriaRabotnikov kategoriaRabotnikov;

    @InstanceName
    @DependsOnProperties({"data", "nomer"})
    public String getInstanceName() {
        return String.format("%s %s", data, nomer);
    }
}
