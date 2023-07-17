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
@Entity(name = "informations_NastrojkiPravOb2ektov")
@Table(name = "NastrojkiPravOb2ektovIr", schema = "informations")
@Getter
@Setter
public class NastrojkiPravOb2ektov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
    private kg.infosystems.buhproject.entity.catalogs.PapkiFajlov ob2ekt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@Column(name = "PRAVO", length = 60)
    private String pravo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TABLICA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple tablica;

	@Column(name = "PRAVO_ZAPRESENO")
    private Boolean pravoZapreseno;

	@Column(name = "NASLEDOVANIE_RAZRESENO")
    private Boolean nasledovanieRazreseno;

	@Column(name = "PORADOK_NASTROJKI", precision = 4, scale = 0)
    private BigDecimal poradokNastrojki;

	@Column(name = "UROVEN1_RAZRESENIA_PRAVA", precision = 1, scale = 0)
    private BigDecimal uroven1RazreseniaPrava;

	@Column(name = "UROVEN1_ZAPRESENIA_PRAVA", precision = 1, scale = 0)
    private BigDecimal uroven1ZapreseniaPrava;

	@Column(name = "UROVEN1_RAZRESENIA_CTENIA", precision = 1, scale = 0)
    private BigDecimal uroven1RazreseniaCtenia;

	@Column(name = "UROVEN1_ZAPRESENIA_CTENIA", precision = 1, scale = 0)
    private BigDecimal uroven1ZapreseniaCtenia;

	@Column(name = "UROVEN1_RAZRESENIA_IZMENENIA", precision = 1, scale = 0)
    private BigDecimal uroven1RazreseniaIzmenenia;

	@Column(name = "UROVEN1_ZAPRESENIA_IZMENENIA", precision = 1, scale = 0)
    private BigDecimal uroven1ZapreseniaIzmenenia;

}
