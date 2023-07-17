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
@Entity(name = "informations_ParametryRabotyVersijRassirenij")
@Table(name = "ParametryRabotyVersijRassirenijIr", schema = "informations")
@Getter
@Setter
public class ParametryRabotyVersijRassirenij extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VERSIA_RASSIRENIJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.VersiiRassirenij versiaRassirenij;

	@Column(name = "IMA_PARAMETRA", length = 128)
    private String imaParametra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_PARAMETRA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseParametra;

}
