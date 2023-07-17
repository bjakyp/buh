package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "PravilaProverkiUceta", schema = "catalogs")
@Getter
@Setter
public class PravilaProverkiUceta {
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

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.PravilaProverkiUceta roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VAZNOST1_PROBLEMY_ID")
    private kg.infosystems.buhproject.entity.enumerations.Vaznost1ProblemyUceta vaznost1Problemy;

	@Column(name = "IDENTIFIKATOR", length = 255)
    private String identifikator;

	@Column(name = "ISPOL1ZOVANIE")
    private Boolean ispol1zovanie;

	@Lob
	@Column(name = "PRICINY")
    private String priciny;

	@Lob
	@Column(name = "REKOMENDACIA")
    private String rekomendacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_VYPOLNENIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.SposobyVypolneniaProverki sposobVypolnenia;

	@Column(name = "IDENTIFIKATOR_REGLAMENTNOGO_ZADANIA", length = 128)
    private String identifikatorReglamentnogoZadania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOPOLNITEL1NYE_PARAMETRY_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dopolnitel1nyeParametry;

	@Column(name = "DATA_NACALA_PROVERKI")
    private LocalDateTime dataNacalaProverki;

	@Column(name = "LIMIT_PROBLEM", precision = 8, scale = 0)
    private BigDecimal limitProblem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RASPISANIE_VYPOLNENIA_PROVERKI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage raspisanieVypolneniaProverki;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@Column(name = "KONTEKST_PROVEROK_VEDENIA_UCETA", length = 10)
    private String kontekstProverokVedeniaUceta;

	@Column(name = "UTOCNENIE_KONTEKSTA_PROVEROK_VEDENIA_UCETA", length = 10)
    private String utocnenieKontekstaProverokVedeniaUceta;

	@Column(name = "PROVERKA_VEDENIA_UCETA_IZMENENA")
    private Boolean proverkaVedeniaUcetaIzmenena;

}
