package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_ZnaceniaParametrovTipovojOperacii")
@Table(name = "ZnaceniaParametrovTipovojOperaciiIr", schema = "informations")
@Getter
@Setter
public class ZnaceniaParametrovTipovojOperacii extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OPERACIA_ID")
	private kg.infosystems.buhproject.entity.documents.OperaciaBuh operacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARAMETR_ID")
	private kg.infosystems.buhproject.entity.catalogs.ParametryTipovojOperacii parametr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_ID")
	private kg.infosystems.buhproject.entity.one.Multiple znacenie;

}
