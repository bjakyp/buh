package kg.infosystems.buhproject.entity.parts.catalogs;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VariantyOtcetovRazmesenie", schema = "parts_catalogs")
@Getter
@Setter
public class VariantyOtcetovRazmesenie {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.catalogs.VariantyOtcetov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@Column(name = "ISPOL1ZOVANIE")
	private Boolean ispol1zovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODSISTEMA_ID")
	private kg.infosystems.buhproject.entity.one.Multiple podsistema;

	@Column(name = "VAZNYJ")
	private Boolean vaznyj;

	@Column(name = "SM_TAKZE")
	private Boolean smTakze;

}
