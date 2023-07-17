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
@Entity(name = "informations_ObnovlenieKlucejDostupaKDannym")
@Table(name = "ObnovlenieKlucejDostupaKDannymIr", schema = "informations")
@Getter
@Setter
public class ObnovlenieKlucejDostupaKDannym extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPISOK_ID")
    private kg.infosystems.buhproject.entity.one.Multiple spisok;

	@Column(name = "DLA_VNESNIH_POL1ZOVATELEJ")
    private Boolean dlaVnesnihPol1zovatelej;

	@Column(name = "KLUC_UNIKAL1NOSTI")
    private UUID klucUnikal1nosti;

	@Column(name = "TOCECNOE_ZADANIE")
    private Boolean tocecnoeZadanie;

	@Column(name = "DATA_POSLEDNEGO_OBNOVLENNOGO_ELEMENTA")
    private LocalDateTime dataPoslednegoObnovlennogoElementa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARAMETRY_ZADANIA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage parametryZadania;

	@Column(name = "RAZMER_ZADANIA", precision = 1, scale = 0)
    private BigDecimal razmerZadania;

	@Column(name = "DATA_IZMENENIA_ZAPISI_REGISTRA")
    private LocalDateTime dataIzmeneniaZapisiRegistra;

}
