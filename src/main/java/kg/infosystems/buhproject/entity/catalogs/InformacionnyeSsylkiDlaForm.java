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
@Table(name = "InformacionnyeSsylkiDlaForm", schema = "catalogs")
@Getter
@Setter
public class InformacionnyeSsylkiDlaForm {
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

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@Lob
	@Column(name = "ADRES")
    private String adres;

	@Column(name = "VES", precision = 10, scale = 0)
    private BigDecimal ves;

	@Column(name = "DATA_NACALA_AKTUAL1NOSTI")
    private LocalDateTime dataNacalaAktual1nosti;

	@Column(name = "DATA_OBNOVLENIA")
    private LocalDateTime dataObnovlenia;

	@Column(name = "IZ_KONFIGURACII")
    private Boolean izKonfiguracii;

	@Column(name = "DATA_OKONCANIA_AKTUAL1NOSTI")
    private LocalDateTime dataOkoncaniaAktual1nosti;

	@Column(name = "IDENTIFIKATOR", length = 100)
    private String identifikator;

	@Column(name = "PODSKAZKA", length = 200)
    private String podskazka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLNYJ_PUT1_K_FORME_ID")
    private kg.infosystems.buhproject.entity.catalogs.PolnyePutiKFormam polnyjPut1KForme;

}
