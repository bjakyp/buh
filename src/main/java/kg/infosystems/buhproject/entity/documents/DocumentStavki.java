package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.TarifyStrahovyhVznosov;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "DOCUMENT_STAVKI", schema = "documents", indexes = {
    @Index(name = "IDX_DOCUMENT_STAVKI_TARIFY_STRAHOVYH_VZNOSOV", columnList = "TARIFY_STRAHOVYH_VZNOSOV_ID")
})
@Entity
public class DocumentStavki {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NOMER", length = 10)
    private String nomer;

    @Column(name = "DATA_DOCUMENTA")
    private LocalDate dataDocumenta;

    @Column(name = "DATA_VSTUPLENIE_DEISTVIA")
    private LocalDate dataVstuplenieDeistvia;

    @Composition
    @OneToMany(mappedBy = "documentStavki")
    private List<StavkiStrahovyhVznosov> stavkiStrahovyhVznosov_;

    @JoinColumn(name = "TARIFY_STRAHOVYH_VZNOSOV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarifyStrahovyhVznosov tarifyStrahovyhVznosov_;

    public TarifyStrahovyhVznosov getTarifyStrahovyhVznosov_() {
        return tarifyStrahovyhVznosov_;
    }

    public void setTarifyStrahovyhVznosov_(TarifyStrahovyhVznosov tarifyStrahovyhVznosov_) {
        this.tarifyStrahovyhVznosov_ = tarifyStrahovyhVznosov_;
    }

    public List<StavkiStrahovyhVznosov> getStavkiStrahovyhVznosov_() {
        return stavkiStrahovyhVznosov_;
    }

    public void setStavkiStrahovyhVznosov_(List<StavkiStrahovyhVznosov> stavkiStrahovyhVznosov_) {
        this.stavkiStrahovyhVznosov_ = stavkiStrahovyhVznosov_;
    }

    public LocalDate getDataVstuplenieDeistvia() {
        return dataVstuplenieDeistvia;
    }

    public void setDataVstuplenieDeistvia(LocalDate dataVstuplenieDeistvia) {
        this.dataVstuplenieDeistvia = dataVstuplenieDeistvia;
    }

    public LocalDate getDataDocumenta() {
        return dataDocumenta;
    }

    public void setDataDocumenta(LocalDate dataDocumenta) {
        this.dataDocumenta = dataDocumenta;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
