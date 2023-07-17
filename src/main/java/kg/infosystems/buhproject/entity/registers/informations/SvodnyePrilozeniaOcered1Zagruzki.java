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
@Entity(name = "informations_SvodnyePrilozeniaOcered1Zagruzki")
@Table(name = "SvodnyePrilozeniaOcered1ZagruzkiIr", schema = "informations")
@Getter
@Setter
public class SvodnyePrilozeniaOcered1Zagruzki extends BaseEntity {
	@Column(name = "KOD_UZLA", length = 36)
    private String kodUzla;

	@Column(name = "NOMER", precision = 5, scale = 0)
    private BigDecimal nomer;

	@Column(name = "IMA_FAJLA", length = 255)
    private String imaFajla;

}
