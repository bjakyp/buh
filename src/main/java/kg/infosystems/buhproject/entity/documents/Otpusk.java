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
import kg.infosystems.buhproject.entity.compensations.VidyOtpuska;
import kg.infosystems.buhproject.entity.parts.documents.OtpuskNacislenia;
import kg.infosystems.buhproject.entity.parts.documents.OtpuskSrednijZarabotok;
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
@Table(name = "Otpusk", schema = "documents", indexes = {
    @Index(name = "IDX_OTPUSK_REGISTER_TABELYA", columnList = "REGISTER_TABELYA_ID")
})
@Getter
@Setter
public class Otpusk {
    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "otpusk")
    private List<RazovoeNacislenie> regRazovoeNacislenie;

    @JoinColumn(name = "VIDY_OTPUSKA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private VidyOtpuska vidyOtpuskov;

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

    @NotNull
    @Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

    @NotNull
    @Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

    @Column(name = "DNEJ", precision = 3, scale = 0)
    private BigDecimal dnej;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PODRAZDELENIE_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOLZNOST1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

    @Lob
    @Column(name = "KOMMENTARIJ")
    private String kommentarij;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AVTOR_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OrderBy("nomerStroki")
    @OneToMany(mappedBy = "part")
    private List<OtpuskSrednijZarabotok> srednijZarabotok;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OrderBy("nomerStroki")
    @OneToMany(mappedBy = "part")
    private List<OtpuskNacislenia> nacislenia;

    @JoinColumn(name = "REGISTER_TABELYA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tabel1UcetaPoseshenia registerTabelya;

    @InstanceName
    @DependsOnProperties({"data", "nomer"})
    public String getInstanceName() {
        return String.format("%s %s", data, nomer);
    }

}
