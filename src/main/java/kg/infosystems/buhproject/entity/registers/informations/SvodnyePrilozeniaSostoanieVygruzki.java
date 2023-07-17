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
@Entity(name = "informations_SvodnyePrilozeniaSostoanieVygruzki")
@Table(name = "SvodnyePrilozeniaSostoanieVygruzkiIr", schema = "informations")
@Getter
@Setter
public class SvodnyePrilozeniaSostoanieVygruzki extends BaseEntity {
	@Column(name = "KOD_UZLA", length = 36)
    private String kodUzla;

	@Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

	@Lob
	@Column(name = "ADRES_PRILOZENIA")
    private String adresPrilozenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_OBMENA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple uzelObmena;

	@Column(name = "NOMER_OTPRAVLENNOGO_SOOBSENIA", precision = 5, scale = 0)
    private BigDecimal nomerOtpravlennogoSoobsenia;

	@Column(name = "NOMER_PRINATOGO_SOOBSENIA", precision = 5, scale = 0)
    private BigDecimal nomerPrinatogoSoobsenia;

	@Column(name = "IZMENENO_OB2EKTOV", precision = 10, scale = 0)
    private BigDecimal izmenenoOb2ektov;

	@Column(name = "VYGRUZENO_OB2EKTOV", precision = 10, scale = 0)
    private BigDecimal vygruzenoOb2ektov;

	@Column(name = "ZAGRUZENO_OB2EKTOV", precision = 10, scale = 0)
    private BigDecimal zagruzenoOb2ektov;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@Column(name = "POSLEDNIJ_OB2EKT_METADANNYH", length = 430)
    private String poslednijOb2ektMetadannyh;

	@Column(name = "DATA_ZAVERSENIA")
    private LocalDateTime dataZaversenia;

	@Column(name = "DATA_SOSTOANIA_ZAGRUZKI")
    private LocalDateTime dataSostoaniaZagruzki;

	@Column(name = "KOLICESTVO_POPYTOK", precision = 1, scale = 0)
    private BigDecimal kolicestvoPopytok;

	@Column(name = "DATA_POSLEDNEJ_VYGRUZKI")
    private LocalDateTime dataPoslednejVygruzki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTOANIE_ID")
    private kg.infosystems.buhproject.entity.enumerations.SostoaniaMigraciiPrilozenia sostoanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOPOLNITEL1NYE_SVOJSTVA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dopolnitel1nyeSvojstva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INICIATOR_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli iniciator;

	@Column(name = "DATA_NACALA_VYGRUZKI")
    private LocalDateTime dataNacalaVygruzki;

	@Column(name = "VYGRUZKA_PO_TREBOVANIU")
    private Boolean vygruzkaPoTrebovaniu;

}
