package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.parts.catalogs.VidyKontaktnojInformaciiPredstavlenia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VidyKontaktnojInformacii", schema = "catalogs")
@Getter
@Setter
public class VidyKontaktnojInformacii {
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
	private kg.infosystems.buhproject.entity.catalogs.VidyKontaktnojInformacii roditel1;

	@Column(name = "ETO_GRUPPA")
	private Boolean etoGruppa;

	@Column(name = "TOL1KO_NACIONAL1NYJ_ADRES")
	private Boolean tol1koNacional1nyjAdres;

	@Column(name = "VID_REDAKTIROVANIA", length = 20)
	private String vidRedaktirovania;

	@Column(name = "VID_POLA_DRUGOE", length = 20)
	private String vidPolaDrugoe;

	@Column(name = "VKLUCAT1_STRANU_V_PREDSTAVLENIE")
	private Boolean vklucat1StranuVPredstavlenie;

	@Column(name = "ZAPRETIT1_REDAKTIROVANIE_POL1ZOVATELEM")
	private Boolean zapretit1RedaktirovaniePol1zovatelem;

	@Column(name = "ISPOL1ZUETSA")
	private Boolean ispol1zuetsa;

	@Column(name = "MOZNO_IZMENAT1_SPOSOB_REDAKTIROVANIA")
	private Boolean moznoIzmenat1SposobRedaktirovania;

	@Column(name = "OBAZATEL1NOE_ZAPOLNENIE")
	private Boolean obazatel1noeZapolnenie;

	@Column(name = "PROVERAT1_KORREKTNOST1")
	private Boolean proverat1Korrektnost1;

	@Column(name = "PROVERAT1_PO_FIAS")
	private Boolean proverat1PoFIAS;

	@Column(name = "RAZRESIT1_VVOD_NESKOL1KIH_ZNACENIJ")
	private Boolean razresit1VvodNeskol1kihZnacenij;

	@Column(name = "UDALIT1_REDAKTIROVANIE_TOL1KO_V_DIALOGE")
	private Boolean udalit1RedaktirovanieTol1koVDialoge;

	@Column(name = "REKVIZIT_DOP_UPORADOCIVANIA", precision = 5, scale = 0)
	private BigDecimal rekvizitDopUporadocivania;

	@Column(name = "SKRYVAT1_NEAKTUAL1NYE_ADRESA")
	private Boolean skryvat1Neaktual1nyeAdresa;

	@Column(name = "TELEFON_C_DOBAVOCNYM_NOMEROM")
	private Boolean telefonCDobavocnymNomerom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_ID")
	private kg.infosystems.buhproject.entity.enumerations.TipyKontaktnojInformacii tip;

	@Column(name = "UKAZYVAT1_OKTMO")
	private Boolean ukazyvat1OKTMO;

	@Column(name = "HRANIT1_ISTORIU_IZMENENIJ")
	private Boolean hranit1IstoriuIzmenenij;

	@Column(name = "MEZDUNARODNYJ_FORMAT_ADRESA")
	private Boolean mezdunarodnyjFormatAdresa;

	@Column(name = "IMA_PREDOPREDELENNOGO_VIDA", length = 150)
	private String imaPredopredelennogoVida;

	@Column(name = "IMA_GRUPPY", length = 150)
	private String imaGruppy;

	@Column(name = "ISPRAVLAT1_USTAREVSIE_ADRESA")
	private Boolean ispravlat1UstarevsieAdresa;

	@Column(name = "IDENTIFIKATOR_DLA_FORMUL", length = 150)
	private String identifikatorDlaFormul;

	@Column(name = "MASKA_NOMERA_TELEFONA", length = 150)
	private String maskaNomeraTelefona;

	@Column(name = "VVODIT1_NOMER_PO_MASKE")
	private Boolean vvodit1NomerPoMaske;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<VidyKontaktnojInformaciiPredstavlenia> predstavlenia;

}
