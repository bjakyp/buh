package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_ScetaRascetovSKontragentami")
@Table(name = "ScetaRascetovSKontragentamiIr", schema = "informations")
@Getter
@Setter
public class ScetaRascetovSKontragentami extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONTRAGENT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_S_POSTAVSIKOM_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovSPostavsikom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_S_POKUPATELEM_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovSPokupatelem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_PO_USLUGAM_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovPoUslugam;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASCETOV_PO_OS_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetovPoOS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_AVANSOV_POSTAVSIKU_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetAvansovPostavsiku;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_AVANSOV_OT_POKUPATELA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetAvansovOtPokupatela;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_AVANSOV_PO_USLUGAM_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetAvansovPoUslugam;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_AVANSOV_PO_OS_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetAvansovPoOS;

}
