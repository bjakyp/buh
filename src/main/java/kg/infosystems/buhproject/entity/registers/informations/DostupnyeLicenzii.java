package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_DostupnyeLicenzii")
@Table(name = "DostupnyeLicenziiIr", schema = "informations")
@Getter
@Setter
public class DostupnyeLicenzii extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_PODPISKI")
    private UUID identifikatorPodpiski;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USLUGA_ID")
    private kg.infosystems.buhproject.entity.catalogs.UslugiServisa usluga;

	@Column(name = "DATA_NACALA_DEJSTVIA")
    private LocalDateTime dataNacalaDejstvia;

	@Column(name = "DATA_OKONCANIA_DEJSTVIA")
    private LocalDateTime dataOkoncaniaDejstvia;

	@Column(name = "KOLICESTVO_LICENZIJ", precision = 10, scale = 0)
    private BigDecimal kolicestvoLicenzij;

	@Column(name = "NOMER_PODPISKI", length = 9)
    private String nomerPodpiski;

	@Column(name = "DATA_IZMENENIA")
    private LocalDateTime dataIzmenenia;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
