package kg.infosystems.buhproject.entity.registers.accumulations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "accumulations_VyplacennaaZarplata")
@Table(name = "VyplacennaaZarplataAr", schema = "accumulations")
@Getter
@Setter
public class VyplacennaaZarplata extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGISTRATOR_ID")
	private kg.infosystems.buhproject.entity.one.Multiple registrator;

	@Column(name = "PERIOD")
	private LocalDateTime period;

	@Column(name = "NOMER_STROKI", precision = 9, scale = 0)
	private BigDecimal nomerStroki;

	@Column(name = "AKTIVNOST1")
	private Boolean aktivnost1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_VYPLATY_ID")
	private kg.infosystems.buhproject.entity.enumerations.VidyVyplatyZarplaty vidVyplaty;

	@Column(name = "PERIOD_REGISTRACII")
	private LocalDateTime periodRegistracii;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

}
