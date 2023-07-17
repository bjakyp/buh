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
@Table(name = "InventarizaciaOSOS", schema = "parts_documents")
@Getter
@Setter
public class InventarizaciaOSOS {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.InventarizaciaOS part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OSNOVNOE_SREDSTVO_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.OsnovnyeSredstva osnovnoeSredstvo;

	@Column(name = "INVENTARNYJ_NOMER", length = 20)
	private String inventarnyjNomer;

	@Column(name = "STOIMOST1_PO_DANNYM_UCETA", precision = 15, scale = 2)
	private BigDecimal stoimost1PoDannymUceta;

	@Column(name = "FAKTICESKAA_STOIMOST1", precision = 15, scale = 2)
	private BigDecimal fakticeskaaStoimost1;

	@Column(name = "FAKTICESKOE_NALICIE")
	private Boolean fakticeskoeNalicie;

	@Column(name = "SUMMA_NEDOSTACI", precision = 15, scale = 2)
	private BigDecimal summaNedostaci;

	@Column(name = "SUMMA_IZLISKA", precision = 15, scale = 2)
	private BigDecimal summaIzliska;

}
