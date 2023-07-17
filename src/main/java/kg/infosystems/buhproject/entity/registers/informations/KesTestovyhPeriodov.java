package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_KesTestovyhPeriodov")
@Table(name = "KesTestovyhPeriodovIr", schema = "informations")
@Getter
@Setter
public class KesTestovyhPeriodov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDENTIFIKATOR_SERVISA_SOPROVOZDENIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryServisovSoprovozdenia identifikatorServisaSoprovozdenia;

	@Column(name = "IDENTIFIKATOR")
	private String identifikator;

	@Column(name = "NAIMENOVANIE")
	private String naimenovanie;

	@Lob
	@Column(name = "OPISANIE")
	private String opisanie;

	@Column(name = "DATA_OBNOVLENIA")
	private LocalDateTime dataObnovlenia;

}
