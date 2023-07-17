package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_NastrojkiTransportaObmenaOblastejDannyh")
@Table(name = "NastrojkiTransportaObmenaOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class NastrojkiTransportaObmenaOblastejDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONECNAA_TOCKA_KORRESPONDENTA_ID")
    private kg.infosystems.buhproject.entity.publications.ObmenSoobseniami konecnaaTockaKorrespondenta;

	@Lob
	@Column(name = "FILE_KATALOG_OBMENA_INFORMACIEJ")
    private String fILEKatalogObmenaInformaciej;

	@Column(name = "FILE_SZIMAT1_FAJL_ISHODASEGO_SOOBSENIA")
    private Boolean fILESzimat1FajlIshodasegoSoobsenia;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_TRANSPORTA_SOOBSENIJ_OBMENA_PO_UMOLCANIU_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyTransportaSoobsenijObmena vidTransportaSoobsenijObmenaPoUmolcaniu;

	@Column(name = "UDALIT1_FTP_SOEDINENIE_PAROL1", length = 50)
    private String udalit1FTPSoedinenieParol1;

	@Column(name = "UDALIT1_PAROL1_ARHIVA_SOOBSENIA_OBMENA", length = 50)
    private String udalit1Parol1ArhivaSoobseniaObmena;

}
