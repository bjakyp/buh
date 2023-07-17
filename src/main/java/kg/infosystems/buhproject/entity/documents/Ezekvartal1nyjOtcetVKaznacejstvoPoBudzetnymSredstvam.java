package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.documents.Ezekvartal1nyjOtcetVKaznacejstvoPoBudzetnymSredstvamBudzetnyeRashody;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "Ezekvartal1nyjOtcetVKaznacejstvoPoBudzetnymSredstvam", schema = "documents")
@Getter
@Setter
public class Ezekvartal1nyjOtcetVKaznacejstvoPoBudzetnymSredstvam {
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

	@Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

	@Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScet;

	@Column(name = "OKRUGLAT1_DANNYE")
    private Boolean okruglat1Dannye;

	@Column(name = "ISPOL1ZOVAT1_GRUPPU_SCETOV")
    private Boolean ispol1zovat1GruppuScetov;

	@Column(name = "OTKRYTO_KREDITOV_PO_ELEMENTAM")
    private Boolean otkrytoKreditovPoElementam;

	@Column(name = "UTVERZDENO_PO_SMETE_NA_OTCETNYJ_PERIOD")
    private Boolean utverzdenoPoSmeteNaOtcetnyjPeriod;

	@Column(name = "SMETA_PO_STAT1AM_RASHODY_PO_ELEMENTAM")
    private Boolean smetaPoStat1amRashodyPoElementam;

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
	private List<Ezekvartal1nyjOtcetVKaznacejstvoPoBudzetnymSredstvamBudzetnyeRashody> budzetnyeRashody;
}
