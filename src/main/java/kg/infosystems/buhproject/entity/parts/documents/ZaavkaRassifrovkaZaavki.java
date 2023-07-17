package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "ZaavkaRassifrovkaZaavki", schema = "parts_documents")
@Getter
@Setter
public class ZaavkaRassifrovkaZaavki {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.Zaavka part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLATEZNYJ_DOKUMENT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple plateznyjDokument;

	@Column(name = "NAIMENOVANIE_PLATEZNOGO_DOKUMENTA", length = 50)
	private String naimenovaniePlateznogoDokumenta;

	@Column(name = "SUMMA_PLATEZNOGO_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaPlateznogoDokumenta;

	@Lob
	@Column(name = "VID_RASHODA")
	private String vidRashoda;

	@Column(name = "SUMMA_RAZRESENNAA_KAZNACEJSTVOM", precision = 15, scale = 2)
	private BigDecimal summaRazresennaaKaznacejstvom;

	@Lob
	@Column(name = "PRIMECANIE")
	private String primecanie;

}
