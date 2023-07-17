package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_PoosreniaIVzyskania")
@Table(name = "PoosreniaIVzyskaniaIr", schema = "informations")
@Getter
@Setter
public class PoosreniaIVzyskania extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

    @Column(name = "NOMER_PRIKAZA", length = 10)
    private String nomerPrikaza;

    @Column(name = "DATA_PRIKAZA")
    private LocalDateTime dataPrikaza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NAGRADA_ID")
    private kg.infosystems.buhproject.entity.catalogs.PoosreniaIVzyskania nagrada;

    @Lob
    @Column(name = "NAIMENOVANIE_PRIKAZA")
    private String naimenovaniePrikaza;

}
