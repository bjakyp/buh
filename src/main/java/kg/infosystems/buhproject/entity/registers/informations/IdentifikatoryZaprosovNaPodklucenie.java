package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Entity(name = "informations_IdentifikatoryZaprosovNaPodklucenie")
@Table(name = "IdentifikatoryZaprosovNaPodklucenieIr", schema = "informations")
@Getter
@Setter
public class IdentifikatoryZaprosovNaPodklucenie extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDENTIFIKATOR_SERVISA_SOPROVOZDENIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryServisovSoprovozdenia identifikatorServisaSoprovozdenia;

	@Column(name = "IDENTIFIKATOR")
	private UUID identifikator;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTOANIE_ID")
	private kg.infosystems.buhproject.entity.enumerations.SostoaniaPodkluceniaServisov sostoanie;

	@Column(name = "IDENTIFIKATOR_TESTOVOGO_PERIODA")
	private String identifikatorTestovogoPerioda;

	@Column(name = "NAIMENOVANIE_TESTOVOGO_PERIODA")
	private String naimenovanieTestovogoPerioda;

	@Column(name = "OPISANIE_OSIBKI")
	private String opisanieOsibki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli pol1zovatel1;

}
