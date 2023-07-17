package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SostoaniaProverokVedeniaUceta")
@Table(name = "SostoaniaProverokVedeniaUcetaIr", schema = "informations")
@Getter
@Setter
public class SostoaniaProverokVedeniaUceta extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVERKA_ID")
    private kg.infosystems.buhproject.entity.catalogs.PravilaProverkiUceta proverka;

    @Column(name = "POSLEDNIJ_ZAPUSK")
    private LocalDateTime poslednijZapusk;

}
