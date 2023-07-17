package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_ZavisimostiPravDostupa")
@Table(name = "ZavisimostiPravDostupaIr", schema = "informations")
@Getter
@Setter
public class ZavisimostiPravDostupa extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODCINENNAA_TABLICA_ID")
	private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh podcinennaaTablica;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_VEDUSEJ_TABLICY_ID")
	private kg.infosystems.buhproject.entity.one.Multiple tipVedusejTablicy;

}
