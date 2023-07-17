package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_RezimyPodkluceniaVnesnihModulejOblastejDannyh")
@Table(name = "RezimyPodkluceniaVnesnihModulejOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class RezimyPodkluceniaVnesnihModulejOblastejDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_PROGRAMMNOGO_MODULA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple tipProgrammnogoModula;

	@Column(name = "IDENTIFIKATOR_PROGRAMMNOGO_MODULA")
    private UUID identifikatorProgrammnogoModula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BEZOPASNYJ_REZIM_ID")
    private kg.infosystems.buhproject.entity.one.Multiple bezopasnyjRezim;

	@Lob
	@Column(name = "PREDSTAVLENIE_PROGRAMMNOGO_MODULA")
    private String predstavlenieProgrammnogoModula;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
