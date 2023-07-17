package kg.infosystems.buhproject.entity.compensations;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.MetodyRascetaBol1nicnogoLista;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "VIDY_POSOBIY", schema = "comps", indexes = {
    @Index(name = "IDX_VIDY_POSOBIY_METODY_RASCETA_POSOBII", columnList = "METODY_RASCETA_POSOBII_ID")
})
@Entity
@Getter
@Setter
public class VidyPosobiy extends BaseEntity {

    @Column(name = "CODE", length = 25)
    private String code;

    @InstanceName
    @Column(name = "NAME", length = 500)
    private String name;

    @Column(name = "SHORT_NAME", length = 500)
    private String shortName;

//    @JoinColumn(name = "PARENT")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Rok parent;

    @Column(name = "ACTIVE")
    private Boolean active;

    @JoinColumn(name = "METODY_RASCETA_POSOBII_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetodyRascetaBol1nicnogoLista metodyRascetaPosobii;

    public MetodyRascetaBol1nicnogoLista getMetodyRascetaPosobii() {
        return metodyRascetaPosobii;
    }

    public void setMetodyRascetaPosobii(MetodyRascetaBol1nicnogoLista metodyRascetaPosobii) {
        this.metodyRascetaPosobii = metodyRascetaPosobii;
    }
}
