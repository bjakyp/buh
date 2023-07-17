package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

@JmixEntity
@Entity
@Table(name = "MetodyRascetaOtpuska", schema = "catalogs")
@Getter
@Setter
public class MetodyRascetaOtpuska {
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

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 50)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEPOLNYE_MESACY_ID")
    private kg.infosystems.buhproject.entity.enumerations.NepolnyeMesacy nepolnyeMesacy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_RASCETA_ID")
    private VidyNacislenij vidRasceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_OTPUSKA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyOtpuskov vidOtpuska;

	@Column(name = "KOEFFICIENT_RASCETA", precision = 5, scale = 2)
    private BigDecimal koefficientRasceta;

	@Column(name = "RASCET_PO_RABOCIM_DNAM")
    private Boolean rascetPoRabocimDnam;

}
