package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_VersiiPodsistem")
@Table(name = "VersiiPodsistemIr", schema = "informations")
@Getter
@Setter
public class VersiiPodsistem extends BaseEntity {
	@Column(name = "IMA_PODSISTEMY", length = 100)
	private String imaPodsistemy;

	@Column(name = "VERSIA", length = 15)
	private String versia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAN_OBNOVLENIA_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage planObnovlenia;

	@Column(name = "ETO_OSNOVNAA_KONFIGURACIA")
	private Boolean etoOsnovnaaKonfiguracia;

	@Column(name = "VYPOLNENA_REGISTRACIA_OTLOZENNYH_OBRABOTCIKOV")
	private Boolean vypolnenaRegistraciaOtlozennyhObrabotcikov;

}
