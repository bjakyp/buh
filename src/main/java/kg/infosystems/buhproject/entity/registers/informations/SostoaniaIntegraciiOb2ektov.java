package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_SostoaniaIntegraciiOb2ektov")
@Table(name = "SostoaniaIntegraciiOb2ektovIr", schema = "informations")
@Getter
@Setter
public class SostoaniaIntegraciiOb2ektov extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_OB2EKTA", length = 50)
	private String identifikatorOb2ekta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCETNAA_SISTEMA_ID")
	private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ucetnaaSistema;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTOANIE_ID")
	private kg.infosystems.buhproject.entity.enumerations.SostoaniaIntegraciiOb2ektov sostoanie;

	@Column(name = "OPISANIE", length = 1000)
	private String opisanie;

}
