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
@Table(name = "ZakrytieMesacaAmortizaciaNMA", schema = "parts_documents")
@Getter
@Setter
public class ZakrytieMesacaAmortizaciaNMA {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.ZakrytieMesaca part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEMATERIAL1NYJ_AKTIV_ID")
	private kg.infosystems.buhproject.entity.catalogs.Nematerial1nyeAktivy nematerial1nyjAktiv;

	@Column(name = "INVENTARNYJ_NOMER", length = 20)
	private String inventarnyjNomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_NACISLENIA_AMORTIZACII_ID")
	private kg.infosystems.buhproject.entity.enumerations.SposobyNacisleniaAmortizaciiOSINMA sposobNacisleniaAmortizacii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_OTRAZENIA_RASHODOV_PO_AMORTIZACII_ID")
	private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaRashodovPoAmortizacii sposobOtrazeniaRashodovPoAmortizacii;

	@Column(name = "STOIMOST1_DLA_RASCETA_AMORTIZACII", precision = 15, scale = 2)
	private BigDecimal stoimost1DlaRascetaAmortizacii;

	@Column(name = "SROK_SLUZBY", precision = 4, scale = 0)
	private BigDecimal srokSluzby;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_ZATRAT_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetZatrat;

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
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

}
