package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "InventarizaciaTovarovTovary", schema = "parts_documents")
@Getter
@Setter
public class InventarizaciaTovarovTovary {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.InventarizaciaTovarov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOMENKLATURA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Nomenklatura nomenklatura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
	private BigDecimal kolicestvo;

	@Column(name = "UCETNOE_KOLICESTVO", precision = 15, scale = 3)
	private BigDecimal ucetnoeKolicestvo;

	@Column(name = "OTKLONENIE", precision = 15, scale = 3)
	private BigDecimal otklonenie;

	@Column(name = "UCETNAA_SUMMA", precision = 15, scale = 2)
	private BigDecimal ucetnaaSumma;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@Column(name = "CENA", precision = 15, scale = 2)
	private BigDecimal cena;

}
