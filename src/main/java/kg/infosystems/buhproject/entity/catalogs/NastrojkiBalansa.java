package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.NastrojkiBalansaNastrojkaStrok;
import kg.infosystems.buhproject.entity.parts.catalogs.NastrojkiBalansaNastrojkaStrokBalansa;
import kg.infosystems.buhproject.entity.parts.catalogs.NastrojkiBalansaStrokiOtceta;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "NastrojkiBalansa", schema = "catalogs")
@Getter
@Setter
public class NastrojkiBalansa {
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
	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@Column(name = "NOMER_PRILOZENIA", precision = 3, scale = 1)
    private BigDecimal nomerPrilozenia;

	@Column(name = "BALANS")
    private Boolean balans;

	@Column(name = "DATA")
    private LocalDateTime data;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NastrojkiBalansaStrokiOtceta> strokiOtceta;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NastrojkiBalansaNastrojkaStrok> nastrojkaStrok;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NastrojkiBalansaNastrojkaStrokBalansa> nastrojkaStrokBalansa;
}
