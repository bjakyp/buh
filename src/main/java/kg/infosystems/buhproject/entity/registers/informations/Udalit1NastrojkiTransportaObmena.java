package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@JmixEntity
@Entity(name = "informations_Udalit1NastrojkiTransportaObmena")
@Table(name = "Udalit1NastrojkiTransportaObmenaIr", schema = "informations")
@Getter
@Setter
public class Udalit1NastrojkiTransportaObmena extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
	private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@Column(name = "COM_AUTENTIFIKACIA_OPERACIONNOJ_SISTEMY")
	private Boolean cOMAutentifikaciaOperacionnojSistemy;

	@Column(name = "COM_VARIANT_RABOTY_INFORMACIONNOJ_BAZY", precision = 1, scale = 0)
	private BigDecimal cOMVariantRabotyInformacionnojBazy;

	@Lob
	@Column(name = "COM_IMA_INFORMACIONNOJ_BAZY_NA_SERVERE1_S_PREDPRIATIA")
	private String cOMImaInformacionnojBazyNaServere1SPredpriatia;

	@Column(name = "COM_IMA_POL1ZOVATELA", length = 50)
	private String cOMImaPol1zovatela;

	@Lob
	@Column(name = "COM_IMA_SERVERA1_S_PREDPRIATIA")
	private String cOMImaServera1SPredpriatia;

	@Lob
	@Column(name = "COM_KATALOG_INFORMACIONNOJ_BAZY")
	private String cOMKatalogInformacionnojBazy;

	@Column(name = "EMAIL_MAKSIMAL1NYJ_DOPUSTIMYJ_RAZMER_SOOBSENIA", precision = 10, scale = 0)
	private BigDecimal eMAILMaksimal1nyjDopustimyjRazmerSoobsenia;

	@Column(name = "EMAIL_SZIMAT1_FAJL_ISHODASEGO_SOOBSENIA")
	private Boolean eMAILSzimat1FajlIshodasegoSoobsenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMAIL_UCETNAA_ZAPIS1_ID")
	private kg.infosystems.buhproject.entity.catalogs.UcetnyeZapisiElektronnojPocty eMAILUcetnaaZapis1;

	@Column(name = "EMAIL_TRANSLITERIROVAT1_IMENA_FAJLOV_SOOBSENIJ_OBMENA")
	private Boolean eMAILTransliterirovat1ImenaFajlovSoobsenijObmena;

	@Lob
	@Column(name = "FILE_KATALOG_OBMENA_INFORMACIEJ")
	private String fILEKatalogObmenaInformaciej;

	@Column(name = "FILE_SZIMAT1_FAJL_ISHODASEGO_SOOBSENIA")
	private Boolean fILESzimat1FajlIshodasegoSoobsenia;

	@Column(name = "FILE_TRANSLITERIROVAT1_IMENA_FAJLOV_SOOBSENIJ_OBMENA")
	private Boolean fILETransliterirovat1ImenaFajlovSoobsenijObmena;

	@Column(name = "FTP_SZIMAT1_FAJL_ISHODASEGO_SOOBSENIA")
	private Boolean fTPSzimat1FajlIshodasegoSoobsenia;

	@Column(name = "FTP_SOEDINENIE_MAKSIMAL1NYJ_DOPUSTIMYJ_RAZMER_SOOBSENIA", precision = 10, scale = 0)
	private BigDecimal fTPSoedinenieMaksimal1nyjDopustimyjRazmerSoobsenia;

	@Column(name = "FTP_SOEDINENIE_PASSIVNOE_SOEDINENIE")
	private Boolean fTPSoedineniePassivnoeSoedinenie;

	@Column(name = "FTP_SOEDINENIE_POL1ZOVATEL1", length = 50)
	private String fTPSoedineniePol1zovatel1;

	@Column(name = "FTP_SOEDINENIE_PORT", precision = 5, scale = 0)
	private BigDecimal fTPSoedineniePort;

	@Lob
	@Column(name = "FTP_SOEDINENIE_PUT1")
	private String fTPSoedineniePut1;

	@Column(name = "FTP_TRANSLITERIROVAT1_IMENA_FAJLOV_SOOBSENIJ_OBMENA")
	private Boolean fTPTransliterirovat1ImenaFajlovSoobsenijObmena;

	@Lob
	@Column(name = "WSURL_VEB_SERVISA")
	private String wSURLVebServisa;

	@Column(name = "WS_ZAPOMNIT1_PAROL1")
	private Boolean wSZapomnit1Parol1;

	@Column(name = "WS_IMA_POL1ZOVATELA", length = 165)
	private String wSImaPol1zovatela;

	@Column(name = "WS_ISPOL1ZOVAT1_PEREDACU_BOL1SOGO_OB2EMA_DANNYH")
	private Boolean wSIspol1zovat1PeredacuBol1sogoOb2emaDannyh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_TRANSPORTA_SOOBSENIJ_OBMENA_PO_UMOLCANIU_ID")
	private kg.infosystems.buhproject.entity.enumerations.VidyTransportaSoobsenijObmena vidTransportaSoobsenijObmenaPoUmolcaniu;

	@Column(name = "KOLICESTVO_ELEMENTOV_V_TRANZAKCII_VYGRUZKI_DANNYH", precision = 10, scale = 0)
	private BigDecimal kolicestvoElementovVTranzakciiVygruzkiDannyh;

	@Column(name = "KOLICESTVO_ELEMENTOV_V_TRANZAKCII_ZAGRUZKI_DANNYH", precision = 10, scale = 0)
	private BigDecimal kolicestvoElementovVTranzakciiZagruzkiDannyh;

	@Column(name = "UDALIT1_COM_PAROL1_POL1ZOVATELA", length = 50)
	private String udalit1COMParol1Pol1zovatela;

	@Column(name = "UDALIT1_FTP_SOEDINENIE_PAROL1", length = 50)
	private String udalit1FTPSoedinenieParol1;

	@Column(name = "UDALIT1_WS_PAROL1", length = 50)
	private String udalit1WSParol1;

	@Column(name = "UDALIT1_PAROL1_ARHIVA_SOOBSENIA_OBMENA", length = 50)
	private String udalit1Parol1ArhivaSoobseniaObmena;

}
