package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_IdentifikatoryOb2ektovVersijRassirenij")
@Table(name = "IdentifikatoryOb2ektovVersijRassirenijIr", schema = "informations")
@Getter
@Setter
public class IdentifikatoryOb2ektovVersijRassirenij extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VERSIA_RASSIRENIJ_ID")
	private kg.infosystems.buhproject.entity.catalogs.VersiiRassirenij versiaRassirenij;

	@Column(name = "POLNOE_IMA_OB2EKTA", length = 430)
	private String polnoeImaOb2ekta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDENTIFIKATOR_ID")
	private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovRassirenij identifikator;

}
