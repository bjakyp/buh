package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.KorrektirovkaDolgaDebitorskaaZadolzennost1;
import kg.infosystems.buhproject.entity.parts.documents.KorrektirovkaDolgaKreditorskaaZadolzennost1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "KorrektirovkaDolga", schema = "documents")
@Getter
@Setter
public class KorrektirovkaDolga {
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
	private kg.infosystems.buhproject.entity.enumerations.VidyOperacijKorrektirovkaDolga vidOperacii;

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
	@JoinColumn(name = "KONTRAGENT_DEBITOR_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragentDebitor;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "KONTRAGENT_KREDITOR_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragentKreditor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_DT_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_DT1_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoDt1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_DT2_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoDt2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_DT3_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoDt3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_KT_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetKt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_KT1_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoKt1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_KT2_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoKt2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_KT3_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoKt3;

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
	private List<KorrektirovkaDolgaDebitorskaaZadolzennost1> debitorskaaZadolzennost1;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<KorrektirovkaDolgaKreditorskaaZadolzennost1> kreditorskaaZadolzennost1;
}
