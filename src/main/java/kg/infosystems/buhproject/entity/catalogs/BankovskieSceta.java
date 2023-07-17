package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "BankovskieSceta", schema = "catalogs")
@Getter
@Setter
public class BankovskieSceta {
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
	private kg.infosystems.buhproject.entity.one.Multiple vladelec;

	@Column(name = "KOD", length = 9)
	private String kod;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 100)
	private String naimenovanie;

	@Column(name = "PREFIKS", length = 2)
	private String prefiks;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@Column(name = "NOMER_SCETA", length = 30)
	private String nomerSceta;

	@Column(name = "SCET_VROK", length = 50)
	private String scetVROK;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANK_ID")
	private kg.infosystems.buhproject.entity.catalogs.Banki bank;

    @JoinColumn(name = "SOTRUDNIKI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sotrudniki sotrudniki;

}
