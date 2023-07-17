package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "SoobseniaOblastejDannyh", schema = "catalogs")
@Getter
@Setter
public class SoobseniaOblastejDannyh {
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

	@Column(name = "KOD", precision = 30, scale = 0)
	private BigDecimal kod;

	@Column(name = "NAIMENOVANIE", length = 150)
	private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TELO_SOOBSENIA_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage teloSoobsenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTPRAVITEL1_ID")
	private kg.infosystems.buhproject.entity.publications.ObmenSoobseniami otpravitel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLUCATEL1_ID")
	private kg.infosystems.buhproject.entity.publications.ObmenSoobseniami polucatel1;

	@Column(name = "ZABLOKIROVANO")
	private Boolean zablokirovano;

	@Column(name = "KOLICESTVO_POPYTOK_OBRABOTKI_SOOBSENIA", precision = 2, scale = 0)
	private BigDecimal kolicestvoPopytokObrabotkiSoobsenia;

	@Lob
	@Column(name = "PODROBNOE_PREDSTAVLENIE_OSIBKI")
	private String podrobnoePredstavlenieOsibki;

	@Column(name = "ETO_BYSTROE_SOOBSENIE")
	private Boolean etoBystroeSoobsenie;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
	private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
