package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "AvansovyjOtcetBibliotecnyeFondy", schema = "parts_documents")
@Getter
@Setter
public class AvansovyjOtcetBibliotecnyeFondy {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.AvansovyjOtcet part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IZDANIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.BibliotecnyeFondy izdanie;

	@NotNull
	@Column(name = "KOLICESTVO", nullable = false, precision = 15, scale = 3)
	private BigDecimal kolicestvo;

	@Column(name = "CENA", precision = 15, scale = 2)
	private BigDecimal cena;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_UCETA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_ZADOLZENNOSTI_ID")
	private kg.infosystems.buhproject.entity.enumerations.VidyZadolzennosti vidZadolzennosti;

	@Column(name = "VHODASIJ_DOKUMENT", length = 50)
	private String vhodasijDokument;

	@Column(name = "NOMER_VHODASEGO_DOKUMENTA", length = 20)
	private String nomerVhodasegoDokumenta;

	@Column(name = "DATA_VHODASEGO_DOKUMENTA")
	private LocalDateTime dataVhodasegoDokumenta;

}
