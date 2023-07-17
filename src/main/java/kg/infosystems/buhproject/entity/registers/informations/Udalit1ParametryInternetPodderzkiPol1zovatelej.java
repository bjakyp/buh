package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

@JmixEntity
@Entity(name = "informations_Udalit1ParametryInternetPodderzkiPol1zovatelej")
@Table(name = "Udalit1ParametryInternetPodderzkiPol1zovatelejIr", schema = "informations")
@Getter
@Setter
public class Udalit1ParametryInternetPodderzkiPol1zovatelej extends BaseEntity {
	@Column(name = "IMA", length = 100)
	private String ima;

	@Column(name = "POL1ZOVATEL1")
	private UUID pol1zovatel1;

	@Lob
	@Column(name = "ZNACENIE")
	private String znacenie;

	@Column(name = "OBLAST1_VIDIMOSTI", length = 70)
	private String oblast1Vidimosti;

}
