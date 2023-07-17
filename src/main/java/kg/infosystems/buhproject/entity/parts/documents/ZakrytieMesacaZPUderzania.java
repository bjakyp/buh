package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyUderzanij;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "ZakrytieMesacaZPUderzania", schema = "parts_documents")
@Getter
@Setter
public class ZakrytieMesacaZPUderzania {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.ZakrytieMesacaZP part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_RASCETA_ID", nullable = false)
	private VidyUderzanij vidRasceta;

	@NotNull
	@Column(name = "RAZMER", nullable = false, precision = 15, scale = 2)
	private BigDecimal razmer;

	@Column(name = "REZUL1TAT", precision = 15, scale = 2)
	private BigDecimal rezul1tat;

	@Column(name = "RAZMER_VYCETA", precision = 15, scale = 2)
	private BigDecimal razmerVyceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONTRAGENT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

}
