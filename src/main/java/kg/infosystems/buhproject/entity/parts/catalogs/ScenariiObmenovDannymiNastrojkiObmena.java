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
@Table(name = "ScenariiObmenovDannymiNastrojkiObmena", schema = "parts_catalogs")
@Getter
@Setter
public class ScenariiObmenovDannymiNastrojkiObmena {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.catalogs.ScenariiObmenovDannymi part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
	private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_TRANSPORTA_OBMENA_ID")
	private kg.infosystems.buhproject.entity.enumerations.VidyTransportaSoobsenijObmena vidTransportaObmena;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VYPOLNAEMOE_DEJSTVIE_ID")
	private kg.infosystems.buhproject.entity.enumerations.DejstviaPriObmene vypolnaemoeDejstvie;

}
