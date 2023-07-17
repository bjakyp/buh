package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "UcetnyeZapisiElektronnojPocty", schema = "catalogs")
@Getter
@Setter
public class UcetnyeZapisiElektronnojPocty {
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

	@Column(name = "NAIMENOVANIE", length = 50)
	private String naimenovanie;

	@Column(name = "ADRES_ELEKTRONNOJ_POCTY")
	private String adresElektronnojPocty;

	@Column(name = "VREMA_OZIDANIA", precision = 3, scale = 0)
	private BigDecimal vremaOzidania;

	@Column(name = "IMA_POL1ZOVATELA", length = 100)
	private String imaPol1zovatela;

	@Column(name = "ISPOL1ZOVAT1_DLA_OTPRAVKI")
	private Boolean ispol1zovat1DlaOtpravki;

	@Column(name = "ISPOL1ZOVAT1_DLA_POLUCENIA")
	private Boolean ispol1zovat1DlaPolucenia;

	@Column(name = "ISPOL1ZOVAT1_ZASISENNOE_SOEDINENIE_DLA_VHODASEJ_POCTY")
	private Boolean ispol1zovat1ZasisennoeSoedinenieDlaVhodasejPocty;

	@Column(name = "ISPOL1ZOVAT1_ZASISENNOE_SOEDINENIE_DLA_ISHODASEJ_POCTY")
	private Boolean ispol1zovat1ZasisennoeSoedinenieDlaIshodasejPocty;

	@Column(name = "OSTAVLAT1_KOPII_SOOBSENIJ_NA_SERVERE")
	private Boolean ostavlat1KopiiSoobsenijNaServere;

	@Column(name = "PERIOD_HRANENIA_SOOBSENIJ_NA_SERVERE", precision = 3, scale = 0)
	private BigDecimal periodHraneniaSoobsenijNaServere;

	@Column(name = "POL1ZOVATEL1", length = 100)
	private String pol1zovatel1;

	@Column(name = "POL1ZOVATEL1_SMTP", length = 100)
	private String pol1zovatel1SMTP;

	@Column(name = "PORT_SERVERA_VHODASEJ_POCTY", precision = 5, scale = 0)
	private BigDecimal portServeraVhodasejPocty;

	@Column(name = "PORT_SERVERA_ISHODASEJ_POCTY", precision = 5, scale = 0)
	private BigDecimal portServeraIshodasejPocty;

	@Column(name = "PROTOKOL_VHODASEJ_POCTY", length = 4)
	private String protokolVhodasejPocty;

	@Column(name = "SERVER_VHODASEJ_POCTY", length = 300)
	private String serverVhodasejPocty;

	@Column(name = "SERVER_ISHODASEJ_POCTY", length = 300)
	private String serverIshodasejPocty;

	@Column(name = "TREBUETSA_VHOD_NA_SERVER_PERED_OTPRAVKOJ")
	private Boolean trebuetsaVhodNaServerPeredOtpravkoj;

	@Column(name = "OTPRAVLAT1_SKRYTYE_KOPII_PISEM_NA_ETOT_ADRES")
	private Boolean otpravlat1SkrytyeKopiiPisemNaEtotAdres;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_UCETNOJ_ZAPISI_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli vladelecUcetnojZapisi;

	@Column(name = "PRI_OTPRAVKE_PISEM_TREBUETSA_AVTORIZACIA")
	private Boolean priOtpravkePisemTrebuetsaAvtorizacia;

}
