package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "NACISLENIYA_I_UDERJANIYA", schema = "documents")
@Entity
@Getter
@Setter
public class NacisleniyaIUderjaniya {

    @JoinColumn(name = "NACISLENIE_ZARPLATY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private kg.infosystems.buhproject.entity.documents.NacislenieZarplaty nacislenieZarplaty;

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
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

    @Column(name = "NOMER", length = 14)
    private String nomer;

    @Column(name = "TIP_DOHODA")
    private String tipDohoda;

    @Column(name = "NACISLENO", precision = 19, scale = 2)
    private BigDecimal nacisleno;

    @Column(name = "UDERJANO", precision = 19, scale = 2)
    private BigDecimal uderjano;

    @InstanceName
    @JoinColumn(name = "SOTRUDNIK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

    @Column(name = "NE_OBLAGAEMAJA_CAST_PN", precision = 19, scale = 2)
    private BigDecimal neOblagaemajaCastPN;

    @Column(name = "NE_OBLAGAEMAJA_CAST_SV", precision = 19, scale = 2)
    private BigDecimal neOblagaemajaCastSV;

    @Column(name = "GNPF", precision = 19, scale = 2)
    private BigDecimal gnpf;

    @Column(name = "ITOGO_SV", precision = 19, scale = 2)
    private BigDecimal itogoSv;

    @Column(name = "PROCIE", precision = 19, scale = 2)
    private BigDecimal procieF;

    @Column(name = "ITOGO_PN", precision = 19, scale = 2)
    private BigDecimal itogoPn;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "nacisleniaIUderjania")
    private List<kg.infosystems.buhproject.entity.parts.documents.NacisleniaNacisleniaIUderjania> nacislenia;

    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "UDERJANIA")
    @Composition
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private kg.infosystems.buhproject.entity.parts.documents.UderjaniaNacisleniaIUderjania uderjania;

    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "PROCIE_UDERJANIA")
    @Composition
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private kg.infosystems.buhproject.entity.parts.documents.ProcieUderjania procieUderjania;

}
