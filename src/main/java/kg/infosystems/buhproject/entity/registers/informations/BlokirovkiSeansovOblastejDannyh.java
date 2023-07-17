package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_BlokirovkiSeansovOblastejDannyh")
@Table(name = "BlokirovkiSeansovOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class BlokirovkiSeansovOblastejDannyh extends BaseEntity {
    @Column(name = "NACALO_BLOKIROVKI")
    private LocalDateTime nacaloBlokirovki;

    @Column(name = "KONEC_BLOKIROVKI")
    private LocalDateTime konecBlokirovki;

    @Column(name = "SOOBSENIE_BLOKIROVKI", length = 300)
    private String soobsenieBlokirovki;

    @Column(name = "EKSKLUZIVNAA")
    private Boolean ekskluzivnaa;

    @Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
