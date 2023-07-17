package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.catalogs.VnesniePol1zovateliDopolnitel1nyeRekvizity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VnesniePol1zovateli", schema = "catalogs")
@Getter
@Setter
public class VnesniePol1zovateli {
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

	@Column(name = "NAIMENOVANIE", length = 100)
	private String naimenovanie;

	@Column(name = "NEDEJSTVITELEN")
	private Boolean nedejstvitelen;

	@Column(name = "OB2EKT_AVTORIZACII", length = 10)
	private String ob2ektAvtorizacii;

	@Column(name = "USTANOVIT1_ROLI_NEPOSREDSTVENNO")
	private Boolean ustanovit1RoliNeposredstvenno;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@Column(name = "PODGOTOVLEN")
	private Boolean podgotovlen;

	@Column(name = "IDENTIFIKATOR_POL1ZOVATELA_IB")
	private UUID identifikatorPol1zovatelaIB;

	@Column(name = "IDENTIFIKATOR_POL1ZOVATELA_SERVISA")
	private UUID identifikatorPol1zovatelaServisa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVA_POL1ZOVATELA_IB_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage svojstvaPol1zovatelaIB;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<VnesniePol1zovateliDopolnitel1nyeRekvizity> dopolnitel1nyeRekvizity;
}
