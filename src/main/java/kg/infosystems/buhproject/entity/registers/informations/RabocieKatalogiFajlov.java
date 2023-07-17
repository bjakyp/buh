package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_RabocieKatalogiFajlov")
@Table(name = "RabocieKatalogiFajlovIr", schema = "informations")
@Getter
@Setter
public class RabocieKatalogiFajlov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAPKA_ID")
	private kg.infosystems.buhproject.entity.catalogs.PapkiFajlov papka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli pol1zovatel1;

	@Lob
	@Column(name = "PUT1")
	private String put1;

}
