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
@Table(name = "VidyKontaktnojInformaciiPredstavlenia", schema = "parts_catalogs")
@Getter
@Setter
public class VidyKontaktnojInformaciiPredstavlenia {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyKontaktnojInformacii part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@Column(name = "KOD_AZYKA", length = 10)
	private String kodAzyka;

	@Column(name = "NAIMENOVANIE", length = 150)
	private String naimenovanie;

}
