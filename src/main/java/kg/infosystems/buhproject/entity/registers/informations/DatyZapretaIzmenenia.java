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
@Entity(name = "informations_DatyZapretaIzmenenia")
@Table(name = "DatyZapretaIzmeneniaIr", schema = "informations")
@Getter
@Setter
public class DatyZapretaIzmenenia extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RAZDEL_ID")
    private kg.infosystems.buhproject.entity.characteristics.RazdelyDatZapretaIzmenenia razdel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple ob2ekt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@Column(name = "DATA_ZAPRETA")
    private LocalDateTime dataZapreta;

	@Column(name = "OPISANIE_DATY_ZAPRETA", length = 1000)
    private String opisanieDatyZapreta;

	@Column(name = "KOMMENTARIJ", length = 1000)
    private String kommentarij;

}
