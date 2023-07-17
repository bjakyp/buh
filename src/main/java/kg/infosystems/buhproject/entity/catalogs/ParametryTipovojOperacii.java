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
@Table(name = "ParametryTipovojOperacii", schema = "catalogs")
@Getter
@Setter
public class ParametryTipovojOperacii {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_ID")
    private kg.infosystems.buhproject.entity.catalogs.TipovyeOperacii vladelec;

	@Column(name = "KOD", length = 9)
    private String kod;

	@Column(name = "NAIMENOVANIE", length = 40)
    private String naimenovanie;

	@Column(name = "PORADOK_PARAMETRA", precision = 3, scale = 0)
    private BigDecimal poradokParametra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OPISANIE_TIPA_REKVIZITA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage opisanieTipaRekvizita;

	@Column(name = "PODSKAZKA", length = 200)
    private String podskazka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVAZ1_PO_VLADEL1CU_ID")
    private kg.infosystems.buhproject.entity.catalogs.ParametryTipovojOperacii svaz1PoVladel1cu;

}
