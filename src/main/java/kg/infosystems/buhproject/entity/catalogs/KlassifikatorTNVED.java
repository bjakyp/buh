package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "KlassifikatorTNVED", schema = "catalogs")
@Getter
@Setter
public class KlassifikatorTNVED {
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

	@Column(name = "KOD", length = 10)
    private String kod;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@Lob
	@Column(name = "NAIMENOVANIE_POLNOE")
    private String naimenovaniePolnoe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EDINICA_IZMERENIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KlassifikatorEdinicIzmerenia edinicaIzmerenia;

	@Column(name = "SYR1EVOJ")
    private Boolean syr1evoj;

	@Column(name = "DATA_NACALA_DEJSTVIA")
    private LocalDateTime dataNacalaDejstvia;

	@Column(name = "DATA_OKONCANIA_DEJSTVIA")
    private LocalDateTime dataOkoncaniaDejstvia;

}
