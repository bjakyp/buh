package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.Doverennost1OS;
import kg.infosystems.buhproject.entity.parts.documents.Doverennost1Tovary;
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
@Table(name = "Doverennost1", schema = "documents")
@Getter
@Setter
public class Doverennost1 {
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
    @JoinColumn(name = "FIZ_LICO_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "KONTRAGENT_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

    @NotNull
    @Column(name = "KOLICESTVO_DNEJ_DEJSTVIA", nullable = false, precision = 3, scale = 0)
    private BigDecimal kolicestvoDnejDejstvia;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BANKOVSKIJ_SCET_ID", nullable = false)
    private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScet;

    @Column(name = "SERIA_PASPORTA", length = 10)
    private String seriaPasporta;

    @Column(name = "NOMER_PASPORTA", length = 20)
    private String nomerPasporta;

    @Column(name = "DATA_VYDACI")
    private LocalDateTime dataVydaci;

    @Column(name = "SROK_DEJSTVIA")
    private LocalDateTime srokDejstvia;

    @Column(name = "KEM_VYDAN", length = 20)
    private String kemVydan;

    @Column(name = "POLUCENO_OT", length = 200)
    private String polucenoOt;

    @Column(name = "PO_DOKUMENTU", length = 200)
    private String poDokumentu;

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
    private List<Doverennost1Tovary> tovary;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OrderBy("nomerStroki")
    @OneToMany(mappedBy = "part")
    private List<Doverennost1OS> os;
}
