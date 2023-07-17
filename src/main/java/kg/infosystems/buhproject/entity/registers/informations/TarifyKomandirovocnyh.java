package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_TarifyKomandirovocnyh")
@Table(name = "TarifyKomandirovocnyhIr", schema = "informations")
@Getter
@Setter
public class TarifyKomandirovocnyh extends BaseEntity {
	@Column(name = "PERIOD")
	private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STRANA_ID")
	private kg.infosystems.buhproject.entity.catalogs.StranyMira strana;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GOROD_ID")
	private kg.infosystems.buhproject.entity.catalogs.Goroda gorod;

	@Column(name = "SUMMA_SUTOCNYE", precision = 15, scale = 2)
	private BigDecimal summaSutocnye;

	@Column(name = "SUMMA_PROZIVANIE", precision = 15, scale = 2)
	private BigDecimal summaProzivanie;

	@Column(name = "SUMMA_PROEZDNYE", precision = 15, scale = 2)
	private BigDecimal summaProezdnye;

}
