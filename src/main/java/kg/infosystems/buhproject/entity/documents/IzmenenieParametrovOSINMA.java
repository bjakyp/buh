package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.IzmenenieParametrovOSINMAParametryOb2ekta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "IzmenenieParametrovOSINMA", schema = "documents")
@Getter
@Setter
public class IzmenenieParametrovOSINMA {
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

	@NotNull
	@Column(name = "DATA", nullable = false)
	private LocalDateTime data;

	@Column(name = "NOMER", length = 9)
	private String nomer;

	@Column(name = "PROVEDEN")
	private Boolean proveden;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ORGANIZACIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SOBYTIE_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytie;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OB2EKT_IZMENENIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.one.Multiple ob2ektIzmenenia;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<IzmenenieParametrovOSINMAParametryOb2ekta> parametryOb2ekta;
}