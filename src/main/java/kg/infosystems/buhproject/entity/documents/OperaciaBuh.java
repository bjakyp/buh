package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.documents.OperaciaBuhTablicaRegistrovNakoplenia;
import kg.infosystems.buhproject.entity.parts.documents.OperaciaBuhTablicaRegistrovSvedenij;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "OperaciaBuh", schema = "documents")
@Getter
@Setter
public class OperaciaBuh {
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

	@Column(name = "PERIOD_NOMERA")
    private LocalDateTime periodNomera;

	@Column(name = "NOMER", length = 11)
    private String nomer;

	@Column(name = "PROVEDEN")
    private Boolean proveden;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@Column(name = "SUMMA_OPERACII", precision = 15, scale = 2)
    private BigDecimal summaOperacii;

	@Column(name = "SODERZANIE", length = 250)
    private String soderzanie;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
    private BigDecimal summaDokumenta;

	@Column(name = "SPOSOB_ZAPOLNENIA", length = 50)
    private String sposobZapolnenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STORNIRUEMYJ_DOKUMENT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple storniruemyjDokument;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTVETSTVENNYJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli otvetstvennyj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPOVAA_OPERACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.TipovyeOperacii tipovaaOperacia;

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
	private List<OperaciaBuhTablicaRegistrovSvedenij> tablicaRegistrovSvedenij;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<OperaciaBuhTablicaRegistrovNakoplenia> tablicaRegistrovNakoplenia;
}
