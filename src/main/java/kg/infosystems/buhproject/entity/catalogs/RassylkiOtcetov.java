package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.RassylkiOtcetovFormatyOtcetov;
import kg.infosystems.buhproject.entity.parts.catalogs.RassylkiOtcetovOtcety;
import kg.infosystems.buhproject.entity.parts.catalogs.RassylkiOtcetovPolucateli;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "RassylkiOtcetov", schema = "catalogs")
@Getter
@Setter
public class RassylkiOtcetov {
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
    private kg.infosystems.buhproject.entity.catalogs.RassylkiOtcetov roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@Column(name = "FTP_KATALOG", length = 200)
    private String fTPKatalog;

	@Column(name = "FTP_LOGIN", length = 50)
    private String fTPLogin;

	@Column(name = "FTP_PASSIVNOE_SOEDINENIE")
    private Boolean fTPPassivnoeSoedinenie;

	@Column(name = "FTP_PORT", precision = 5, scale = 0)
    private BigDecimal fTPPort;

	@Column(name = "FTP_SERVER", length = 100)
    private String fTPServer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

	@Column(name = "ADRES_OTVETA", length = 100)
    private String adresOtveta;

	@Column(name = "ARHIVIROVAT1")
    private Boolean arhivirovat1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_POCTOVOGO_ADRESA_POLUCATELEJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyKontaktnojInformacii vidPoctovogoAdresaPolucatelej;

	@Column(name = "VYPOLNAT1_PO_RASPISANIU")
    private Boolean vypolnat1PoRaspisaniu;

	@Column(name = "IMA_ARHIVA", length = 75)
    private String imaArhiva;

	@Column(name = "ISPOL1ZOVAT1_FTP_RESURS")
    private Boolean ispol1zovat1FTPResurs;

	@Column(name = "ISPOL1ZOVAT1_PAPKU")
    private Boolean ispol1zovat1Papku;

	@Column(name = "ISPOL1ZOVAT1_SETEVOJ_KATALOG")
    private Boolean ispol1zovat1SetevojKatalog;

	@Column(name = "ISPOL1ZOVAT1_ELEKTRONNUU_POCTU")
    private Boolean ispol1zovat1ElektronnuuPoctu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KARTINKI_PIS1MA_V_FORMATE_HTML_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage kartinkiPis1maVFormateHTML;

	@Column(name = "LICNAA")
    private Boolean licnaa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAPKA_ID")
    private kg.infosystems.buhproject.entity.catalogs.PapkiFajlov papka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERIODICNOST1_RASPISANIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.PeriodicnostiRaspisanijRassylokOtcetov periodicnost1Raspisania;

	@Column(name = "PERSONALIZIROVANA")
    private Boolean personalizirovana;

	@Column(name = "PIS1MO_V_FORMATE_HTML")
    private Boolean pis1moVFormateHTML;

	@Column(name = "PODGOTOVLENA")
    private Boolean podgotovlena;

	@Column(name = "REGLAMENTNOE_ZADANIE")
    private UUID reglamentnoeZadanie;

	@Column(name = "SETEVOJ_KATALOG_LINUX", length = 200)
    private String setevojKatalogLinux;

	@Column(name = "SETEVOJ_KATALOG_WINDOWS", length = 200)
    private String setevojKatalogWindows;

	@Column(name = "SKRYTYE_KOPII")
    private Boolean skrytyeKopii;

	@Lob
	@Column(name = "TEKST_PIS1MA")
    private String tekstPis1ma;

	@Lob
	@Column(name = "TEKST_PIS1MA_V_FORMATE_HTML")
    private String tekstPis1maVFormateHTML;

	@Lob
	@Column(name = "TEMA_PIS1MA")
    private String temaPis1ma;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_POLUCATELEJ_RASSYLKI_ID")
    private kg.infosystems.buhproject.entity.one.Multiple tipPolucatelejRassylki;

	@Column(name = "TOL1KO_UVEDOMIT1")
    private Boolean tol1koUvedomit1;

	@Column(name = "TRANSLITERIROVAT1_IMENA_FAJLOV")
    private Boolean transliterirovat1ImenaFajlov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCETNAA_ZAPIS1_ID")
    private kg.infosystems.buhproject.entity.catalogs.UcetnyeZapisiElektronnojPocty ucetnaaZapis1;

	@Column(name = "VKLUCAT1_DATU_V_IMA_FAJLA")
    private Boolean vklucat1DatuVImaFajla;

	@Column(name = "SOZDANA_IZ_FORMY_OTCETA")
    private Boolean sozdanaIzFormyOtceta;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<RassylkiOtcetovOtcety> otcety;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<RassylkiOtcetovFormatyOtcetov> formatyOtcetov;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<RassylkiOtcetovPolucateli> polucateli;
}
