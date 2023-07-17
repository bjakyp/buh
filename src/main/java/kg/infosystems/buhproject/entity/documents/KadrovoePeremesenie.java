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
import kg.infosystems.buhproject.entity.parts.documents.KadrovoePeremesenieNacislenia;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaNacalo;
import kg.infosystems.buhproject.entity.registers.informations.PlanovyeNacisleniaOkoncanie;
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
@Table(name = "KadrovoePeremesenie", schema = "documents", indexes = {
    @Index(name = "IDX_KADROVOEPEREMESENIE_KATEGORIA_RABOTNIKOV", columnList = "KATEGORIA_RABOTNIKOV_ID")
})
@Getter
@Setter
public class KadrovoePeremesenie {
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
    @Column(name = "PERIOD", nullable = false)
    private LocalDateTime period;

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
    private List<KadrovoePeremesenieNacislenia> nacislenia;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "register_id")
    private Sotrudniki registerSotrudnika;

    @OneToMany(mappedBy = "kadrovoePeremesenie")
    private List<PlanovyeNacisleniaNacalo> planovyeNacisleniaNacalo;

    @OneToMany(mappedBy = "kadrovoePeremesenie")
    private List<PlanovyeNacisleniaOkoncanie> planovyeNacisleniaOkoncanie;

    @JoinColumn(name = "KATEGORIA_RABOTNIKOV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private KategoriaRabotnikov kategoriaRabotnikov;

    @Column(name = "KOLVO_IJDIVENCEV")
    private Integer kolvoIjdivencev;

    @InstanceName
    @DependsOnProperties({"data", "nomer"})
    public String getInstanceName() {
        return String.format("%s %s", data, nomer);
    }

}
