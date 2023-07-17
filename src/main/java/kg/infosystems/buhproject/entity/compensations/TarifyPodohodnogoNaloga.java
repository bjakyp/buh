package kg.infosystems.buhproject.entity.compensations;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.StavkiPodohodnogoNaloga;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "TARIFY_PODOHODNOGO_NALOGA", schema = "comps", indexes = {
    @Index(name = "IDX_TARIFY_PODOHODNOGO_NALOGA_ORGANIZACII", columnList = "ORGANIZACII_ID"),
    @Index(name = "IDX_TARIFY_PODOHODNOGO_NALOGA_STAVKI_PODOHODNOGO_NALOGA_", columnList = "STAVKI_PODOHODNOGO_NALOGA__ID")
})
@Entity
public class TarifyPodohodnogoNaloga {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DATA_VSTUPLENIE_DEISTVIE")
    private LocalDate dataVstuplenieDeistvie;

    @JoinColumn(name = "STAVKI_PODOHODNOGO_NALOGA__ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private StavkiPodohodnogoNaloga stavkiPodohodnogoNaloga_;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "ORGANIZACII_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacii organizacii;

    @Column(name = "STATUS")
    private Boolean status;

    public LocalDate getDataVstuplenieDeistvie() {
        return dataVstuplenieDeistvie;
    }

    public void setDataVstuplenieDeistvie(LocalDate dataVstuplenieDeistvie) {
        this.dataVstuplenieDeistvie = dataVstuplenieDeistvie;
    }

    public StavkiPodohodnogoNaloga getStavkiPodohodnogoNaloga_() {
        return stavkiPodohodnogoNaloga_;
    }

    public void setStavkiPodohodnogoNaloga_(StavkiPodohodnogoNaloga stavkiPodohodnogoNaloga_) {
        this.stavkiPodohodnogoNaloga_ = stavkiPodohodnogoNaloga_;
    }

    public Organizacii getOrganizacii() {
        return organizacii;
    }

    public void setOrganizacii(Organizacii organizacii) {
        this.organizacii = organizacii;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"stavkiPodohodnogoNaloga_"})
    public String getInstanceName() {
        return String.format("%s", stavkiPodohodnogoNaloga_);
    }
}
