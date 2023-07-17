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
@Table(name = "Statusy", schema = "catalogs")
@Getter
@Setter
public class Statusy {
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
	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KATEGORIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KategoriiSotrudnikov kategoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_ZANATOSTI_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyZanatosti vidZanatosti;

	@Column(name = "NOMER_STROKI_V_OTCETE_PN", precision = 1, scale = 0)
    private BigDecimal nomerStrokiVOtcetePN;

}
