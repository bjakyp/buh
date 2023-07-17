package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.Pol1zovateliDopolnitel1nyeRekvizity;
import kg.infosystems.buhproject.entity.parts.catalogs.Pol1zovateliKontaktnaaInformacia;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "Pol1zovateli", schema = "catalogs")
@Getter
@Setter
public class Pol1zovateli {
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

	@Column(name = "NEDEJSTVITELEN")
    private Boolean nedejstvitelen;

	@Column(name = "PODRAZDELENIE", length = 10)
    private String podrazdelenie;

	@Column(name = "FIZICESKOE_LICO", length = 10)
    private String fiziceskoeLico;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@Column(name = "SLUZEBNYJ")
    private Boolean sluzebnyj;

	@Column(name = "PODGOTOVLEN")
    private Boolean podgotovlen;

	@Column(name = "IDENTIFIKATOR_POL1ZOVATELA_IB")
    private UUID identifikatorPol1zovatelaIB;

	@Column(name = "IDENTIFIKATOR_POL1ZOVATELA_SERVISA")
    private UUID identifikatorPol1zovatelaServisa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVA_POL1ZOVATELA_IB_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage svojstvaPol1zovatelaIB;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOTOGRAFIA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage fotografia;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Pol1zovateliDopolnitel1nyeRekvizity> dopolnitel1nyeRekvizity;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<Pol1zovateliKontaktnaaInformacia> kontaktnaaInformacia;
}
