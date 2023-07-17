package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_ScetaUcetaNomenklatury")
@Table(name = "ScetaUcetaNomenklaturyIr", schema = "informations")
@Getter
@Setter
public class ScetaUcetaNomenklatury extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOMENKLATURA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Nomenklatura nomenklatura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_DOHODOV_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDohodov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_RASHODOV_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRashodov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_RASHODOV_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1aRashodov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_DOHODOV_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1aDohodov;

}
