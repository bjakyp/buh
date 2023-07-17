package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.KategoriaRabotnikov;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Table(name = "STAVKI_STRAHOVYH_VZNOSOV", schema = "parts_documents", indexes = {
    @Index(name = "IDX_STAVKI_STRAHOVYH_VZNOSOV_DOCUMENT_STAVKI", columnList = "DOCUMENT_STAVKI_ID"),
    @Index(name = "IDX_STAVKI_STRAHOVYH_VZNOSOV_KATEGORIA_RABOTNIKOV_", columnList = "KATEGORIA_RABOTNIKOV__ID")
})
@Entity
public class StavkiStrahovyhVznosov {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "KATEGORIA_RABOTNIKOV__ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private KategoriaRabotnikov kategoriaRabotnikov_;

    @Column(name = "PF_RABOTODATEL", precision = 7, scale = 2)
    private BigDecimal pfRabotodatel;

    @Column(name = "PF_RABOTNIK", precision = 7, scale = 2)
    private BigDecimal pfRabotnik;

    @Column(name = "FOMS_RABOTADATEL", precision = 7, scale = 2)
    private BigDecimal fomsRabotadatel;

    @Column(name = "FOMS_RABOTNIK", precision = 7, scale = 2)
    private BigDecimal fomsRabotnik;

    @Column(name = "FOT_RABOTODATEL", precision = 7, scale = 2)
    private BigDecimal fotRabotodatel;

    @Column(name = "FOT_RABOTNIK", precision = 7, scale = 2)
    private BigDecimal fotRabotnik;

    @Column(name = "GNPF_RABOTNIK", precision = 7, scale = 2)
    private BigDecimal gnpfRabotnik;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "DOCUMENT_STAVKI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DocumentStavki documentStavki;

    public KategoriaRabotnikov getKategoriaRabotnikov_() {
        return kategoriaRabotnikov_;
    }

    public void setKategoriaRabotnikov_(KategoriaRabotnikov kategoriaRabotnikov_) {
        this.kategoriaRabotnikov_ = kategoriaRabotnikov_;
    }

    public DocumentStavki getDocumentStavki() {
        return documentStavki;
    }

    public void setDocumentStavki(DocumentStavki documentStavki) {
        this.documentStavki = documentStavki;
    }

    public void setPfRabotnik(BigDecimal pfRabotnik) {
        this.pfRabotnik = pfRabotnik;
    }

    public BigDecimal getPfRabotnik() {
        return pfRabotnik;
    }

    public void setFomsRabotadatel(BigDecimal fomsRabotadatel) {
        this.fomsRabotadatel = fomsRabotadatel;
    }

    public BigDecimal getFomsRabotadatel() {
        return fomsRabotadatel;
    }

    public void setFomsRabotnik(BigDecimal fomsRabotnik) {
        this.fomsRabotnik = fomsRabotnik;
    }

    public BigDecimal getFomsRabotnik() {
        return fomsRabotnik;
    }

    public BigDecimal getGnpfRabotnik() {
        return gnpfRabotnik;
    }

    public void setGnpfRabotnik(BigDecimal gnpfRabotnik) {
        this.gnpfRabotnik = gnpfRabotnik;
    }

    public BigDecimal getFotRabotnik() {
        return fotRabotnik;
    }

    public void setFotRabotnik(BigDecimal fotRabotnik) {
        this.fotRabotnik = fotRabotnik;
    }

    public BigDecimal getFotRabotodatel() {
        return fotRabotodatel;
    }

    public void setFotRabotodatel(BigDecimal fotRabotodatel) {
        this.fotRabotodatel = fotRabotodatel;
    }

    public void setPfRabotodatel(BigDecimal pfRabotodatel) {
        this.pfRabotodatel = pfRabotodatel;
    }

    public BigDecimal getPfRabotodatel() {
        return pfRabotodatel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
