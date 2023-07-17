package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_TablicyGruppDostupa")
@Table(name = "TablicyGruppDostupaIr", schema = "informations")
@Getter
@Setter
public class TablicyGruppDostupa extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TABLICA_ID")
	private kg.infosystems.buhproject.entity.one.Multiple tablica;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRUPPA_DOSTUPA_ID")
	private kg.infosystems.buhproject.entity.catalogs.GruppyDostupa gruppaDostupa;

	@Column(name = "IZMENENIE")
	private Boolean izmenenie;

	@Column(name = "DOBAVLENIE")
	private Boolean dobavlenie;

	@Column(name = "CTENIE_BEZ_OGRANICENIA")
	private Boolean ctenieBezOgranicenia;

	@Column(name = "IZMENENIE_BEZ_OGRANICENIA")
	private Boolean izmenenieBezOgranicenia;

	@Column(name = "DOBAVLENIE_BEZ_OGRANICENIA")
	private Boolean dobavlenieBezOgranicenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_TABLICY_ID")
	private kg.infosystems.buhproject.entity.one.Multiple tipTablicy;

}
