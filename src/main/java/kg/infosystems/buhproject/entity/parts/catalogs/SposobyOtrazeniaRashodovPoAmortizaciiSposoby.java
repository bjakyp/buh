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
@Table(name = "SposobyOtrazeniaRashodovPoAmortizaciiSposoby", schema = "parts_catalogs")
@Getter
@Setter
public class SposobyOtrazeniaRashodovPoAmortizaciiSposoby {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaRashodovPoAmortizacii part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_ZATRAT_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetZatrat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkonto1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO2_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkonto2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO3_ID")
    private kg.infosystems.buhproject.entity.one.Multiple subkonto3;

	@Column(name = "KOEFFICIENT", precision = 6, scale = 3)
    private BigDecimal koefficient;

}
