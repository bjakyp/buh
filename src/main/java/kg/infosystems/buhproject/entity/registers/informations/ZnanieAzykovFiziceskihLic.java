package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity(name = "informations_ZnanieAzykovFiziceskihLic")
@Table(name = "ZnanieAzykovFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class ZnanieAzykovFiziceskihLic extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AZYK_ID")
	private kg.infosystems.buhproject.entity.catalogs.AzykiNarodovMira azyk;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STEPEN1_ZNANIA_AZYKA_ID")
	private kg.infosystems.buhproject.entity.catalogs.StepeniZnaniaAzyka stepen1ZnaniaAzyka;

}
