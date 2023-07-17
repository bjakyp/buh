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
@Table(name = "PredopredelennyeVariantyOtcetovPredstavlenia", schema = "parts_catalogs")
@Getter
@Setter
public class PredopredelennyeVariantyOtcetovPredstavlenia {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.PredopredelennyeVariantyOtcetov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "KOD_AZYKA", length = 10)
    private String kodAzyka;

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@Lob
	@Column(name = "OPISANIE")
    private String opisanie;

	@Lob
	@Column(name = "NAIMENOVANIA_POLEJ")
    private String naimenovaniaPolej;

	@Lob
	@Column(name = "NAIMENOVANIA_PARAMETROV_I_OTBOROV")
    private String naimenovaniaParametrovIOtborov;

	@Lob
	@Column(name = "KLUCEVYE_SLOVA")
    private String klucevyeSlova;

}
