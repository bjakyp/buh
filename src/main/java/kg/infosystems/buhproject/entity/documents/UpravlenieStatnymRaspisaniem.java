package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;
import kg.infosystems.buhproject.entity.enumerations.StatnoeRaspisanieStatus;
import kg.infosystems.buhproject.entity.parts.documents.Employees;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JmixEntity
@Table(name = "upravlenie_statnym_raspisaniem", schema = "documents", indexes = {
        @Index(name = "IDX_UPRAVLENIE_STATNYM_RASPISANIEM_ORGANIZACII", columnList = "ORGANIZACII_ID")
})
@Entity
@Getter
@Setter
public class UpravlenieStatnymRaspisaniem extends BaseEntity {

    @Column(name = "DOCUMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date documentDate;

    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "upravlenieStatnymRaspisaniem")
    private List<Employees> employees;

    @JoinColumn(name = "ORGANIZACII_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacii organizacii;

    @Column(name = "PERIOD_")
    private Integer period;

    @JoinColumn(name = "STATUS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatnoeRaspisanieStatus status;
}
