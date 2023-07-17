package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_ZanatyeLicenzii")
@Table(name = "ZanatyeLicenziiIr", schema = "informations")
@Getter
@Setter
public class ZanatyeLicenzii extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USLUGA_ID")
	private kg.infosystems.buhproject.entity.catalogs.UslugiServisa usluga;

	@Column(name = "IDENTIFIKATOR_LICENZII", length = 200)
	private String identifikatorLicenzii;

	@Column(name = "KONTEKST_LICENZII", length = 200)
	private String kontekstLicenzii;

	@Column(name = "KOLICESTVO_LICENZIJ", precision = 10, scale = 0)
	private BigDecimal kolicestvoLicenzij;

	@Column(name = "DATA_IZMENENIA")
	private LocalDateTime dataIzmenenia;

	@Column(name = "NOMER_PODPISKI", length = 9)
	private String nomerPodpiski;

	@Column(name = "DATA_OTKLUCENIA_PODPISKI")
	private LocalDateTime dataOtkluceniaPodpiski;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
	private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
