package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.NaboryDopolnitel1nyhRekvizitovISvedenijDopolnitel1nyeRekvizity;
import kg.infosystems.buhproject.entity.parts.catalogs.NaboryDopolnitel1nyhRekvizitovISvedenijDopolnitel1nyeSvedenia;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "NaboryDopolnitel1nyhRekvizitovISvedenij", schema = "catalogs")
@Getter
@Setter
public class NaboryDopolnitel1nyhRekvizitovISvedenij {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryDopolnitel1nyhRekvizitovISvedenij roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@Column(name = "KOLICESTVO_REKVIZITOV", length = 5)
    private String kolicestvoRekvizitov;

	@Column(name = "KOLICESTVO_SVEDENIJ", length = 5)
    private String kolicestvoSvedenij;

	@Column(name = "ISPOL1ZUETSA")
    private Boolean ispol1zuetsa;

	@Column(name = "IMA_PREDOPREDELENNOGO_NABORA", length = 150)
    private String imaPredopredelennogoNabora;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NaboryDopolnitel1nyhRekvizitovISvedenijDopolnitel1nyeRekvizity> dopolnitel1nyeRekvizity;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NaboryDopolnitel1nyhRekvizitovISvedenijDopolnitel1nyeSvedenia> dopolnitel1nyeSvedenia;
}
