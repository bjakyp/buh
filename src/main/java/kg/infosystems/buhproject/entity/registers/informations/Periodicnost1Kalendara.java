package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_Periodicnost1Kalendara")
@Table(name = "Periodicnost1KalendaraIr", schema = "informations")
@Getter
@Setter
public class Periodicnost1Kalendara extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAFIK_RABOTY_ID")
    private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

    @Column(name = "GOD", precision = 4, scale = 0)
    private BigDecimal god;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "CASY", precision = 7, scale = 2)
    private BigDecimal casy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_DNA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyDnejProizvodstvennogoKalendara vidDna;

}
