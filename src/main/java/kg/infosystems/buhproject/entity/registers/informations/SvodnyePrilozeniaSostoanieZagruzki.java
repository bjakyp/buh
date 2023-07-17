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
@Entity(name = "informations_SvodnyePrilozeniaSostoanieZagruzki")
@Table(name = "SvodnyePrilozeniaSostoanieZagruzkiIr", schema = "informations")
@Getter
@Setter
public class SvodnyePrilozeniaSostoanieZagruzki extends BaseEntity {
	@Column(name = "KOD_UZLA", length = 36)
    private String kodUzla;

	@Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

	@Column(name = "NOMER_PRINATOGO_SOOBSENIA", precision = 5, scale = 0)
    private BigDecimal nomerPrinatogoSoobsenia;

	@Column(name = "ZAGRUZENO_OB2EKTOV", precision = 10, scale = 0)
    private BigDecimal zagruzenoOb2ektov;

	@Column(name = "DATA_POSLEDNEJ_ZAGRUZKI")
    private LocalDateTime dataPoslednejZagruzki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKTY_DLA_OCISTKI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage ob2ektyDlaOcistki;

	@Column(name = "DATA_ZAVERSENIA")
    private LocalDateTime dataZaversenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOOTVETSTVIE_SSYLOK_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage sootvetstvieSsylok;

	@Column(name = "ZAVERSENO_S_OSIBKAMI")
    private Boolean zaversenoSOsibkami;

	@Lob
	@Column(name = "OPISANIE_OSIBKI")
    private String opisanieOsibki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATELI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage pol1zovateli;

	@Column(name = "KOLICESTVO_POPYTOK", precision = 1, scale = 0)
    private BigDecimal kolicestvoPopytok;

	@Column(name = "TREBUETSA_POVTORNAA_OTPRAVKA")
    private Boolean trebuetsaPovtornaaOtpravka;

	@Column(name = "TREBUETSA_POVTORNAA_VYGRUZKA")
    private Boolean trebuetsaPovtornaaVygruzka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVILA_POISKA_NSI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage pravilaPoiskaNSI;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_OBMENA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple uzelObmena;

}
