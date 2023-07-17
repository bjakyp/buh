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
@Table(name = "GrafikiAmortizacii", schema = "catalogs")
@Getter
@Setter
public class GrafikiAmortizacii {
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
	@Column(name = "NAIMENOVANIE", length = 25)
    private String naimenovanie;

	@Column(name = "PROCIE_SVEDENIA", length = 200)
    private String procieSvedenia;

	@Column(name = "ANVAR1", precision = 10, scale = 2)
    private BigDecimal anvar1;

	@Column(name = "FEVRAL1", precision = 10, scale = 2)
    private BigDecimal fevral1;

	@Column(name = "MART", precision = 10, scale = 2)
    private BigDecimal mart;

	@Column(name = "APREL1", precision = 10, scale = 2)
    private BigDecimal aprel1;

	@Column(name = "MAJ", precision = 10, scale = 2)
    private BigDecimal maj;

	@Column(name = "IUN1", precision = 10, scale = 2)
    private BigDecimal iun1;

	@Column(name = "IUL1", precision = 10, scale = 2)
    private BigDecimal iul1;

	@Column(name = "AVGUST", precision = 10, scale = 2)
    private BigDecimal avgust;

	@Column(name = "SENTABR1", precision = 10, scale = 2)
    private BigDecimal sentabr1;

	@Column(name = "OKTABR1", precision = 10, scale = 2)
    private BigDecimal oktabr1;

	@Column(name = "NOABR1", precision = 10, scale = 2)
    private BigDecimal noabr1;

	@Column(name = "DEKABR1", precision = 10, scale = 2)
    private BigDecimal dekabr1;

}
