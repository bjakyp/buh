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
@Table(name = "AvansovyjOtcetProcee", schema = "parts_documents")
@Getter
@Setter
public class AvansovyjOtcetProcee {
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
	@JoinColumn(name = "KONTRAGENT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOMENKLATURA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Nomenklatura nomenklatura;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@Column(name = "VHODASIJ_DOKUMENT", length = 50)
	private String vhodasijDokument;

	@Column(name = "NOMER_VHODASEGO_DOKUMENTA", length = 20)
	private String nomerVhodasegoDokumenta;

	@Column(name = "DATA_VHODASEGO_DOKUMENTA")
	private LocalDateTime dataVhodasegoDokumenta;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_UCETA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO1_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkonto1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO2_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkonto2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO3_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkonto3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_ZADOLZENNOSTI_ID")
	private kg.infosystems.buhproject.entity.enumerations.VidyZadolzennosti vidZadolzennosti;

	@Column(name = "SODERZANIE", length = 200)
	private String soderzanie;

}
