package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.documents.EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvamDohody;
import kg.infosystems.buhproject.entity.parts.documents.EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvamRashody;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvam", schema = "documents")
@Getter
@Setter
public class EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvam {
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
	@JoinColumn(name = "BANKOVSKIJ_SCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScet;

	@Column(name = "OKRUGLAT1_DANNYE")
    private Boolean okruglat1Dannye;

	@Column(name = "ISPOL1ZOVAT1_GRUPPU_SCETOV")
    private Boolean ispol1zovat1GruppuScetov;

	@Column(name = "NE_VYVODIT1_DANNYE_PO_ELEMENTAM")
    private Boolean neVyvodit1DannyePoElementam;

	@Column(name = "NE_UCITYVAT1_SUMMY_PO_DANNYM_SMETY")
    private Boolean neUcityvat1SummyPoDannymSmety;

	@Column(name = "VYVODIT1_KOLONKU_OSTATOK")
    private Boolean vyvodit1KolonkuOstatok;

	@Column(name = "UTVERZDENO_PO_SMETE_NA_GOD")
    private Boolean utverzdenoPoSmeteNaGod;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_BANKOVSKIH_SCETOV_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseBankovskihScetov;

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
	private List<EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvamRashody> rashody;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvamDohody> dohody;
}
