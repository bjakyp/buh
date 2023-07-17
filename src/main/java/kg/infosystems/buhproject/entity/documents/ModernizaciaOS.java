package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.ModernizaciaOSParametryOb2ekta;
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
@Table(name = "ModernizaciaOS", schema = "documents")
@Getter
@Setter
public class ModernizaciaOS {
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
	@JoinColumn(name = "SOBYTIE_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OSNOVNOE_SREDSTVO_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.OsnovnyeSredstva osnovnoeSredstvo;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_UCETA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@NotNull
	@Column(name = "STOIMOST1_MODERNIZACII", nullable = false, precision = 15, scale = 2)
	private BigDecimal stoimost1Modernizacii;

	@Column(name = "PERVONACAL1NAA_STOIMOST1_DO_MODERNIZACII", precision = 15, scale = 2)
	private BigDecimal pervonacal1naaStoimost1DoModernizacii;

	@Column(name = "PERVONACAL1NAA_STOIMOST1_POSLE_MODERNIZACII", precision = 15, scale = 2)
	private BigDecimal pervonacal1naaStoimost1PosleModernizacii;

	@Column(name = "NAKOPLENNAA_AMORTIZACIA", precision = 15, scale = 2)
	private BigDecimal nakoplennaaAmortizacia;

	@Column(name = "STOIMOST1_DLA_RASCETA_AMORTIZACII_DO_MODERNIZACII", precision = 15, scale = 2)
	private BigDecimal stoimost1DlaRascetaAmortizaciiDoModernizacii;

	@Column(name = "STOIMOST1_DLA_RASCETA_AMORTIZACII_POSLE_MODERNIZACII", precision = 15, scale = 2)
	private BigDecimal stoimost1DlaRascetaAmortizaciiPosleModernizacii;

	@Column(name = "OSTATOCNAA_STOIMOST1_DO_MODERNIZACII", precision = 15, scale = 2)
	private BigDecimal ostatocnaaStoimost1DoModernizacii;

	@Column(name = "OSTATOCNAA_STOIMOST1_POSLE_MODERNIZACII", precision = 15, scale = 2)
	private BigDecimal ostatocnaaStoimost1PosleModernizacii;

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
	private List<ModernizaciaOSParametryOb2ekta> parametryOb2ekta;
}
