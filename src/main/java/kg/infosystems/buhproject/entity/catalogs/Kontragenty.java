package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.KontragentyDopolnitel1nyeRekvizity;
import kg.infosystems.buhproject.entity.parts.catalogs.KontragentyKontaktnaaInformacia;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "Kontragenty", schema = "catalogs")
@Getter
@Setter
public class Kontragenty {
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

	@Column(name = "KOD", length = 9)
    private String kod;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Kontragenty roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@Column(name = "NAIMENOVANIE_POLNOE", length = 1024)
    private String naimenovaniePolnoe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GOLOVNOJ_KONTRAGENT_ID")
    private kg.infosystems.buhproject.entity.catalogs.Kontragenty golovnojKontragent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOD_PRAVOVOJ_FORMY_ID")
    private kg.infosystems.buhproject.entity.enumerations.KodyPravovojFormy kodPravovojFormy;

	@Column(name = "INN", length = 14)
    private String iNN;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UR_FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.enumerations.UridiceskoeFiziceskoeLico urFizLico;

	@Column(name = "KOD_PO_OKPO", length = 10)
    private String kodPoOKPO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OSNOVNOJ_BANKOVSKIJ_SCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta osnovnojBankovskijScet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GNS_ID")
    private kg.infosystems.buhproject.entity.catalogs.GNS gNS;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STRANA_REZIDENTSTVA_ID")
    private kg.infosystems.buhproject.entity.catalogs.StranyMira stranaRezidentstva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RAJONNOE_OTDELENIE_KAZNACEJSTVA_ID")
    private kg.infosystems.buhproject.entity.catalogs.RajonnoeOtdelenieKaznacejstva rajonnoeOtdelenieKaznacejstva;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<KontragentyDopolnitel1nyeRekvizity> dopolnitel1nyeRekvizity;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<KontragentyKontaktnaaInformacia> kontaktnaaInformacia;
}
