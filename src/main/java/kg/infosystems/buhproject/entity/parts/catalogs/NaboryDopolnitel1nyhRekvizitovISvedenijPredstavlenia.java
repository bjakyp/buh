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
@Table(name = "NaboryDopolnitel1nyhRekvizitovISvedenijPredstavlenia", schema = "parts_catalogs")
@Getter
@Setter
public class NaboryDopolnitel1nyhRekvizitovISvedenijPredstavlenia {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryDopolnitel1nyhRekvizitovISvedenij part;

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

}
