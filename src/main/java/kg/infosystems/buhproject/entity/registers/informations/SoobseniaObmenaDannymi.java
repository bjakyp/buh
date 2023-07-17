package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SoobseniaObmenaDannymi")
@Table(name = "SoobseniaObmenaDannymiIr", schema = "informations")
@Getter
@Setter
public class SoobseniaObmenaDannymi extends BaseEntity {
    @Column(name = "IDENTIFIKATOR_SOOBSENIA", length = 36)
    private String identifikatorSoobsenia;

    @Column(name = "IMA_FAJLA_SOOBSENIA")
    private String imaFajlaSoobsenia;

    @Column(name = "DATA_ZAKLADKI_SOOBSENIA")
    private LocalDateTime dataZakladkiSoobsenia;

}
