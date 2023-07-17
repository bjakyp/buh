package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_UcenyeZvaniaFiziceskihLic")
@Table(name = "UcenyeZvaniaFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class UcenyeZvaniaFiziceskihLic extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCENOE_ZVANIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.UcenyeZvania ucenoeZvanie;

	@Column(name = "DATA_PRISVOENIA_UCENOGO_ZVANIA")
	private LocalDateTime dataPrisvoeniaUcenogoZvania;

	@Column(name = "ATTESTAT_SERIA", length = 50)
	private String attestatSeria;

	@Column(name = "ATTESTAT_NOMER", length = 50)
	private String attestatNomer;

	@Lob
	@Column(name = "ATTESTAT_VYDAN_ORGANIZACIA")
	private String attestatVydanOrganizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NAUCNAA_SPECIAL1NOST1_ID")
	private kg.infosystems.buhproject.entity.catalogs.KlassifikatorSpecial1nostejPoObrazovaniu naucnaaSpecial1nost1;

}
