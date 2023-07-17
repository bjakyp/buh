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
@Entity(name = "informations_SoobseniaObmenaDannymiOblastejDannyh")
@Table(name = "SoobseniaObmenaDannymiOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class SoobseniaObmenaDannymiOblastejDannyh extends BaseEntity {
    @Column(name = "IDENTIFIKATOR_SOOBSENIA", length = 36)
    private String identifikatorSoobsenia;

    @Column(name = "IMA_FAJLA_SOOBSENIA")
    private String imaFajlaSoobsenia;

    @Column(name = "DATA_ZAKLADKI_SOOBSENIA")
    private LocalDateTime dataZakladkiSoobsenia;

    @Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
