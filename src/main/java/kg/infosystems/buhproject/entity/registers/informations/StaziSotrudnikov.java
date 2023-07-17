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
@Entity(name = "informations_StaziSotrudnikov")
@Table(name = "StaziSotrudnikovIr", schema = "informations")
@Getter
@Setter
public class StaziSotrudnikov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGISTRATOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registrator;

	@Column(name = "PERIOD")
    private LocalDateTime period;

	@Column(name = "NOMER_STROKI", precision = 9, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "AKTIVNOST1")
    private Boolean aktivnost1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@Column(name = "KOLICESTVO_LET", precision = 2, scale = 0)
    private BigDecimal kolicestvoLet;

	@Column(name = "KOLICESTVO_MESACEV", precision = 2, scale = 0)
    private BigDecimal kolicestvoMesacev;

	@Column(name = "KOLICESTVO_DNEJ", precision = 2, scale = 0)
    private BigDecimal kolicestvoDnej;

}
