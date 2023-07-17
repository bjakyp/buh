package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.documents.PlateznoePorucenieIshodaseeRassifrovkaPlateza;
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
@Table(name = "PlateznoePorucenieIshodasee", schema = "documents")
@Getter
@Setter
public class PlateznoePorucenieIshodasee {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_OPERACII_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyOperacijPPI vidOperacii;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ORGANIZACIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_ID")
	private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONTRAGENT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_KONTRAGENTA_ID")
	private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScetKontragenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_SOTRUDNIKA_ID")
	private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScetSotrudnika;

	@Column(name = "OPLACENO")
	private Boolean oplaceno;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaDokumenta;

	@Column(name = "TEKST_PLATEL1SIKA", length = 200)
	private String tekstPlatel1sika;

	@Column(name = "TEKST_POLUCATELA", length = 200)
	private String tekstPolucatela;

	@Column(name = "TEKST_NAZNACENIA_PLATEZA", length = 200)
	private String tekstNaznaceniaPlateza;

	@Column(name = "PECAT1_V_RAMKE")
	private Boolean pecat1VRamke;

	@Column(name = "PECAT1_LICEVOGO_SCETA")
	private Boolean pecat1LicevogoSceta;

	@Column(name = "PECAT1_RASCETNOGO_SCETA")
	private Boolean pecat1RascetnogoSceta;

	@Column(name = "SNIMAT1_KOMISSIU_BANKA")
	private Boolean snimat1KomissiuBanka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
	private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

	@Column(name = "KOMISSIA_BANKA", precision = 15, scale = 2)
	private BigDecimal komissiaBanka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_ZATRAT_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetZatrat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_DT_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_KT_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetKt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOD_PLATEZA_ID")
	private kg.infosystems.buhproject.entity.catalogs.KodyPlatezej kodPlateza;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_OSNOVANIE_ID")
	private kg.infosystems.buhproject.entity.one.Multiple dokumentOsnovanie;

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
	private List<PlateznoePorucenieIshodaseeRassifrovkaPlateza> rassifrovkaPlateza;
}
