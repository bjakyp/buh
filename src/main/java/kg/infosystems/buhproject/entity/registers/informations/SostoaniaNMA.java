package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SostoaniaNMA")
@Table(name = "SostoaniaNMAIr", schema = "informations")
@Getter
@Setter
public class SostoaniaNMA extends BaseEntity {
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
	@JoinColumn(name = "NEMATERIAL1NYJ_AKTIV_ID")
	private kg.infosystems.buhproject.entity.catalogs.Nematerial1nyeAktivy nematerial1nyjAktiv;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTOANIE_ID")
	private kg.infosystems.buhproject.entity.enumerations.VidySostoanijOSINMA sostoanie;

}
