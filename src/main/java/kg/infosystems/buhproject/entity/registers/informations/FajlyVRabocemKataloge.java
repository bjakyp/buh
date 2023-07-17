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
@Entity(name = "informations_FajlyVRabocemKataloge")
@Table(name = "FajlyVRabocemKatalogeIr", schema = "informations")
@Getter
@Setter
public class FajlyVRabocemKataloge extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_ID")
    private kg.infosystems.buhproject.entity.one.Multiple fajl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@Column(name = "PUT1", length = 255)
    private String put1;

	@Column(name = "RAZMER", precision = 10, scale = 0)
    private BigDecimal razmer;

	@Column(name = "DATA_POMESENIA_V_RABOCIJ_KATALOG")
    private LocalDateTime dataPomeseniaVRabocijKatalog;

	@Column(name = "NA_CTENIE")
    private Boolean naCtenie;

	@Column(name = "V_RABOCEM_KATALOGE_VLADEL1CA")
    private Boolean vRabocemKatalogeVladel1ca;

}
