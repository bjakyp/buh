package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.documents.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "PrilozeniaKPoasnitel1nojZapiske", schema = "documents")
@Getter
@Setter
public class PrilozeniaKPoasnitel1nojZapiske {
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

	@Column(name = "DATA")
    private LocalDateTime data;

	@Column(name = "NOMER", length = 9)
    private String nomer;

	@Column(name = "PROVEDEN")
    private Boolean proveden;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_BUDZETA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyBudzeta vidBudzeta;

	@Column(name = "NACALO_PERIODA")
    private LocalDateTime nacaloPerioda;

	@Column(name = "KONEC_PERIODA")
    private LocalDateTime konecPerioda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EDINICA_OTCETA_ID")
    private kg.infosystems.buhproject.entity.enumerations.EdinicyOtcetov edinicaOtceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE3_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE4_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie4;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE5_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie5;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE6_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie6;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE6_1_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie6_1;

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
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie1> prilozenie1;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie2> prilozenie2;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie3> prilozenie3;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie4> prilozenie4;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie4_1> prilozenie41;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie4_2> prilozenie42;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie5> prilozenie5;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie6> prilozenie6;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie6_1> prilozenie61;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie7> prilozenie7;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie8_1> prilozenie81;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie8_2> prilozenie82;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PrilozeniaKPoasnitel1nojZapiskePrilozenie9> prilozenie9;
}
