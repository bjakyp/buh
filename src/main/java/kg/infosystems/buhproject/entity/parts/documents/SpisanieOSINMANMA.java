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
@Table(name = "SpisanieOSINMANMA", schema = "parts_documents")
@Getter
@Setter
public class SpisanieOSINMANMA {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.SpisanieOSINMA part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "NEMATERIAL1NYJ_AKTIV_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Nematerial1nyeAktivy nematerial1nyjAktiv;

	@Column(name = "INVENTARNYJ_NOMER", length = 20)
	private String inventarnyjNomer;

	@Column(name = "STOIMOST1", precision = 15, scale = 2)
	private BigDecimal stoimost1;

	@Column(name = "NAKOPLENNAA_AMORTIZACIA", precision = 15, scale = 2)
	private BigDecimal nakoplennaaAmortizacia;

	@Column(name = "OSTATOCNAA_STOIMOST1", precision = 15, scale = 2)
	private BigDecimal ostatocnaaStoimost1;

}
