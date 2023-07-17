package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_ZnaceniaGruppDostupaPoUmolcaniu")
@Table(name = "ZnaceniaGruppDostupaPoUmolcaniuIr", schema = "informations")
@Getter
@Setter
public class ZnaceniaGruppDostupaPoUmolcaniu extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRUPPA_DOSTUPA_ID")
	private kg.infosystems.buhproject.entity.catalogs.GruppyDostupa gruppaDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_ZNACENIJ_DOSTUPA_ID")
	private kg.infosystems.buhproject.entity.one.Multiple tipZnacenijDostupa;

	@Column(name = "VSE_RAZRESENY")
	private Boolean vseRazreseny;

	@Column(name = "VSE_RAZRESENY_BEZ_ISKLUCENIJ")
	private Boolean vseRazresenyBezIsklucenij;

	@Column(name = "BEZ_NASTROJKI")
	private Boolean bezNastrojki;

}
