package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_UcetnaaPolitikaOrganizacij")
@Table(name = "UcetnaaPolitikaOrganizacijIr", schema = "informations")
@Getter
@Setter
public class UcetnaaPolitikaOrganizacij extends BaseEntity {
	@Column(name = "PERIOD")
	private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@Column(name = "NACISLENIE_AMORTIZACII_OSINMA_PO_MESACAM")
	private Boolean nacislenieAmortizaciiOSINMAPoMesacam;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_OCENKI_TMZ_ID")
	private kg.infosystems.buhproject.entity.enumerations.SposobyOcenki sposobOcenkiTMZ;

}
