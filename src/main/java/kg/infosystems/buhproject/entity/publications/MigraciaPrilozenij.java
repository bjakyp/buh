package kg.infosystems.buhproject.entity.publications;

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
@Table(name = "MigraciaPrilozenij", schema = "publications")
@Getter
@Setter
public class MigraciaPrilozenij {
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

	@Column(name = "KOD", length = 36)
    private String kod;

	@Column(name = "NAIMENOVANIE", length = 250)
    private String naimenovanie;

	@Column(name = "NOMER_OTPRAVLENNOGO", precision = 10, scale = 0)
    private BigDecimal nomerOtpravlennogo;

	@Column(name = "NOMER_PRINATOGO", precision = 10, scale = 0)
    private BigDecimal nomerPrinatogo;

	@Column(name = "SVODNOE_PRILOZENIE_VYGRUZKA")
    private Boolean svodnoePrilozenieVygruzka;

	@Column(name = "SVODNOE_PRILOZENIE_ZAGRUZKA")
    private Boolean svodnoePrilozenieZagruzka;

}
