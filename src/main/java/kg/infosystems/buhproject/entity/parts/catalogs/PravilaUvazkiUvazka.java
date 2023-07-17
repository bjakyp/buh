package kg.infosystems.buhproject.entity.parts.catalogs;

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
@Table(name = "PravilaUvazkiUvazka", schema = "parts_catalogs")
@Getter
@Setter
public class PravilaUvazkiUvazka {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.PravilaUvazki part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "PRILOZENIE", length = 100)
    private String prilozenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEVAA_FORMULA_ID")
    private kg.infosystems.buhproject.entity.catalogs.FormulyUvazki levaaFormula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVAA_FORMULA_ID")
    private kg.infosystems.buhproject.entity.catalogs.FormulyUvazki pravaaFormula;

}
