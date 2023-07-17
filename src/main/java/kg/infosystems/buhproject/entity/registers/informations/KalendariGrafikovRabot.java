package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_KalendariGrafikovRabot")
@Table(name = "KalendariGrafikovRabotIr", schema = "informations")
@Getter
@Setter
public class KalendariGrafikovRabot extends BaseEntity {
    @Column(name = "DATA")
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAFIK_RABOTY_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @Column(name = "GOD", precision = 4, scale = 0)
    private BigDecimal god;

    @Column(name = "ZNACENIE_DNEJ", precision = 3, scale = 0)
    private BigDecimal znacenieDnej;

    @Column(name = "ZNACENIE_CASOV", precision = 5, scale = 2)
    private BigDecimal znacenieCasov;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_DNA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyDnejProizvodstvennogoKalendara vidDna;

}
