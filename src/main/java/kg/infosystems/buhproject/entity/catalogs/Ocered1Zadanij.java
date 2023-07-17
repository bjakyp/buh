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
@Table(name = "Ocered1Zadanij", schema = "catalogs")
@Getter
@Setter
public class Ocered1Zadanij {
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

	@Column(name = "ISPOL1ZOVANIE")
    private Boolean ispol1zovanie;

	@Column(name = "ZAPLANIROVANNYJ_MOMENT_ZAPUSKA")
    private LocalDateTime zaplanirovannyjMomentZapuska;

	@Column(name = "MILLISEKUNDY", precision = 3, scale = 0)
    private BigDecimal millisekundy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTOANIE_ZADANIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.SostoaniaZadanij sostoanieZadania;

	@Column(name = "ISPOLNAUSEE_FONOVOE_ZADANIE")
    private UUID ispolnauseeFonovoeZadanie;

	@Column(name = "EKSKLUZIVNOE_VYPOLNENIE")
    private Boolean ekskluzivnoeVypolnenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SABLON_ID")
    private kg.infosystems.buhproject.entity.catalogs.SablonyZadanijOceredi sablon;

	@Column(name = "NOMER_POPYTKI", precision = 3, scale = 0)
    private BigDecimal nomerPopytki;

	@Column(name = "IMA_METODA", length = 255)
    private String imaMetoda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARAMETRY_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage parametry;

	@Column(name = "DATA_NACALA_POSLEDNEGO_ZAPUSKA")
    private LocalDateTime dataNacalaPoslednegoZapuska;

	@Column(name = "DATA_ZAVERSENIA_POSLEDNEGO_ZAPUSKA")
    private LocalDateTime dataZaverseniaPoslednegoZapuska;

	@Column(name = "KLUC", length = 128)
    private String kluc;

	@Column(name = "INTERVAL_POVTORA_PRI_AVARIJNOM_ZAVERSENII", precision = 10, scale = 0)
    private BigDecimal intervalPovtoraPriAvarijnomZaversenii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RASPISANIE_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage raspisanie;

	@Column(name = "KOLICESTVO_POVTOROV_PRI_AVARIJNOM_ZAVERSENII", precision = 10, scale = 0)
    private BigDecimal kolicestvoPovtorovPriAvarijnomZaversenii;

	@Column(name = "IMA_POL1ZOVATELA", length = 32)
    private String imaPol1zovatela;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
