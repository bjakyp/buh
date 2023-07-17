package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.catalogs.VidyProverokSvojstvaOb2ekta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VidyProverok", schema = "catalogs")
@Getter
@Setter
public class VidyProverok {
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
	@Column(name = "NAIMENOVANIE", length = 128)
	private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyProverok roditel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVO1_ID")
	private kg.infosystems.buhproject.entity.one.Multiple svojstvo1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVO2_ID")
	private kg.infosystems.buhproject.entity.one.Multiple svojstvo2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVO3_ID")
	private kg.infosystems.buhproject.entity.one.Multiple svojstvo3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVO4_ID")
	private kg.infosystems.buhproject.entity.one.Multiple svojstvo4;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVO5_ID")
	private kg.infosystems.buhproject.entity.one.Multiple svojstvo5;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<VidyProverokSvojstvaOb2ekta> svojstvaOb2ekta;
}
