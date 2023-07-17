package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.PrihodnyjKassovyjOrderRassifrovkaPlateza;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "PrihodnyjKassovyjOrder", schema = "documents")
@Getter
@Setter
public class PrihodnyjKassovyjOrder {
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

	@Column(name = "PERIOD_NOMERA")
	private LocalDateTime periodNomera;

	@Column(name = "NOMER", length = 11)
	private String nomer;

	@Column(name = "PROVEDEN")
	private Boolean proveden;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_OPERACII_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyOperacijPKO vidOperacii;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ORGANIZACIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "KASSA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Kassy kassa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_ID")
	private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONTRAGENT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaDokumenta;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_RASCETOV_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetRascetov;

	@Column(name = "PRINATO_OT", length = 150)
	private String prinatoOt;

	@Column(name = "OSNOVANIE", length = 150)
	private String osnovanie;

	@Column(name = "PRILOZENIE", length = 150)
	private String prilozenie;

	@Column(name = "PO_DOKUMENTU", length = 150)
	private String poDokumentu;

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
	private List<PrihodnyjKassovyjOrderRassifrovkaPlateza> rassifrovkaPlateza;
}
