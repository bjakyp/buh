package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.OtcetyPoSocial1nomuFonduFondOplatyTrudaPoKategoriam;
import kg.infosystems.buhproject.entity.parts.documents.OtcetyPoSocial1nomuFonduSvedeniaOZanatostiIZarabotnojPlate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "OtcetyPoSocial1nomuFondu", schema = "documents")
@Getter
@Setter
public class OtcetyPoSocial1nomuFondu {
	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;

	@Column(name = "VERSIA_DANNYH")
	@Version
	private Integer versiaDannyh;

	@DeletedBy
	@Column(name = "DELETED_BY")
	private String deletedBy;

	@DeletedDate
	@Column(name = "DELETED_DATE")
	private LocalDateTime deletedDate;

	@NotNull
	@Column(name = "DATA", nullable = false)
	private LocalDateTime data;

	@Column(name = "NOMER", length = 9)
	private String nomer;

	@Column(name = "PROVEDEN")
	private Boolean proveden;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ORGANIZACIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "KONTRAGENT_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@Column(name = "DATA_SDACI_OTCETA")
	private LocalDateTime dataSdaciOtceta;

	@Column(name = "OKRUGLENIE")
	private Boolean okruglenie;

	@Column(name = "OBAZATEL1STVA_PO_STRAHOVYM_VZNOSAM", precision = 15, scale = 2)
	private BigDecimal obazatel1stvaPoStrahovymVznosam;

	@Column(name = "OBAZATEL1STVA_PO_PENSIONNOMU_FONDU", precision = 15, scale = 2)
	private BigDecimal obazatel1stvaPoPensionnomuFondu;

	@Column(name = "PEREPLATA_PO_STRAHOVYM_VZNOSAM", precision = 15, scale = 2)
	private BigDecimal pereplataPoStrahovymVznosam;

	@Column(name = "PEREPLATA_PO_PENSIONNOMU_FONDU", precision = 15, scale = 2)
	private BigDecimal pereplataPoPensionnomuFondu;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<OtcetyPoSocial1nomuFonduSvedeniaOZanatostiIZarabotnojPlate> svedenia;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<OtcetyPoSocial1nomuFonduFondOplatyTrudaPoKategoriam> fond;

	@InstanceName
	@DependsOnProperties({"data", "nomer"})
	public String getInstanceName() {
		return String.format("%s %s", data, nomer);
	}

}
