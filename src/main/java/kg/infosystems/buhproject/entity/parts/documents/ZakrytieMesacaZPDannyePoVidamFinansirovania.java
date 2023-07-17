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
@Table(name = "ZakrytieMesacaZPDannyePoVidamFinansirovania", schema = "parts_documents")
@Getter
@Setter
public class ZakrytieMesacaZPDannyePoVidamFinansirovania {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID")
	private kg.infosystems.buhproject.entity.catalogs.Statusy status;

	@Column(name = "SUMMA_NACISLENO", precision = 15, scale = 2)
	private BigDecimal summaNacisleno;

	@Column(name = "ODPN", precision = 15, scale = 2)
	private BigDecimal oDPN;

	@Column(name = "ODSF", precision = 15, scale = 2)
	private BigDecimal oDSF;

	@Column(name = "VYCETY", precision = 15, scale = 2)
	private BigDecimal vycety;

	@Column(name = "PN", precision = 15, scale = 2)
	private BigDecimal pN;

	@Column(name = "PFR", precision = 15, scale = 2)
	private BigDecimal pFR;

	@Column(name = "GNPFR", precision = 15, scale = 2)
	private BigDecimal gNPFR;

	@Column(name = "PFR_DLA_RASCETA_PN", precision = 15, scale = 2)
	private BigDecimal pFRDlaRascetaPN;

	@Column(name = "GNPFR_DLA_RASCETA_PN", precision = 15, scale = 2)
	private BigDecimal gNPFRDlaRascetaPN;

	@Column(name = "PFF", precision = 15, scale = 2)
	private BigDecimal pFF;

	@Column(name = "MSF", precision = 15, scale = 2)
	private BigDecimal mSF;

	@Column(name = "FOTF", precision = 15, scale = 2)
	private BigDecimal fOTF;

	@Column(name = "MSR", precision = 15, scale = 2)
	private BigDecimal mSR;

	@Column(name = "OTRABOTANO_DNEJ", precision = 10, scale = 0)
	private BigDecimal otrabotanoDnej;

	@Column(name = "STROKA_PO_PN")
	private Boolean strokaPoPN;

}
