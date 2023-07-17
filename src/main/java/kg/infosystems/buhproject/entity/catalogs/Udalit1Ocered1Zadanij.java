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
@Table(name = "Udalit1Ocered1Zadanij", schema = "catalogs")
@Getter
@Setter
public class Udalit1Ocered1Zadanij {
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

	@Column(name = "NOMER_POPYTKI", precision = 3, scale = 0)
	private BigDecimal nomerPopytki;

	@Column(name = "IMA_METODA")
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

}
