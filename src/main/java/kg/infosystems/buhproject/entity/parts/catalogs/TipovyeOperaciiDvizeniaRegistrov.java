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
@Table(name = "TipovyeOperaciiDvizeniaRegistrov", schema = "parts_catalogs")
@Getter
@Setter
public class TipovyeOperaciiDvizeniaRegistrov {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.catalogs.TipovyeOperacii part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@Column(name = "IMA_REGISTRA", length = 100)
	private String imaRegistra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_REGISTRA_ID")
	private kg.infosystems.buhproject.entity.enumerations.TipyRegistrov tipRegistra;

	@Column(name = "NOMER_DVIZENIA", precision = 3, scale = 0)
	private BigDecimal nomerDvizenia;

	@Column(name = "ANALITIKA", length = 100)
	private String analitika;

	@Column(name = "SINONIM", length = 100)
	private String sinonim;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_ID")
	private kg.infosystems.buhproject.entity.one.Multiple znacenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_POLA_REGISTRA_ID")
	private kg.infosystems.buhproject.entity.enumerations.TipyPolejRegistra tipPolaRegistra;

	@Column(name = "NE_IZMENAT1_ZNACENIE")
	private Boolean neIzmenat1Znacenie;

	@Column(name = "VID_DVIZENIA_REGISTRA_NAKOPLENIA")
	private Boolean vidDvizeniaRegistraNakoplenia;

}
