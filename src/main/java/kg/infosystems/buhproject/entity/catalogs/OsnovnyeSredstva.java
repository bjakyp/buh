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
@Table(name = "OsnovnyeSredstva", schema = "catalogs")
@Getter
@Setter
public class OsnovnyeSredstva {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.OsnovnyeSredstva roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@Column(name = "NAIMENOVANIE_POLNOE", length = 200)
    private String naimenovaniePolnoe;

	@Column(name = "ZAVODSKOJ_NOMER", length = 20)
    private String zavodskojNomer;

	@Column(name = "NOMER_PASPORTA", length = 20)
    private String nomerPasporta;

	@Column(name = "IZGOTOVITEL1", length = 200)
    private String izgotovitel1;

	@Column(name = "DATA_VYPUSKA")
    private LocalDateTime dataVypuska;

}
