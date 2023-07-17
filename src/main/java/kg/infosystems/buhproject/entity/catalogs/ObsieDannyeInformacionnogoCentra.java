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
@Table(name = "ObsieDannyeInformacionnogoCentra", schema = "catalogs")
@Getter
@Setter
public class ObsieDannyeInformacionnogoCentra {
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

	@Column(name = "KOD", length = 9)
    private String kod;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLOZENIA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage vlozenia;

	@Lob
	@Column(name = "VNESNAA_SSYLKA")
    private String vnesnaaSsylka;

	@Column(name = "DATA")
    private LocalDateTime data;

	@Column(name = "DATA_NACALA_AKTUAL1NOSTI")
    private LocalDateTime dataNacalaAktual1nosti;

	@Column(name = "DATA_OKONCANIA_AKTUAL1NOSTI")
    private LocalDateTime dataOkoncaniaAktual1nosti;

	@Column(name = "IDENTIFIKATOR")
    private UUID identifikator;

	@Column(name = "KRITICNOST1", precision = 10, scale = 0)
    private BigDecimal kriticnost1;

	@Lob
	@Column(name = "TEKST_HTML")
    private String tekstHTML;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_INFORMACII_ID")
    private kg.infosystems.buhproject.entity.catalogs.TipyInformaciiInformacionnogoCentra tipInformacii;

}
