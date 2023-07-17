package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.Organizacii;
import kg.infosystems.buhproject.entity.globals.Rok;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "Predel1naaCislennost1", schema = "documents", indexes = {
    @Index(name = "IDX_PREDEL1NAACISLENNOST1_TUMF", columnList = "TUMF_ID"),
    @Index(name = "IDX_PREDEL1NAACISLENNOST1_ORGANIZACIA", columnList = "ORGANIZACIA_ID")
})
@Entity
@Getter
@Setter
public class Predel1naaCislennost1 {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "PARENT")
    @ManyToOne(fetch = FetchType.LAZY)
    private Predel1naaCislennost1 parent;

    @Column(name = "AUP")
    private Integer aup;

    @Column(name = "OSNOVNOY_PERSONAL")
    private Integer osnovnoyPersonal;

    @Column(name = "TOP_AND_MOP")
    private Integer topAndMop;

    @Column(name = "VSEGO")
    private Integer vsego;

    @JoinColumn(name = "TUMF_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rok tumf;

    @JoinColumn(name = "ORGANIZACIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacii organizacia;
}
