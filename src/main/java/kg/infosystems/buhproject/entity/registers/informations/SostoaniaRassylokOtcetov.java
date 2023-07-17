package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SostoaniaRassylokOtcetov")
@Table(name = "SostoaniaRassylokOtcetovIr", schema = "informations")
@Getter
@Setter
public class SostoaniaRassylokOtcetov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RASSYLKA_ID")
	private kg.infosystems.buhproject.entity.catalogs.RassylkiOtcetov rassylka;

	@Column(name = "POSLEDNIJ_ZAPUSK_NACALO")
	private LocalDateTime poslednijZapuskNacalo;

	@Column(name = "POSLEDNIJ_ZAPUSK_ZAVERSENIE")
	private LocalDateTime poslednijZapuskZaversenie;

	@Column(name = "USPESNYJ_ZAPUSK")
	private LocalDateTime uspesnyjZapusk;

	@Column(name = "VYPOLNENA")
	private Boolean vypolnena;

	@Column(name = "S_OSIBKAMI")
	private Boolean sOsibkami;

	@Column(name = "NOMER_SEANSA", precision = 25, scale = 0)
	private BigDecimal nomerSeansa;

}
